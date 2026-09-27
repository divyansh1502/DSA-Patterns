````md
# 🪟 Sliding Window Patterns

Sliding Window is a technique for solving problems involving **contiguous subarrays or substrings** by maintaining a range `[left, right]` and efficiently updating that range as it moves.

---

## 📌 Table of Contents

1. [What Is Sliding Window?](#what-is-sliding-window)
2. [Why Sliding Window?](#why-sliding-window)
3. [Core Mental Model](#core-mental-model)
4. [The Fundamental Window Structure](#the-fundamental-window-structure)
5. [When to Think of Sliding Window](#when-to-think-of-sliding-window)
6. [When NOT to Think of Sliding Window](#when-not-to-think-of-sliding-window)
7. [The Main Sliding Window Patterns](#the-main-sliding-window-patterns)
8. [Pattern 1 — Fixed-Size Window](#pattern-1--fixed-size-window)
9. [Pattern 2 — Variable-Size Window](#pattern-2--variable-size-window)
10. [Pattern 3 — Longest Valid Window](#pattern-3--longest-valid-window)
11. [Pattern 4 — Smallest Valid Window](#pattern-4--smallest-valid-window)
12. [Pattern 5 — Frequency / HashMap Window](#pattern-5--frequency--hashmap-window)
13. [Pattern 6 — Counting Valid Windows](#pattern-6--counting-valid-windows)
14. [Pattern 7 — At Most / Exactly K](#pattern-7--at-most--exactly-k)
15. [Pattern 8 — Character / String Window](#pattern-8--character--string-window)
16. [Pattern 9 — Window With Monotonic Deque](#pattern-9--window-with-monotonic-deque)
17. [How to Decide Which Pointer to Move](#how-to-decide-which-pointer-to-move)
18. [How to Decide When the Window Is Valid](#how-to-decide-when-the-window-is-valid)
19. [How to Decide When to Shrink the Window](#how-to-decide-when-to-shrink-the-window)
20. [How to Decide What to Store in the Window](#how-to-decide-what-to-store-in-the-window)
21. [How to Decide the Termination Condition](#how-to-decide-the-termination-condition)
22. [How to Approach a LeetCode/GFG Problem](#how-to-approach-a-leetcodegfg-problem)
23. [Canonical Java Templates](#canonical-java-templates)
24. [Important Sliding Window Problems](#important-sliding-window-problems)
25. [Solved Example — Maximum Sum Subarray of Size K](#solved-example--maximum-sum-subarray-of-size-k)
26. [Solved Example — Maximum Number of Vowels in a Substring](#solved-example--maximum-number-of-vowels-in-a-substring)
27. [Solved Example — Longest Substring Without Repeating Characters](#solved-example--longest-substring-without-repeating-characters)
28. [Solved Example — Longest Subarray With Sum ≤ K](#solved-example--longest-subarray-with-sum--k)
29. [Solved Example — Minimum Size Subarray Sum](#solved-example--minimum-size-subarray-sum)
30. [Solved Example — Fruit Into Baskets](#solved-example--fruit-into-baskets)
31. [Solved Example — Longest Repeating Character Replacement](#solved-example--longest-repeating-character-replacement)
32. [Solved Example — Permutation in String](#solved-example--permutation-in-string)
33. [Solved Example — Minimum Window Substring](#solved-example--minimum-window-substring)
34. [Solved Example — Sliding Window Maximum](#solved-example--sliding-window-maximum)
35. [Common Mistakes](#common-mistakes)
36. [Brute Force vs Sliding Window](#brute-force-vs-sliding-window)
37. [Time and Space Complexity](#time-and-space-complexity)
38. [Advantages](#advantages)
39. [Disadvantages](#disadvantages)
40. [Edge Cases Checklist](#edge-cases-checklist)
41. [Sliding Window Problem-Solving Checklist](#sliding-window-problem-solving-checklist)
42. [Interview 30-Second Answer](#interview-30-second-answer)
43. [Cheat Sheet](#cheat-sheet)

---

# 🪟 1. What Is Sliding Window?

Sliding Window is an algorithmic technique used primarily for problems involving **contiguous portions** of an array or string.

A window is simply a range:

```text
[left ........ right]
```

Instead of repeatedly calculating information for every possible subarray or substring, we maintain information about the current window and move it efficiently.

The two important variables are usually:

```text
left
right
```

`right` generally expands the window.

`left` generally shrinks the window.

### Example

Consider:

```text
[2, 4, 1, 7, 3, 6]
```

Suppose the window contains:

```text
[2, 4, 1]
 ↑     ↑
left  right
```

Move `right`:

```text
[2, 4, 1, 7]
 ↑        ↑
left     right
```

Move `left`:

```text
2 [4, 1, 7]
   ↑     ↑
  left  right
```

The window is continuously **sliding** across the data.

---

# 🎯 2. Why Sliding Window?

Suppose we need the maximum sum of a subarray of size `k`.

For:

```text
[2, 4, 1, 7, 3, 6]
```

and:

```text
k = 3
```

A brute-force approach calculates:

```text
2 + 4 + 1
4 + 1 + 7
1 + 7 + 3
7 + 3 + 6
```

Many values are recalculated.

For example:

```text
2 + 4 + 1
    4 + 1 + 7
```

The values `4` and `1` appear in both windows.

Sliding Window reuses this information.

Instead of calculating:

```text
4 + 1 + 7
```

from scratch:

```text
oldSum - outgoingElement + incomingElement
```

So:

```text
7 + 1
```

can be obtained from:

```text
2 + 4 + 1
```

by:

```text
remove 2
add 7
```

This reduces many problems from:

```text
O(n × k)
```

to:

```text
O(n)
```

---

# 🧠 3. Core Mental Model

The most important thing is not memorizing a template.

You should understand:

> **What does my current window represent?**

For every problem, identify:

```text
left
right
window
condition
answer
```

Think:

```text
                Window
        ┌─────────────────────┐
        ↓                     ↓
     left                   right
       │                       │
       ▼                       ▼
     [ x   x   x   x   x   x ]
```

Then ask:

### Question 1

What happens when I move `right`?

Usually:

```text
Add new element
Update frequency
Update sum
Update count
```

### Question 2

When does the window become invalid?

Examples:

```text
sum > target
frequency > allowed
distinct elements > k
character requirement not satisfied
```

### Question 3

How do I make it valid again?

Usually:

```text
while (window is invalid) {
    remove arr[left]
    left++;
}
```

### Question 4

When should I update the answer?

For longest problems:

```text
after making the window valid
```

For minimum problems:

```text
while the window is valid
```

This distinction is extremely important.

---

# 🧱 4. The Fundamental Window Structure

Most variable-size sliding-window problems follow this structure:

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add arr[right] to the window

    while (/* window is invalid */) {

        // Remove arr[left] from the window
        left++;
    }

    // Update answer
}
```

The fundamental flow is:

```text
EXPAND
   ↓
Check validity
   ↓
Invalid?
   ↓
SHRINK
   ↓
Valid
   ↓
Update answer
```

---

# 🔍 5. When to Think of Sliding Window

Look for these signals.

## Signal 1 — Subarray

Words such as:

- subarray
- contiguous subarray
- continuous subarray

are strong signals.

Example:

> Find the longest subarray with sum ≤ K.

Think:

```text
Sliding Window
```

---

## Signal 2 — Substring

Words such as:

- substring
- contiguous substring

are also strong signals.

Example:

> Find the longest substring without repeating characters.

Think:

```text
Sliding Window
```

---

## Signal 3 — Size K

If the question says:

> Find something for every subarray of size K.

Think:

```text
Fixed Sliding Window
```

---

## Signal 4 — Longest / Maximum Valid

Examples:

```text
Longest substring with...
Longest subarray with...
Maximum number of...
Longest window...
```

Often indicates:

```text
Variable Sliding Window
```

---

## Signal 5 — Smallest / Minimum Valid

Examples:

```text
Minimum size subarray...
Smallest substring containing...
Minimum window...
```

Usually:

```text
Expand → become valid → shrink aggressively
```

---

## Signal 6 — At Most K

Examples:

```text
At most K distinct characters
At most K odd numbers
At most K zeros
At most K different elements
```

Very common sliding-window pattern.

---

# 🚫 6. When NOT to Think of Sliding Window

Sliding Window is not a universal solution.

## Case 1 — Non-contiguous data

If the problem asks for a:

```text
subsequence
subset
```

rather than a contiguous subarray/substring, sliding window may not apply.

---

## Case 2 — Negative numbers can break sum-based logic

For some problems involving:

```text
sum <= K
```

the standard expanding/shrinking window relies on the sum behaving predictably.

With negative numbers, adding a number can decrease the sum.

Example:

```text
[5, -10, 8]
```

Therefore, don't blindly apply:

```text
while (sum > K)
```

to every subarray-sum problem.

Other techniques such as:

```text
Prefix Sum
HashMap
Deque
Binary Search
```

may be required depending on the problem.

---

## Case 3 — Non-contiguous requirement

If elements do not need to be adjacent, sliding window generally isn't the natural technique.

---

# 🧩 7. The Main Sliding Window Patterns

There are several important patterns.

```text
1. Fixed Window
2. Variable Window
3. Longest Valid Window
4. Smallest Valid Window
5. Frequency / HashMap Window
6. Counting Valid Windows
7. At Most K / Exactly K
8. Character / String Window
9. Monotonic Deque Window
```

---

# 📦 8. Pattern 1 — Fixed-Size Window

## Definition

The size of the window is always exactly `k`.

```text
right - left + 1 = k
```

Example:

```text
[1, 2, 3, 4, 5, 6]
```

For:

```text
k = 3
```

Windows are:

```text
[1, 2, 3]
[2, 3, 4]
[3, 4, 5]
[4, 5, 6]
```

---

## Mental Model

You don't ask:

> Is the window valid?

The size itself determines validity.

The main rule is:

```text
Add right
```

and once:

```text
window size > k
```

remove from the left.

---

## Generic Template

```java
int left = 0;

for (int right = 0; right < arr.length; right++) {

    // Add arr[right]

    if (right - left + 1 == k) {

        // Process window

        // Remove arr[left]
        left++;
    }
}
```

---

## Example

Maximum sum of a subarray of size `k`.

```java
static int maxSum(int[] arr, int k) {
    int left = 0;
    int sum = 0;
    int max = Integer.MIN_VALUE;

    for (int right = 0; right < arr.length; right++) {

        sum += arr[right];

        if (right - left + 1 == k) {
            max = Math.max(max, sum);

            sum -= arr[left];
            left++;
        }
    }

    return max;
}
```

---

# 🔄 9. Pattern 2 — Variable-Size Window

Unlike fixed windows, the window size changes.

```text
[left ........ right]
```

can have different sizes.

The basic idea:

```text
right → expand
left  → shrink
```

---

## Generic Template

```java
int left = 0;

for (int right = 0; right < arr.length; right++) {

    // Add arr[right]

    while (/* invalid */) {

        // Remove arr[left]
        left++;
    }

    // Process valid window
}
```

---

# 📏 10. Pattern 3 — Longest Valid Window

This is one of the most important patterns.

The goal is:

> Find the longest window satisfying some condition.

Examples:

```text
Longest substring without repeating characters
Longest subarray with at most K distinct elements
Longest substring with at most K replacements
```

---

## Strategy

```text
Expand right
      ↓
Check validity
      ↓
Invalid?
      ↓
Shrink left
      ↓
Valid
      ↓
Update maximum
```

The answer is usually:

```java
max = Math.max(max, right - left + 1);
```

---

## Template

```java
int left = 0;
int maxLength = 0;

for (int right = 0; right < n; right++) {

    // Add right

    while (/* invalid */) {

        // Remove left
        left++;
    }

    maxLength = Math.max(
        maxLength,
        right - left + 1
    );
}
```

---

# 🔽 11. Pattern 4 — Smallest Valid Window

This is the opposite style.

Goal:

> Find the smallest window satisfying a condition.

Example:

> Minimum size subarray whose sum is at least target.

The strategy:

```text
Expand
  ↓
Become valid
  ↓
Shrink as much as possible
  ↓
Record minimum
```

---

## Important Difference

For longest:

```text
while invalid
    shrink

update answer
```

For smallest:

```text
while valid
    update answer
    shrink
```

This distinction is extremely important.

---

## Template

```java
int left = 0;
int minLength = Integer.MAX_VALUE;

for (int right = 0; right < n; right++) {

    // Add right

    while (/* valid */) {

        minLength = Math.min(
            minLength,
            right - left + 1
        );

        // Remove left
        left++;
    }
}
```

---

# 🗺️ 12. Pattern 5 — Frequency / HashMap Window

When the problem depends on:

```text
frequency
characters
distinct elements
counts
duplicates
```

you often need additional data structures.

Common choices:

```text
int[26]
int[128]
HashMap<Integer, Integer>
HashMap<Character, Integer>
HashSet<Character>
```

---

## Example

Longest substring without repeating characters.

We need to know:

```text
How many times does each character occur?
```

A `HashSet` can be enough.

```java
HashSet<Character> set = new HashSet<>();
```

---

## Frequency Map

For frequency-based problems:

```java
HashMap<Character, Integer> freq = new HashMap<>();
```

When adding:

```java
freq.put(
    ch,
    freq.getOrDefault(ch, 0) + 1
);
```

When removing:

```java
freq.put(
    ch,
    freq.get(ch) - 1
);
```

If frequency becomes zero:

```java
freq.remove(ch);
```

---

# 🔢 13. Pattern 6 — Counting Valid Windows

Sometimes the question isn't asking for:

```text
longest
smallest
maximum
```

Instead:

> How many subarrays satisfy the condition?

This requires a different mental model.

Suppose the current window:

```text
[left ........ right]
```

is valid.

If the condition is monotonic, then all valid subarrays ending at `right` may be:

```text
[left...right]
[left+1...right]
[left+2...right]
...
[right...right]
```

The number of valid windows ending at `right` is:

```text
right - left + 1
```

Therefore:

```java
count += right - left + 1;
```

This is a very important pattern.

---

# 🎯 14. Pattern 7 — At Most / Exactly K

This is one of the most useful advanced sliding-window ideas.

Suppose:

```text
exactly K distinct elements
```

Directly solving it can sometimes be awkward.

Instead:

```text
Exactly K
=
At Most K
-
At Most K - 1
```

Therefore:

```text
exactly(K) = atMost(K) - atMost(K - 1)
```

---

## Why?

Suppose:

```text
atMost(3)
```

contains:

```text
0 distinct
1 distinct
2 distinct
3 distinct
```

while:

```text
atMost(2)
```

contains:

```text
0 distinct
1 distinct
2 distinct
```

Subtracting removes the smaller cases:

```text
Exactly 3
```

---

## Generic Structure

```java
int exactlyK(int[] arr, int k) {
    return atMostK(arr, k)
         - atMostK(arr, k - 1);
}
```

---

# 🔤 15. Pattern 8 — Character / String Window

String problems are one of the most common applications of sliding window.

Typical questions:

```text
Longest substring without repeating characters
Permutation in string
Find all anagrams
Minimum window substring
Longest repeating character replacement
```

---

## Useful Structures

### ASCII

```java
int[] freq = new int[128];
```

### Lowercase English letters

```java
int[] freq = new int[26];
```

### General characters

```java
HashMap<Character, Integer> map = new HashMap<>();
```

---

# 📊 16. Pattern 9 — Window With Monotonic Deque

Some problems ask for:

> Maximum/minimum element in every window of size K.

A simple sliding window cannot efficiently find the maximum every time.

For example:

```text
[1, 3, -1, -3, 5, 3, 6, 7]
```

For every window of size `3`, we need the maximum.

A **monotonic deque** can solve this in `O(n)`.

---

## Core Idea

Maintain indices in a deque such that values are decreasing.

For maximum:

```text
front = largest value
```

Before inserting a new value:

```text
while deque back is smaller
    remove back
```

If the front is outside the current window:

```text
remove front
```

---

# 👉 17. How to Decide Which Pointer to Move

The most common rule:

```text
right → expand
left  → shrink
```

But the important question is:

> **Why am I moving the pointer?**

---

## Move `right` when:

You need to:

```text
expand the window
include another element
search for a valid condition
```

---

## Move `left` when:

You need to:

```text
remove an element
fix an invalid window
minimize a valid window
remove duplicates
reduce frequency
```

---

# ✅ 18. How to Decide When the Window Is Valid

This is problem-specific.

Examples:

### Sum constraint

```text
sum <= target
```

### Distinct count

```text
map.size() <= k
```

### Frequency constraint

```text
frequency <= allowed
```

### Required characters

```text
formed == required
```

The most important thing is to explicitly define:

> **What condition makes my window valid?**

---

# 🔧 19. How to Decide When to Shrink the Window

There are two major cases.

## Longest

Shrink while:

```text
window is invalid
```

Then update answer.

```java
while (invalid) {
    remove left;
    left++;
}

answer = Math.max(
    answer,
    right - left + 1
);
```

---

## Smallest

Shrink while:

```text
window is valid
```

Update answer before shrinking.

```java
while (valid) {

    answer = Math.min(
        answer,
        right - left + 1
    );

    remove left;
    left++;
}
```

---

# 🧮 20. How to Decide What to Store in the Window

Ask:

> What information do I need to know about my current window?

### Need sum?

Store:

```java
int sum;
```

### Need frequency?

Use:

```java
HashMap
```

or:

```java
int[]
```

### Need unique elements?

Use:

```java
HashSet
```

### Need maximum/minimum?

Consider:

```text
Monotonic Deque
```

### Need number of distinct elements?

Use:

```java
HashMap
```

and:

```java
map.size()
```

---

# 🛑 21. How to Decide the Termination Condition

Most windows use:

```java
right < n
```

because `right` moves across the entire array/string.

The inner shrinking loop uses a condition based on validity:

```java
while (invalid)
```

or:

```java
while (valid)
```

The important rule:

> `right` usually moves forward exactly once through the data, while `left` also moves forward and never moves backward.

This is why many sliding-window algorithms are:

```text
O(n)
```

---

# 🧠 22. How to Approach a LeetCode/GFG Problem

Use this process.

## Step 1 — Identify the data

Ask:

```text
Array?
String?
Subarray?
Substring?
```

---

## Step 2 — Check contiguity

If it says:

```text
contiguous
subarray
substring
consecutive
```

consider sliding window.

---

## Step 3 — Check for fixed K

If:

```text
size K
```

think:

```text
Fixed Window
```

---

## Step 4 — Check for longest/smallest

If:

```text
longest
maximum length
```

think:

```text
Longest Valid Window
```

If:

```text
minimum
smallest
shortest
```

think:

```text
Smallest Valid Window
```

---

## Step 5 — Identify the state

Ask:

```text
Do I need sum?
Frequency?
Distinct count?
Maximum?
Minimum?
Required characters?
```

Choose the appropriate data structure.

---

## Step 6 — Define invalidity

Write mentally:

```text
Window becomes invalid when __________.
```

This tells you when to move `left`.

---

## Step 7 — Decide when to update answer

Longest:

```text
after window becomes valid
```

Smallest:

```text
while window remains valid
```

Counting:

```text
count += right - left + 1
```

---

# 🧰 23. Canonical Java Templates

## Fixed Window

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add arr[right]

    if (right - left + 1 == k) {

        // Process window

        // Remove arr[left]
        left++;
    }
}
```

---

## Longest Valid Window

```java
int left = 0;
int answer = 0;

for (int right = 0; right < n; right++) {

    // Add arr[right]

    while (/* invalid */) {

        // Remove arr[left]
        left++;
    }

    answer = Math.max(
        answer,
        right - left + 1
    );
}
```

---

## Smallest Valid Window

```java
int left = 0;
int answer = Integer.MAX_VALUE;

for (int right = 0; right < n; right++) {

    // Add arr[right]

    while (/* valid */) {

        answer = Math.min(
            answer,
            right - left + 1
        );

        // Remove arr[left]
        left++;
    }
}
```

---

## Frequency Window

```java
HashMap<Character, Integer> map =
    new HashMap<>();

int left = 0;

for (int right = 0; right < s.length(); right++) {

    char ch = s.charAt(right);

    map.put(
        ch,
        map.getOrDefault(ch, 0) + 1
    );

    while (/* invalid */) {

        char remove = s.charAt(left);

        map.put(
            remove,
            map.get(remove) - 1
        );

        if (map.get(remove) == 0) {
            map.remove(remove);
        }

        left++;
    }

    // Update answer
}
```

---

# 📚 24. Important Sliding Window Problems

## Beginner

1. Maximum Sum Subarray of Size K
2. Maximum Number of Vowels in a Substring of Given Length
3. Average of Subarrays of Size K
4. First Negative Number in Every Window of Size K
5. Maximum Consecutive Ones
6. Defuse the Bomb

## Intermediate

7. Longest Substring Without Repeating Characters
8. Longest Repeating Character Replacement
9. Fruit Into Baskets
10. Minimum Size Subarray Sum
11. Max Consecutive Ones III
12. Binary Subarrays With Sum
13. Subarrays With K Different Integers
14. Permutation in String
15. Find All Anagrams in a String

## Advanced

16. Minimum Window Substring
17. Sliding Window Maximum
18. Sliding Window Median
19. Minimum Number of K Consecutive Bit Flips
20. Longest Subarray of 1's After Deleting One Element

---

# 🧪 25. Solved Example — Maximum Sum Subarray of Size K

## Problem

Given an array and integer `k`, find the maximum sum of any contiguous subarray of size `k`.

Example:

```text
arr = [2, 1, 5, 1, 3, 2]
k = 3
```

Windows:

```text
[2, 1, 5] = 8
[1, 5, 1] = 7
[5, 1, 3] = 9
[1, 3, 2] = 6
```

Answer:

```text
9
```

---

## Thinking

Fixed size:

```text
k = 3
```

Therefore:

```text
Fixed Sliding Window
```

Maintain:

```text
sum
```

When the window reaches size `k`:

```text
update answer
remove left element
move left
```

---

## Java Solution

```java
static int maxSum(int[] arr, int k) {

    int left = 0;
    int sum = 0;
    int max = Integer.MIN_VALUE;

    for (int right = 0; right < arr.length; right++) {

        sum += arr[right];

        if (right - left + 1 == k) {

            max = Math.max(max, sum);

            sum -= arr[left];
            left++;
        }
    }

    return max;
}
```

---

## Complexity

```text
Time:  O(n)
Space: O(1)
```

---

# 🍎 26. Solved Example — Maximum Number of Vowels in a Substring

Suppose:

```text
s = "abciiidef"
k = 3
```

Find the maximum number of vowels in any substring of length `3`.

Windows:

```text
"abc" → 1
"bci" → 1
"cii" → 2
"iii" → 3
"iid" → 2
"ide" → 2
"def" → 1
```

Answer:

```text
3
```

---

## Thinking

The window size is fixed:

```text
k = 3
```

Therefore:

```text
Fixed Window
```

Maintain:

```text
vowelCount
```

---

## Java Solution

```java
static int maxVowels(String s, int k) {

    int left = 0;
    int count = 0;
    int max = 0;

    for (int right = 0; right < s.length(); right++) {

        if (isVowel(s.charAt(right))) {
            count++;
        }

        if (right - left + 1 == k) {

            max = Math.max(max, count);

            if (isVowel(s.charAt(left))) {
                count--;
            }

            left++;
        }
    }

    return max;
}

static boolean isVowel(char ch) {

    return ch == 'a' ||
           ch == 'e' ||
           ch == 'i' ||
           ch == 'o' ||
           ch == 'u';
}
```

---

# 🔤 27. Solved Example — Longest Substring Without Repeating Characters

## Problem

Given:

```text
s = "abcabcbb"
```

Find the longest substring containing no repeated characters.

Answer:

```text
"abc"
```

Length:

```text
3
```

---

## Thinking

We need:

```text
Longest
Substring
No duplicates
```

Therefore:

```text
Variable Sliding Window
```

We maintain a set of characters.

When a duplicate appears:

```text
shrink from left
```

until the duplicate disappears.

---

## Java Solution

```java
static int lengthOfLongestSubstring(String s) {

    HashSet<Character> set = new HashSet<>();

    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {

        char ch = s.charAt(right);

        while (set.contains(ch)) {

            set.remove(s.charAt(left));
            left++;
        }

        set.add(ch);

        maxLength = Math.max(
            maxLength,
            right - left + 1
        );
    }

    return maxLength;
}
```

---

# ➕ 28. Solved Example — Longest Subarray With Sum ≤ K

Assume all numbers are non-negative.

Example:

```text
arr = [1, 2, 1, 0, 1, 1, 0]
k = 4
```

We want the longest contiguous subarray whose sum is at most `4`.

---

## Thinking

Condition:

```text
sum <= k
```

We expand using `right`.

If:

```text
sum > k
```

the window becomes invalid.

Therefore:

```text
shrink from left
```

---

## Java Solution

```java
static int longestSubarray(int[] arr, int k) {

    int left = 0;
    int sum = 0;
    int maxLength = 0;

    for (int right = 0; right < arr.length; right++) {

        sum += arr[right];

        while (sum > k) {

            sum -= arr[left];
            left++;
        }

        maxLength = Math.max(
            maxLength,
            right - left + 1
        );
    }

    return maxLength;
}
```

### Important

This standard approach depends on the array values being **non-negative**.

With negative values, the monotonic behavior needed by this simple window can fail.

---

# 🎯 29. Solved Example — Minimum Size Subarray Sum

## Problem

Given positive integers, find the minimum length subarray whose sum is at least `target`.

Example:

```text
target = 7
arr = [2, 3, 1, 2, 4, 3]
```

Answer:

```text
2
```

because:

```text
[4, 3]
```

has sum:

```text
7
```

---

## Thinking

We need:

```text
minimum
```

So:

```text
Expand until valid
Shrink while valid
```

---

## Java Solution

```java
static int minSubArrayLen(int target, int[] nums) {

    int left = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {

        sum += nums[right];

        while (sum >= target) {

            minLength = Math.min(
                minLength,
                right - left + 1
            );

            sum -= nums[left];
            left++;
        }
    }

    return minLength == Integer.MAX_VALUE
        ? 0
        : minLength;
}
```

---

# 🧺 30. Solved Example — Fruit Into Baskets

This is a classic:

```text
At Most 2 Distinct
```

Problem idea:

> Find the longest subarray containing at most two distinct values.

Example:

```text
[1, 2, 1, 2, 3]
```

The longest valid window is:

```text
[1, 2, 1, 2]
```

Length:

```text
4
```

---

## Thinking

Condition:

```text
distinct <= 2
```

Therefore:

```text
HashMap + Variable Sliding Window
```

---

## Java Solution

```java
static int totalFruit(int[] fruits) {

    HashMap<Integer, Integer> map = new HashMap<>();

    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < fruits.length; right++) {

        map.put(
            fruits[right],
            map.getOrDefault(fruits[right], 0) + 1
        );

        while (map.size() > 2) {

            int value = fruits[left];

            map.put(value, map.get(value) - 1);

            if (map.get(value) == 0) {
                map.remove(value);
            }

            left++;
        }

        maxLength = Math.max(
            maxLength,
            right - left + 1
        );
    }

    return maxLength;
}
```

---

# 🔠 31. Solved Example — Longest Repeating Character Replacement

Classic problem:

> Find the longest substring that can be made of the same character after replacing at most `k` characters.

Example:

```text
s = "AABABBA"
k = 1
```

---

## Key Idea

Maintain:

```text
window length
maximum frequency of a character
```

The number of replacements required is:

```text
windowLength - maxFrequency
```

If:

```text
windowLength - maxFrequency > k
```

the window is invalid.

---

## Java Solution

```java
static int characterReplacement(String s, int k) {

    int[] freq = new int[26];

    int left = 0;
    int maxFrequency = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {

        int index = s.charAt(right) - 'A';

        freq[index]++;

        maxFrequency = Math.max(
            maxFrequency,
            freq[index]
        );

        while (
            (right - left + 1) - maxFrequency > k
        ) {

            freq[s.charAt(left) - 'A']--;
            left++;
        }

        maxLength = Math.max(
            maxLength,
            right - left + 1
        );
    }

    return maxLength;
}
```

---

# 🔄 32. Solved Example — Permutation in String

Problem:

> Determine whether `s2` contains a permutation of `s1`.

Example:

```text
s1 = "ab"
s2 = "eidbaooo"
```

The substring:

```text
"ba"
```

is a permutation of:

```text
"ab"
```

Answer:

```text
true
```

---

## Thinking

A permutation has exactly the same:

```text
frequency of every character
```

The window size must be:

```text
s1.length()
```

Therefore:

```text
Fixed Window + Frequency Array
```

---

## Java Solution

```java
static boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length()) {
        return false;
    }

    int[] need = new int[26];
    int[] window = new int[26];

    for (char ch : s1.toCharArray()) {
        need[ch - 'a']++;
    }

    int k = s1.length();

    for (int right = 0; right < s2.length(); right++) {

        window[s2.charAt(right) - 'a']++;

        if (right >= k) {
            window[s2.charAt(right - k) - 'a']--;
        }

        if (right >= k - 1 &&
            Arrays.equals(need, window)) {

            return true;
        }
    }

    return false;
}
```

---

# 🪟 33. Solved Example — Minimum Window Substring

This is one of the most important advanced sliding-window problems.

Given:

```text
s = "ADOBECODEBANC"
t = "ABC"
```

Find the smallest substring of `s` containing all characters of `t`.

Answer:

```text
"BANC"
```

---

## Thinking

We need:

```text
minimum window
containing required characters
```

Therefore:

```text
Expand → satisfy requirement
Shrink → minimize
```

We maintain:

```text
need
window
formed
required
```

---

## Java Solution

```java
static String minWindow(String s, String t) {

    if (s.length() < t.length()) {
        return "";
    }

    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    for (char ch : t.toCharArray()) {
        need.put(
            ch,
            need.getOrDefault(ch, 0) + 1
        );
    }

    int required = need.size();
    int formed = 0;

    int left = 0;

    int bestLength = Integer.MAX_VALUE;
    int bestLeft = 0;

    for (int right = 0; right < s.length(); right++) {

        char ch = s.charAt(right);

        window.put(
            ch,
            window.getOrDefault(ch, 0) + 1
        );

        if (need.containsKey(ch) &&
            window.get(ch).intValue() ==
            need.get(ch).intValue()) {

            formed++;
        }

        while (formed == required) {

            if (right - left + 1 < bestLength) {

                bestLength = right - left + 1;
                bestLeft = left;
            }

            char remove = s.charAt(left);

            window.put(
                remove,
                window.get(remove) - 1
            );

            if (need.containsKey(remove) &&
                window.get(remove) <
                need.get(remove)) {

                formed--;
            }

            left++;
        }
    }

    if (bestLength == Integer.MAX_VALUE) {
        return "";
    }

    return s.substring(
        bestLeft,
        bestLeft + bestLength
    );
}
```

---

# 📈 34. Solved Example — Sliding Window Maximum

Given:

```text
nums = [1,3,-1,-3,5,3,6,7]
k = 3
```

Every window:

```text
[1,3,-1]  → 3
[3,-1,-3] → 3
[-1,-3,5] → 5
[-3,5,3]  → 5
[5,3,6]   → 6
[3,6,7]   → 7
```

Answer:

```text
[3,3,5,5,6,7]
```

---

## Why Normal Sliding Window Is Not Enough

If we scan each window to find the maximum:

```text
O(n × k)
```

We can improve this using a:

```text
Monotonic Deque
```

---

## Core Idea

Store indices.

The deque maintains values in decreasing order.

Therefore:

```text
deque front = maximum
```

Remove indices that leave the window.

Remove smaller values from the back.

---

## Java Solution

```java
static int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;

    int[] result = new int[n - k + 1];

    Deque<Integer> deque = new ArrayDeque<>();

    int index = 0;

    for (int right = 0; right < n; right++) {

        while (!deque.isEmpty() &&
               deque.peekFirst() <= right - k) {

            deque.pollFirst();
        }

        while (!deque.isEmpty() &&
               nums[deque.peekLast()] <= nums[right]) {

            deque.pollLast();
        }

        deque.offerLast(right);

        if (right >= k - 1) {

            result[index++] =
                nums[deque.peekFirst()];
        }
    }

    return result;
}
```

---

# ⚠️ 35. Common Mistakes

## Mistake 1 — Forgetting to remove the left element

Wrong:

```java
while (invalid) {
    left++;
}
```

You also need to remove its contribution.

For sum:

```java
sum -= arr[left];
```

For frequency:

```java
freq[arr[left]]--;
```

---

## Mistake 2 — Updating the answer at the wrong time

For longest:

```text
make valid → update
```

For smallest:

```text
valid → update → shrink
```

---

## Mistake 3 — Using `if` instead of `while`

Often wrong:

```java
if (invalid) {
    left++;
}
```

Usually:

```java
while (invalid) {
    left++;
}
```

Why?

Because one removal may not be enough.

---

## Mistake 4 — Forgetting `+1`

Window length:

```text
right - left + 1
```

Not:

```text
right - left
```

Example:

```text
left = 2
right = 2
```

There is one element.

Therefore:

```text
2 - 2 + 1 = 1
```

---

## Mistake 5 — Confusing substring and subsequence

Sliding Window generally works with:

```text
substring
subarray
contiguous
```

not arbitrary subsequences.

---

## Mistake 6 — Ignoring negative numbers

A sum-based variable window often relies on non-negative values.

Do not blindly use it when negative numbers are allowed.

---

## Mistake 7 — Using the wrong frequency structure

For lowercase letters:

```java
int[26]
```

is usually simpler than:

```java
HashMap<Character, Integer>
```

---

# ⚔️ 36. Brute Force vs Sliding Window

Suppose:

```text
n = 100000
```

A brute-force approach may repeatedly process the same elements.

Example:

```text
O(n × k)
```

Sliding Window often processes each element at most a constant number of times.

Therefore:

```text
O(n)
```

---

## Important Principle

Sliding Window does not magically make every problem `O(n)`.

The complexity depends on:

```text
window operation
data structure
number of pointer movements
```

But in standard cases:

```text
right moves n times
left moves at most n times
```

Therefore:

```text
O(n + n)
= O(n)
```

---

# ⏱️ 37. Time and Space Complexity

## Fixed Window

Usually:

```text
Time:  O(n)
Space: O(1)
```

---

## Variable Window

Usually:

```text
Time:  O(n)
Space: O(1) or O(k)
```

depending on the additional data structure.

---

## HashMap Window

Usually:

```text
Time:  O(n)
Space: O(k)
```

where `k` represents the number of distinct elements being tracked.

---

## Monotonic Deque

Usually:

```text
Time:  O(n)
Space: O(k)
```

for a window of size `k`.

---

# ✅ 38. Advantages

- Efficient for contiguous ranges
- Often reduces `O(n × k)` to `O(n)`
- Avoids repeated calculations
- Works naturally with arrays and strings
- Easy to combine with HashMap/HashSet
- Useful for frequency problems
- Useful for longest/shortest substring problems
- Excellent interview pattern

---

# ❌ 39. Disadvantages

- Usually requires contiguous data
- Not suitable for every subarray problem
- Sum-based windows can become difficult with negative numbers
- Some problems require advanced structures
- Correctly defining the window condition can be tricky
- `Exactly K` problems may require transformation
- Maximum/minimum windows may require a deque

---

# 🧪 40. Edge Cases Checklist

Before submitting a solution, test:

```text
□ Empty array
□ Empty string
□ One element
□ k = 1
□ k = n
□ k > n
□ All elements equal
□ All elements different
□ Duplicate elements
□ Negative numbers
□ Zero values
□ No valid window
□ Entire array is valid
□ Answer occurs at beginning
□ Answer occurs at end
□ Multiple valid windows
□ Minimum answer = 1
```

For strings:

```text
□ Empty string
□ One character
□ Repeated character
□ All unique characters
□ t longer than s
□ Required character absent
□ Required characters repeated
```

---

# 🧠 41. Sliding Window Problem-Solving Checklist

When you see a new problem, ask these questions in order:

### 1. Is the data contiguous?

```text
Subarray / Substring?
```

If yes, continue.

---

### 2. Is the window size fixed?

```text
Size K?
```

If yes:

```text
Fixed Window
```

---

### 3. Is the size variable?

Look for:

```text
longest
smallest
minimum
maximum length
at most
contains
```

---

### 4. What makes the window invalid?

Complete:

```text
My window becomes invalid when __________.
```

---

### 5. What do I need to track?

```text
sum?
frequency?
distinct count?
max frequency?
required characters?
maximum/minimum?
```

---

### 6. Which data structure?

```text
Sum        → variable
Frequency  → int[] / HashMap
Unique     → HashSet
Max/Min    → Deque
```

---

### 7. When do I shrink?

Longest:

```text
while invalid
```

Smallest:

```text
while valid
```

---

### 8. What is my answer?

```text
Maximum length?
Minimum length?
Maximum sum?
Count?
Actual substring?
```

---

### 9. Can I prove both pointers move only forward?

If:

```text
left → forward
right → forward
```

then there is a strong possibility of:

```text
O(n)
```

---

# 🎤 42. Interview 30-Second Answer

> **Sliding Window is an algorithmic technique used mainly for contiguous subarray and substring problems. We maintain a window using two pointers, usually `left` and `right`. The right pointer expands the window, while the left pointer shrinks it whenever the window violates the required condition. There are two major forms: fixed-size windows and variable-size windows. By reusing information from the previous window instead of recalculating everything, we can often reduce the time complexity from `O(n × k)` to `O(n)`.**

---

# 📌 43. Cheat Sheet

## Fixed Window

```text
Question:
"Size K"

Pattern:

right →
add

if window size == K
    process
    remove left
    left++
```

---

## Longest Valid

```text
right →
add

while invalid
    remove left
    left++

update max
```

---

## Smallest Valid

```text
right →
add

while valid
    update min
    remove left
    left++
```

---

## Frequency Window

```text
add frequency[right]

while invalid
    remove frequency[left]
    left++
```

---

## At Most K

```text
while distinct > K
    shrink
```

---

## Exactly K

```text
exactly(K)
=
atMost(K)
-
atMost(K - 1)
```

---

## Counting Windows

When the current window is valid:

```text
count += right - left + 1
```

---

## Window Length

```text
right - left + 1
```

---

## Maximum / Minimum in Window

Use:

```text
Monotonic Deque
```

---

# 🧠 Final Memory Trick

Remember:

```text
                 SLIDING WINDOW

                  right →
                     ↓
              ┌─────────────┐
              │   WINDOW    │
              └─────────────┘
                ↑
              left

RIGHT = EXPAND

LEFT = SHRINK

LONGEST:
    invalid → shrink
    valid   → update max

SMALLEST:
    valid   → update min
    shrink

FIXED K:
    size == K → process → slide

AT MOST K:
    invalid when count > K

EXACTLY K:
    atMost(K) - atMost(K-1)

FREQUENCY:
    HashMap / int[]

MAX-MIN:
    Monotonic Deque
```

---

# 🚀 Final Takeaway

The goal is not to memorize dozens of sliding-window solutions.

Instead, master this thought process:

```text
1. Identify the window
2. Expand with right
3. Track the required information
4. Define invalidity
5. Shrink with left
6. Restore validity
7. Update the answer
```

The most important question to ask yourself is:

> **"What information can I carry from the previous window instead of calculating it again?"**

That question is often what turns a brute-force solution into a Sliding Window solution.
````
