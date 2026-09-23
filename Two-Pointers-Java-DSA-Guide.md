# 🎯 Two Pointers in Java --- Complete DSA Guide

> **Goal:** Learn how to recognize, think about, implement, debug, and
> apply the **Two Pointers** pattern in Java for LeetCode and
> GeeksforGeeks problems.

------------------------------------------------------------------------

## 📌 Table of Contents

1.  [What Are Two Pointers?](#what-are-two-pointers)
2.  [Why Two Pointers?](#why-two-pointers)
3.  [Core Mental Model](#core-mental-model)
4.  [When to Think of Two Pointers](#when-to-think-of-two-pointers)
5.  [When NOT to Think of Two
    Pointers](#when-not-to-think-of-two-pointers)
6.  [The Main Two-Pointer Patterns](#the-main-two-pointer-patterns)
7.  [Pattern 1 --- Opposite Ends](#pattern-1--opposite-ends)
8.  [Pattern 2 --- Same Direction](#pattern-2--same-direction)
9.  [Pattern 3 --- Fast and Slow](#pattern-3--fast-and-slow)
10. [Pattern 4 --- Two Pointers on Two
    Arrays](#pattern-4--two-pointers-on-two-arrays)
11. [Pattern 5 --- Partition / In-Place
    Rearrangement](#pattern-5--partition--in-place-rearrangement)
12. [How to Decide Which Pointer to
    Move](#how-to-decide-which-pointer-to-move)
13. [How to Decide the Termination
    Condition](#how-to-decide-the-termination-condition)
14. [How to Approach a LeetCode/GFG
    Problem](#how-to-approach-a-leetcodegfg-problem)
15. [Canonical Java Templates](#canonical-java-templates)
16. [Important Problems](#important-problems)
17. [Solved Example --- Two Sum II](#solved-example--two-sum-ii)
18. [Solved Example --- Remove
    Duplicates](#solved-example--remove-duplicates)
19. [Solved Example --- Move Zeroes](#solved-example--move-zeroes)
20. [Solved Example --- Container With Most
    Water](#solved-example--container-with-most-water)
21. [Solved Example --- 3Sum](#solved-example--3sum)
22. [Solved Example --- Valid
    Palindrome](#solved-example--valid-palindrome)
23. [Common Mistakes](#common-mistakes)
24. [Brute Force vs Two Pointers](#brute-force-vs-two-pointers)
25. [Time and Space Complexity](#time-and-space-complexity)
26. [Advantages](#advantages)
27. [Disadvantages](#disadvantages)
28. [Edge Cases Checklist](#edge-cases-checklist)
29. [Two-Pointer Problem-Solving
    Checklist](#two-pointer-problem-solving-checklist)
30. [Interview 30-Second Answer](#interview-30-second-answer)
31. [Cheat Sheet](#cheat-sheet)

------------------------------------------------------------------------

# 🧠 What Are Two Pointers?

**Two Pointers** is a problem-solving technique where two variables are
used to represent positions in a data structure, usually an array or
string.

The pointers are moved according to a condition instead of checking
every possible pair.

Typical pointer names are:

``` java
int left = 0;
int right = nums.length - 1;
```

or:

``` java
int slow = 0;
int fast = 0;
```

The key idea is:

> **Use pointer movement to eliminate unnecessary comparisons.**

------------------------------------------------------------------------

# 🚀 Why Two Pointers?

Suppose we want to find two numbers whose sum equals a target.

A brute-force approach checks every pair:

``` text
(0,1)
(0,2)
(0,3)
...
```

That can require **O(n²)** comparisons.

With two pointers on a sorted array:

``` text
left →                ← right
[1, 2, 3, 4, 6, 8, 10]
```

We can use the current sum to eliminate an entire region of
possibilities.

This can reduce:

``` text
O(n²) → O(n)
```

The important idea is not simply "use two variables."

The important idea is:

> **Each pointer movement should eliminate impossible candidates.**

------------------------------------------------------------------------

# 🧠 Core Mental Model

Whenever you see a problem involving an array/string, ask:

### Question 1

> Can I represent the relevant search area using two positions?

### Question 2

> Can I move one pointer based on the current condition?

### Question 3

> Does moving that pointer allow me to permanently eliminate some
> possibilities?

If all three answers are yes, Two Pointers may be appropriate.

------------------------------------------------------------------------

# 🔎 When to Think of Two Pointers

Look for these signals.

## Signal 1 --- Sorted Array

Example:

``` text
[1, 2, 3, 5, 7, 9]
```

Questions involving:

-   pair sum
-   closest pair
-   duplicates
-   comparing values from both ends
-   finding combinations

should immediately make you consider Two Pointers.

------------------------------------------------------------------------

## Signal 2 --- Pair / Combination Problem

Examples:

``` text
Find two numbers with target sum.
Find pair with maximum/minimum value.
Find triplets satisfying a condition.
```

Possible thought process:

``` text
Pair problem
    ↓
Is the data sorted?
    ↓
Can I use left + right?
```

------------------------------------------------------------------------

## Signal 3 --- In-Place Requirement

If the problem says:

> Use O(1) extra space.

Think:

``` text
HashMap ❌
HashSet ❌
Another array ❌

Could Two Pointers solve it?
```

Possible alternatives include:

``` text
Two Pointers
Sorting
In-place modification
Index manipulation
Bit manipulation
Mathematics
```

Do **not** automatically assume Two Pointers is the answer. Treat it as
a candidate.

------------------------------------------------------------------------

## Signal 4 --- Comparing From Both Ends

Examples:

``` text
Palindrome
Reverse array
Container with most water
Sorted pair sum
```

This often suggests:

``` text
left →          ← right
```

------------------------------------------------------------------------

## Signal 5 --- Removing / Keeping Elements In-Place

Examples:

``` text
Remove duplicates
Remove a value
Move zeroes
Partition an array
```

This often suggests:

``` text
read pointer
write pointer
```

------------------------------------------------------------------------

# 🚫 When NOT to Think of Two Pointers

Two Pointers is not a universal solution.

Be careful when:

### 1. The data has no useful ordering or movement property

If moving a pointer gives you no information, Two Pointers may not help.

### 2. The problem requires arbitrary lookups

Example:

``` text
Does this value already exist?
```

A HashSet may be more natural unless space is restricted.

### 3. The problem requires frequency information

Consider:

``` text
frequency of every number
```

A HashMap/array frequency table may be appropriate.

### 4. The problem requires a non-contiguous combination

Two Pointers generally works best when pointer movement corresponds to a
meaningful search structure.

### 5. You cannot prove why a pointer can safely move

This is the biggest warning sign.

> If you cannot explain why moving a pointer cannot discard the correct
> answer, do not blindly use Two Pointers.

------------------------------------------------------------------------

# 🔥 The Main Two-Pointer Patterns

There are several important forms.

``` text
Two Pointers
│
├── 1. Opposite Ends
│      left → ← right
│
├── 2. Same Direction
│      slow → fast →
│
├── 3. Fast and Slow
│      slow → 
│      fast →→
│
├── 4. Two Arrays
│      i → array A
│      j → array B
│
└── 5. Partition / In-Place
       read/write or left/right
```

------------------------------------------------------------------------

# 1️⃣ Pattern 1 --- Opposite Ends

## Structure

``` text
left →              ← right
[ ... ... ... ... ... ]
```

Usually:

``` java
int left = 0;
int right = arr.length - 1;

while (left < right) {
    // process arr[left] and arr[right]

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

------------------------------------------------------------------------

## When to use it

Common signals:

-   sorted array
-   pair sum
-   palindrome
-   compare both ends
-   maximize/minimize using both ends
-   reverse array

------------------------------------------------------------------------

## Example

``` text
nums = [1, 2, 3, 4, 6]
target = 6
```

Start:

``` text
left = 0 → 1
right = 4 → 6

sum = 1 + 6 = 7
```

Too large.

Move:

``` text
right--
```

Now:

``` text
1 + 4 = 5
```

Too small.

Move:

``` text
left++
```

Now:

``` text
2 + 4 = 6
```

Found.

------------------------------------------------------------------------

# 2️⃣ Pattern 2 --- Same Direction

Both pointers move from left to right.

``` text
slow →
fast →
```

Typical use:

-   remove duplicates
-   remove elements
-   compact an array
-   sliding/processing regions

------------------------------------------------------------------------

## Example

Remove duplicates from sorted array:

``` text
[1, 1, 2, 2, 3]
```

Think:

``` text
slow = position where next unique value should go
fast = scans the array
```

Template:

``` java
int slow = 0;

for (int fast = 1; fast < nums.length; fast++) {
    if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
    }
}
```

------------------------------------------------------------------------

# 3️⃣ Pattern 3 --- Fast and Slow

Pointers move at different speeds.

Example:

``` java
slow++;
fast += 2;
```

Commonly used for linked lists:

``` text
slow → 
fast → →
```

Applications:

-   cycle detection
-   middle of linked list
-   cycle entry
-   certain sequence problems

------------------------------------------------------------------------

## Example --- Linked List Cycle

``` java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}

return false;
```

The important idea:

> If a fast pointer catches a slow pointer inside a cycle, a cycle
> exists.

------------------------------------------------------------------------

# 4️⃣ Pattern 4 --- Two Pointers on Two Arrays

Used when processing two sorted arrays/sequences.

Example:

``` text
A = [1, 3, 5]
B = [2, 3, 6]
```

Pointers:

``` text
i → A
j → B
```

Template:

``` java
int i = 0;
int j = 0;

while (i < a.length && j < b.length) {
    if (a[i] < b[j]) {
        i++;
    } else if (a[i] > b[j]) {
        j++;
    } else {
        // common element
        i++;
        j++;
    }
}
```

------------------------------------------------------------------------

# 5️⃣ Pattern 5 --- Partition / In-Place Rearrangement

Used when the array must be modified without another array.

Examples:

-   move zeroes
-   partition values
-   separate positive/negative values
-   Dutch National Flag
-   remove an element

A common structure is:

``` text
write position
read position
```

The read pointer scans.

The write pointer places valid elements.

------------------------------------------------------------------------

# 🧭 How to Decide Which Pointer to Move

This is the most important skill.

Do **not** memorize:

> "If sum is small, move left."

Understand **why**.

For a sorted array:

``` text
left → smaller values
right → larger values
```

Suppose:

``` text
arr[left] + arr[right] > target
```

Because the array is sorted:

-   Moving `left` right makes the sum larger or equal.
-   Moving `right` left makes the sum smaller or equal.

Therefore:

``` text
sum > target
→ right--
```

Similarly:

``` text
sum < target
→ left++
```

The rule comes from the **property of the data**, not from memorization.

------------------------------------------------------------------------

# 🛑 How to Decide When to Terminate

Usually, the search ends when the pointers meet or cross.

For opposite pointers:

``` java
while (left < right)
```

Why?

When:

``` text
left == right
```

both pointers refer to the same element.

For a pair problem, you cannot use the same element twice.

When:

``` text
left > right
```

the search space is exhausted.

------------------------------------------------------------------------

## `left < right` vs `left <= right`

### Pair problems

Usually:

``` java
while (left < right)
```

because you need two different positions.

### Binary search

Often:

``` java
while (left <= right)
```

because a single remaining position may still contain the target.

### Important

Do not memorize one universal condition.

Ask:

> **Can the answer exist when both pointers are at the same index?**

If no:

``` java
left < right
```

If yes:

``` java
left <= right
```

------------------------------------------------------------------------

# 🧠 How to Approach a LeetCode/GFG Two-Pointer Question

Use this exact process.

## Step 1 --- Understand the requirement

Ask:

``` text
What am I actually looking for?
```

Pair?

Duplicate?

Palindrome?

Subarray?

In-place modification?

------------------------------------------------------------------------

## Step 2 --- Check constraints

Look for:

``` text
Sorted?
In-place?
O(1) space?
O(n) expected?
Duplicates?
Negative numbers?
```

Constraints often reveal the intended pattern.

------------------------------------------------------------------------

## Step 3 --- Build the brute force first

For pair sum:

``` text
for every i
    for every j
        check pair
```

Complexity:

``` text
O(n²)
```

Then ask:

> What repeated work am I doing?

This is where optimization begins.

------------------------------------------------------------------------

## Step 4 --- Ask what property can eliminate work

For a sorted array:

``` text
If sum is too large,
I can eliminate the right side.
```

That is the Two-Pointer breakthrough.

------------------------------------------------------------------------

## Step 5 --- Define pointer meaning

Before coding, literally write:

``` text
left = smallest candidate
right = largest candidate
```

or:

``` text
slow = next write position
fast = scanning position
```

If you cannot define what each pointer represents, stop and rethink.

------------------------------------------------------------------------

## Step 6 --- Define movement rules

Example:

``` text
sum < target → left++
sum > target → right--
sum == target → answer
```

------------------------------------------------------------------------

## Step 7 --- Define termination

Usually:

``` java
while (left < right)
```

or another condition based on the problem.

------------------------------------------------------------------------

## Step 8 --- Dry run a tiny example

Use:

``` text
[1, 2, 3, 4, 6]
target = 6
```

Don't immediately test a huge example.

------------------------------------------------------------------------

# 💡 What NOT to Think

Avoid these habits:

### ❌ "Two Pointers means two nested loops."

No.

Two Pointers is usually used to **avoid** nested loops.

------------------------------------------------------------------------

### ❌ "Whenever there are two elements, use Two Pointers."

No.

You need a property that makes pointer movement meaningful.

------------------------------------------------------------------------

### ❌ "Sorted array always means Two Pointers."

No.

A sorted array may suggest:

``` text
Binary Search
Two Pointers
Sliding Window
Greedy
```

You still need to understand the requirement.

------------------------------------------------------------------------

### ❌ "I remember the pattern, so I'll code it."

Don't.

First define:

``` text
What does left mean?
What does right mean?
When do I move left?
When do I move right?
Why is that movement safe?
When do I stop?
```

------------------------------------------------------------------------

### ❌ "I'll use HashMap first."

Not always.

If the problem says:

``` text
O(1) extra space
```

immediately reconsider HashMap/HashSet.

But do not ban HashMap from your thinking completely.

Instead:

``` text
Space allowed?
    ↓
Yes → HashMap/HashSet may be useful
No  → consider in-place / two pointers / sorting / math
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 167: Two Sum II

## Problem

Given a sorted array, find two numbers whose sum equals the target.

Example:

``` text
numbers = [2, 7, 11, 15]
target = 9
```

## Thought Process

Sorted array:

``` text
2 < 7 < 11 < 15
```

Use:

``` text
left = 0
right = n - 1
```

Calculate:

``` text
2 + 15 = 17
```

Too large.

Move:

``` text
right--
```

Now:

``` text
2 + 11 = 13
```

Still too large.

Move:

``` text
right--
```

Now:

``` text
2 + 7 = 9
```

Found.

## Java Solution

``` java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
```

## Complexity

``` text
Time: O(n)
Space: O(1)
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 26: Remove Duplicates from Sorted Array

## Pattern

Same-direction Two Pointers.

``` text
slow → stores last unique position
fast → scans the array
```

Example:

``` text
[1, 1, 2, 2, 3]
```

Solution:

``` java
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
```

## Why it works

Because the array is sorted.

Therefore:

``` text
equal values are adjacent
```

When `fast` finds a new value, place it after the current unique region.

## Complexity

``` text
Time: O(n)
Space: O(1)
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 283: Move Zeroes

## Goal

Move all zeroes to the end while maintaining the order of non-zero
elements.

Example:

``` text
[0, 1, 0, 3, 12]
```

Result:

``` text
[1, 3, 12, 0, 0]
```

## Thought Process

Use:

``` text
fast = scans every element
slow = position where next non-zero belongs
```

## Solution

``` java
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;

                slow++;
            }
        }
    }
}
```

## Complexity

``` text
Time: O(n)
Space: O(1)
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 125: Valid Palindrome

## Pattern

Opposite ends.

``` text
left →              ← right
```

Compare characters.

``` java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 11: Container With Most Water

## Core idea

Two boundaries create a container:

``` text
left wall          right wall
    |                  |
    |                  |
    |                  |
```

Area:

``` text
width × minimum(height[left], height[right])
```

The key question is:

> Which pointer should move?

If:

``` text
height[left] < height[right]
```

move:

``` text
left++
```

Why?

The smaller wall limits the height.

Moving the taller wall cannot improve the limiting height while width
decreases.

## Solution

``` java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, width * currentHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```

## Complexity

``` text
Time: O(n)
Space: O(1)
```

------------------------------------------------------------------------

# 🧩 Solved Example --- LeetCode 15: 3Sum

This is a very important Two-Pointer problem.

## Example

``` text
nums = [-1, 0, 1, 2, -1, -4]
```

First sort:

``` text
[-4, -1, -1, 0, 1, 2]
```

Fix one element.

Then solve a **Two Sum** problem on the remaining portion.

Conceptually:

``` text
i fixed

        left →       ← right
[-4, -1, -1, 0, 1, 2]
```

For every fixed `i`:

``` text
target = -nums[i]
```

Then use Two Pointers.

## Solution

``` java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
```

## Complexity

Sorting:

``` text
O(n log n)
```

Outer loop + Two Pointer:

``` text
O(n²)
```

Total:

``` text
O(n²)
```

Extra space depends on the sorting implementation and output; the
algorithm itself uses constant auxiliary pointer space apart from the
returned result.

------------------------------------------------------------------------

# 🧠 How to Recognize Two Pointers From the Problem Statement

Look for phrases such as:

``` text
"sorted array"
"pair"
"two numbers"
"sum"
"from both ends"
"palindrome"
"in-place"
"remove duplicates"
"move elements"
"without extra space"
"maintain relative order"
```

These are **signals**, not guarantees.

Always verify that pointer movement can eliminate work.

------------------------------------------------------------------------

# ⚔️ Two Pointers vs HashMap

Suppose:

``` text
Find two numbers whose sum is target.
```

### HashMap approach

``` text
Time: O(n)
Space: O(n)
```

### Two Pointers on sorted array

``` text
Time: O(n)
Space: O(1)
```

But Two Pointers may require the array to already be sorted.

If sorting is necessary:

``` text
Sorting: O(n log n)
Two Pointer: O(n)
```

Total:

``` text
O(n log n)
```

Therefore, do not blindly say:

> Two Pointers is always better than HashMap.

The correct approach depends on:

``` text
Input properties
Constraints
Whether modification is allowed
Whether original indices matter
Required complexity
```

------------------------------------------------------------------------

# ⚡ Two Pointers vs Brute Force

## Brute Force

``` text
for i
    for j
```

Often:

``` text
O(n²)
```

## Two Pointers

``` text
left
right
```

If each pointer only moves forward/backward and never repeatedly scans
the same region:

``` text
O(n)
```

The optimization comes from **eliminating search space**, not merely
from having two variables.

------------------------------------------------------------------------

# ⏱️ Time Complexity

The most common Two-Pointer complexity is:

``` text
O(n)
```

Why?

Because each pointer moves at most `n` times.

For example:

``` java
while (left < right) {
    ...
    left++;
    // or
    right--;
}
```

The pointers move toward each other.

They do not restart from the beginning.

Therefore:

``` text
Total pointer movements ≤ 2n
```

And:

``` text
O(2n) = O(n)
```

------------------------------------------------------------------------

# 📦 Space Complexity

Usually:

``` text
O(1)
```

because we only store variables such as:

``` java
int left;
int right;
int sum;
```

However, be careful.

If you first sort using an algorithm that requires extra memory, or
create another array, total space can change.

------------------------------------------------------------------------

# ✅ Advantages

### 1. Excellent time complexity

Can reduce:

``` text
O(n²) → O(n)
```

for appropriate problems.

### 2. Low memory usage

Often:

``` text
O(1)
```

extra space.

### 3. Works well with sorted data

Sorting gives pointer movement a mathematical meaning.

### 4. Excellent for in-place problems

Useful when extra arrays are prohibited.

### 5. Simple implementation

Once the pattern is recognized, the code is often short.

------------------------------------------------------------------------

# ❌ Disadvantages

### 1. Requires a useful structure

You need to know why pointer movement is safe.

### 2. Sorting may be required

If the input isn't sorted, sorting can add:

``` text
O(n log n)
```

time.

### 3. Sorting can destroy original index information

For problems requiring original positions, sorting may not be directly
usable.

### 4. Not suitable for every pair problem

Sometimes HashMap is the better fit.

### 5. Duplicate handling can be tricky

Especially in:

``` text
3Sum
4Sum
combination problems
```

------------------------------------------------------------------------

# ⚠️ Common Mistakes

## Mistake 1 --- Wrong pointer movement

Example:

``` java
if (sum < target) {
    right--;
}
```

This is wrong for the standard sorted Two Sum setup.

Correct:

``` java
if (sum < target) {
    left++;
}
```

because increasing `left` increases the sum.

------------------------------------------------------------------------

## Mistake 2 --- Infinite loop

Bad:

``` java
while (left < right) {
    if (...) {
        // no pointer movement
    }
}
```

At least one pointer must progress in every non-terminal iteration.

------------------------------------------------------------------------

## Mistake 3 --- Wrong termination

Pair problems generally should not allow:

``` text
left == right
```

because that would use the same element twice.

------------------------------------------------------------------------

## Mistake 4 --- Ignoring sortedness

The rule:

``` text
sum < target → left++
```

depends on the array being sorted.

Without sorting, this reasoning is invalid.

------------------------------------------------------------------------

## Mistake 5 --- Using absolute difference unnecessarily

If:

``` text
previousIndex < currentIndex
```

then:

``` java
currentIndex - previousIndex
```

is already non-negative.

------------------------------------------------------------------------

## Mistake 6 --- Creating unnecessary data structures

If the problem says:

``` text
O(1) extra space
```

don't immediately create:

``` java
HashMap
HashSet
ArrayList
```

First investigate an in-place strategy.

------------------------------------------------------------------------

# 🧪 Edge Cases Checklist

Before submitting, test:

``` text
[]                         // if allowed
[1]                        // one element
[1, 2]                     // minimum pair
all equal values
many duplicates
negative values
zero
very large values
target smaller than all
target larger than all
answer at the first pair
answer at the last pair
no answer
left == right
```

For arithmetic problems, also think about integer overflow.

------------------------------------------------------------------------

# 🛠️ Debugging Two-Pointer Code

When your solution fails, ask:

### 1. What does each pointer represent?

Write it in one sentence.

### 2. Is the array sorted?

If your movement depends on ordering, verify this.

### 3. Does every loop iteration move a pointer?

If not, check for an infinite loop.

### 4. Can I prove this pointer movement is safe?

If not, the algorithm may be wrong.

### 5. Is the termination condition correct?

Check:

``` text
left < right
left <= right
left < n
right >= 0
```

depending on the pattern.

### 6. Am I accidentally skipping an answer?

This commonly happens with:

-   duplicate skipping
-   pointer increments after finding an answer
-   moving both pointers incorrectly

------------------------------------------------------------------------

# 🧠 The Most Important Thinking Skill

Do not memorize:

``` text
sum < target → left++
sum > target → right--
```

Memorize the **reason**:

``` text
Sorted array
     ↓
left has smaller values
right has larger values
     ↓
Need bigger sum?
→ move left rightward

Need smaller sum?
→ move right leftward
```

This lets you derive the rule during an interview.

------------------------------------------------------------------------

# 🏋️ Practice Roadmap

## 🟢 Beginner

  Problem                                 Number Pattern
  ------------------------------------- -------- ----------------
  Two Sum II                                 167 Opposite ends
  Valid Palindrome                           125 Opposite ends
  Remove Duplicates from Sorted Array         26 Same direction
  Remove Element                              27 Same direction
  Move Zeroes                                283 Read/write
  Reverse String                             344 Opposite ends
  Squares of a Sorted Array                  977 Opposite ends

------------------------------------------------------------------------

## 🟡 Intermediate

  Problem                       Number Pattern
  --------------------------- -------- ---------------------------
  Container With Most Water         11 Opposite ends
  3Sum                              15 Fix + Two Pointers
  4Sum                              18 Fix + Two Pointers
  Sort Colors                       75 Partition
  Boats to Save People             881 Opposite ends
  Bag of Tokens                    948 Opposite ends
  Longest Mountain in Array        845 Multiple pointer movement

------------------------------------------------------------------------

## 🔴 More Challenging

After mastering the above:

``` text
42   Trapping Rain Water
16   3Sum Closest
259  3Sum Smaller
611  Valid Triangle Number
923  3Sum With Multiplicity
```

------------------------------------------------------------------------

# 🧠 Two-Pointer Cheat Sheet

``` text
┌───────────────────────────────────────────┐
│              TWO POINTERS                 │
├───────────────────────────────────────────┤
│ Sorted pair problem                       │
│ → left = 0                                │
│ → right = n - 1                           │
│                                           │
│ sum < target                              │
│ → left++                                  │
│                                           │
│ sum > target                              │
│ → right--                                 │
│                                           │
│ Pair search termination                   │
│ → left < right                             │
│                                           │
│ Remove duplicates/elements                │
│ → slow + fast                             │
│                                           │
│ Fast/slow linked list                     │
│ → slow += 1                               │
│ → fast += 2                               │
│                                           │
│ Common complexity                         │
│ → O(n) time                               │
│ → O(1) extra space                        │
│                                           │
│ Main advantage                            │
│ → eliminates unnecessary comparisons      │
│                                           │
│ Main requirement                          │
│ → pointer movement must be justifiable    │
└───────────────────────────────────────────┘
```

------------------------------------------------------------------------

# 🎯 Two-Pointer Problem-Solving Checklist

Before coding:

``` text
[ ] What exactly am I searching for?
[ ] Is the array/string sorted?
[ ] Can two positions represent my search?
[ ] What does left mean?
[ ] What does right mean?
[ ] Why can I move left?
[ ] Why can I move right?
[ ] Does every iteration move a pointer?
[ ] When should the loop terminate?
[ ] Can I solve it in O(n)?
[ ] Is O(1) extra space required?
[ ] Do duplicates need special handling?
[ ] Can sorting help?
[ ] Does sorting destroy information I need?
[ ] Have I dry-run a small example?
```

------------------------------------------------------------------------

# 🎤 Interview: 30-Second Answer

> **Two Pointers is a technique where two indices are used to process an
> array or sequence while eliminating unnecessary comparisons. It is
> especially useful for sorted arrays, pair problems, palindrome checks,
> and in-place modifications. Depending on the pattern, the pointers can
> move toward each other, in the same direction, or at different speeds.
> A common advantage is reducing an O(n²) brute-force solution to O(n)
> while using O(1) extra space. The key is that every pointer movement
> must be justified by a property of the problem.**

------------------------------------------------------------------------

# 🧠 Final Mental Model

When you see a DSA problem, don't immediately ask:

> "Which algorithm do I remember?"

Ask:

``` text
What information do I have?
        ↓
What work is being repeated?
        ↓
Can I eliminate that work?
        ↓
Can two positions represent the remaining search?
        ↓
Can I safely move one pointer?
        ↓
Can I prove that movement?
        ↓
Two Pointers?
```

The real skill is **not knowing the template**.

The real skill is knowing **why the template works**.

------------------------------------------------------------------------

# 🔥 One-Line Memory Trick

``` text
Two Pointers = Two positions + A reason to move one of them.
```

If you cannot explain **why a pointer moves**, you probably haven't
found the pattern yet.
