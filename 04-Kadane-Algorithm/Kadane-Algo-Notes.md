# <img src="https://api.iconify.design/lucide/zap.svg?color=%23fbbf24" width="30" /> Kadane's Algorithm in Java — Complete DSA Guide

> **Goal:** Build the intuition to recognize maximum-subarray problems, understand why Kadane's Algorithm works, implement it confidently in Java, and explain it clearly in an interview.

---

## Table of Contents

1. [What Is Kadane's Algorithm?](#1-what-is-kadanes-algorithm)
2. [The Problem Kadane Solves](#2-the-problem-kadane-solves)
3. [Why Brute Force Is Not Enough](#3-why-brute-force-is-not-enough)
4. [Core Mental Model](#4-core-mental-model)
5. [The Main Insight](#5-the-main-insight)
6. [Deriving Kadane's Algorithm](#6-deriving-kadanes-algorithm)
7. [The Two Important Variables](#7-the-two-important-variables)
8. [Step-by-Step Dry Run](#8-step-by-step-dry-run)
9. [Java Implementation](#9-java-implementation)
10. [Why Do We Reset the Current Sum?](#10-why-do-we-reset-the-current-sum)
11. [Why Does `maxSum` Come After Updating `currentSum`?](#11-why-does-maxsum-come-after-updating-currentsum)
12. [All-Negative Arrays](#12-all-negative-arrays)
13. [Finding the Actual Subarray](#13-finding-the-actual-subarray)
14. [How to Recognize Kadane's Algorithm](#14-how-to-recognize-kadanes-algorithm)
15. [When NOT to Use Kadane's Algorithm](#15-when-not-to-use-kadanes-algorithm)
16. [Common Variations](#16-common-variations)
17. [Common Mistakes](#17-common-mistakes)
18. [Edge Cases](#18-edge-cases)
19. [Complexity Analysis](#19-complexity-analysis)
20. [Problem-Solving Process](#20-problem-solving-process)
21. [Top 10 Interview Questions](#21-top-10-interview-questions)
22. [30-Second Interview Answer](#22-30-second-interview-answer)
23. [Cheat Sheet](#23-cheat-sheet)
24. [Practice Roadmap](#24-practice-roadmap)
25. [Final Mental Model](#25-final-mental-model)

---

## 1. What Is Kadane's Algorithm?

Kadane's Algorithm is a **dynamic programming / greedy-style algorithm** used to find the **maximum sum of a contiguous subarray** in an array.

For example:

```text
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

The maximum-sum contiguous subarray is:

```text
[4, -1, 2, 1]
```

Its sum is:

```text
4 + (-1) + 2 + 1 = 6
```

Therefore:

```text
Maximum subarray sum = 6
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/lightbulb.svg?color=%23fbbf24" width="24"></td>
<td><b>Core Definition</b><br>
Kadane's Algorithm keeps the best subarray ending at the current position and uses it to build the answer for the next position.
</td>
</tr>
</table>

---

## 2. The Problem Kadane Solves

The classic problem is:

> Given an integer array, find the contiguous subarray having the largest sum and return that sum.

### Example

```text
Input:
[-2,1,-3,4,-1,2,1,-5,4]

Output:
6
```

Because:

```text
[4,-1,2,1] → 6
```

### Important Word: Contiguous

Contiguous means the elements must be next to each other.

Valid:

```text
[4,-1,2,1]
```

Invalid:

```text
[4,2,1]
```

because `-1` was skipped.

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/triangle-alert.svg?color=%23ef4444" width="24"></td>
<td><b>WARNING</b><br>
Kadane's Algorithm is about <b>contiguous</b> subarrays. It is not the same as finding the maximum sum subsequence.
</td>
</tr>
</table>

---

## 3. Why Brute Force Is Not Enough

Suppose we try every possible subarray.

For:

```text
[1,2,3,4]
```

Possible subarrays include:

```text
[1]
[1,2]
[1,2,3]
[1,2,3,4]

[2]
[2,3]
[2,3,4]

[3]
[3,4]

[4]
```

There are approximately:

```text
n(n+1)/2
```

subarrays.

A straightforward solution can therefore become:

```text
O(n²)
```

or even:

```text
O(n³)
```

if we calculate each subarray's sum from scratch.

Kadane reduces the problem to:

```text
O(n)
```

---

## 4. Core Mental Model

This is the most important part.

While traversing the array, ask:

> **"What is the maximum sum of a subarray that ends exactly at this index?"**

For every element, there are only two meaningful choices:

### Choice 1 — Start a new subarray

```text
currentSum = current element
```

### Choice 2 — Extend the previous subarray

```text
currentSum = previous currentSum + current element
```

Therefore:

```text
currentSum = max(nums[i], currentSum + nums[i])
```

That single decision is the heart of Kadane's Algorithm.

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/flame.svg?color=%23f97316" width="24"></td>
<td><b>CORE INSIGHT</b><br>
At every element, ask: <b>"Is my previous subarray helping me, or is it hurting me?"</b>
</td>
</tr>
</table>

---

## 5. The Main Insight

Suppose:

```text
currentSum = -5
```

and the next number is:

```text
10
```

We have two choices:

```text
Continue:
-5 + 10 = 5

Start fresh:
10
```

Obviously:

```text
10 > 5
```

So we throw away the previous negative contribution.

This gives:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
```

### The important idea

A negative previous sum can only make the future sum smaller.

Therefore:

```text
negative contribution → discard it
positive contribution → keep it
```

---

## 6. Deriving Kadane's Algorithm

Let's derive it instead of memorizing it.

Suppose:

```text
nums = [-2, 1, -3, 4]
```

Start:

```text
currentSum = -2
maxSum = -2
```

Now encounter `1`.

Two possibilities:

```text
Start new:
1

Extend:
-2 + 1 = -1
```

Choose:

```text
1
```

Now:

```text
currentSum = 1
maxSum = 1
```

Next:

```text
-3
```

Choices:

```text
Start new:
-3

Extend:
1 + (-3) = -2
```

Choose:

```text
-2
```

But the global maximum is still:

```text
1
```

Next:

```text
4
```

Choices:

```text
Start:
4

Extend:
-2 + 4 = 2
```

Choose:

```text
4
```

Now:

```text
currentSum = 4
maxSum = 4
```

So the recurrence becomes:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
maxSum = Math.max(maxSum, currentSum);
```

---

## 7. The Two Important Variables

Kadane becomes extremely easy once these two variables are separated mentally.

### `currentSum`

Represents:

> Maximum sum of a subarray that **must end at the current index**.

### `maxSum`

Represents:

> Maximum sum found **anywhere so far**.

Think:

```text
currentSum → local best
maxSum     → global best
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/target.svg?color=%2360a5fa" width="24"></td>
<td><b>MEMORY TRICK</b><br>
<code>currentSum</code> asks: "What is best ending here?"<br>
<code>maxSum</code> asks: "What is best overall?"
</td>
</tr>
</table>

---

## 8. Step-by-Step Dry Run

Consider:

```text
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

Initialize:

```text
currentSum = -2
maxSum = -2
```

Now process each element.

| i | num | currentSum | maxSum |
| - | --: | ---------: | -----: |
| 0 |  -2 |         -2 |     -2 |
| 1 |   1 |          1 |      1 |
| 2 |  -3 |         -2 |      1 |
| 3 |   4 |          4 |      4 |
| 4 |  -1 |          3 |      4 |
| 5 |   2 |          5 |      5 |
| 6 |   1 |          6 |      6 |
| 7 |  -5 |          1 |      6 |
| 8 |   4 |          5 |      6 |

Final answer:

```text
6
```

The winning subarray is:

```text
[4, -1, 2, 1]
```

---

## 9. Java Implementation

### Basic Kadane

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i],
                                  currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

### Short Version

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }

        return max;
    }
}
```

### Why initialize with `nums[0]`?

Because the array can contain only negative numbers.

For example:

```text
[-5,-2,-8]
```

The answer is:

```text
-2
```

If we initialized:

```java
maxSum = 0;
```

we would incorrectly return:

```text
0
```

---

## 10. Why Do We Reset the Current Sum?

This is the most common conceptual question.

Suppose:

```text
currentSum = -7
```

and:

```text
nums[i] = 5
```

Compare:

```text
currentSum + nums[i]
= -7 + 5
= -2
```

versus:

```text
nums[i]
= 5
```

Clearly:

```text
5 > -2
```

Therefore:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
```

The previous subarray is abandoned.

### Why?

Because a negative prefix can never improve the sum of a future subarray.

For example:

```text
[-10, 5, 6]
```

If we keep `-10`:

```text
-10 + 5 + 6 = 1
```

If we discard it:

```text
5 + 6 = 11
```

So:

```text
negative prefix → liability
positive prefix → asset
```

---

## 11. Why Does `maxSum` Come After Updating `currentSum`?

Correct:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
maxSum = Math.max(maxSum, currentSum);
```

Because `maxSum` must compare against the **best subarray ending at the current index**.

For example:

```text
currentSum = 5
nums[i] = 4
```

After processing:

```text
currentSum = 9
```

Only then should we check:

```text
maxSum = max(maxSum, 9)
```

So the order matters.

---

## 12. All-Negative Arrays

Consider:

```text
[-8, -3, -6, -2, -5, -4]
```

The maximum subarray is:

```text
[-2]
```

Answer:

```text
-2
```

Kadane handles this naturally.

```java
int currentSum = nums[0];
int maxSum = nums[0];
```

Then:

```text
-8
-3
-6
-2
-5
-4
```

The largest value encountered is:

```text
-2
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/triangle-alert.svg?color=%23ef4444" width="24"></td>
<td><b>COMMON BUG</b><br>
Do not initialize <code>maxSum</code> to <code>0</code> unless the problem explicitly allows an empty subarray.
</td>
</tr>
</table>

---

## 13. Finding the Actual Subarray

Sometimes the question asks for the maximum sum.

Sometimes it asks for the actual subarray.

For that, maintain:

```text
start
end
tempStart
```

### Java

```java
class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Start: " + start);
        System.out.println("End: " + end);

        return maxSum;
    }
}
```

For:

```text
[-2,1,-3,4,-1,2,1,-5,4]
```

we get:

```text
start = 3
end = 6
```

Therefore:

```text
[4,-1,2,1]
```

---

## 14. How to Recognize Kadane's Algorithm

Look for these signals.

### Signal 1 — Maximum Sum

Words like:

```text
maximum sum
largest sum
maximum possible sum
highest sum
```

### Signal 2 — Contiguous

The problem explicitly says:

```text
subarray
contiguous
continuous segment
consecutive elements
```

### Signal 3 — One-Dimensional Array

Typical form:

```text
Given an integer array...
find the contiguous subarray...
having the maximum sum.
```

### Signal 4 — O(n) Expected

If brute force is O(n²) and the expected solution is O(n), Kadane should immediately come to mind.

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/search.svg?color=%2360a5fa" width="24"></td>
<td><b>RECOGNITION PATTERN</b><br>
<b>Maximum + Sum + Contiguous Subarray</b> → Think <b>Kadane</b>.
</td>
</tr>
</table>

---

## 15. When NOT to Use Kadane's Algorithm

Kadane is not a universal array algorithm.

Do not automatically use it when you see the word "maximum."

### Not Kadane:

```text
Maximum product subarray
```

This requires tracking:

```text
maximum product
minimum product
```

because a negative number can turn a minimum into a maximum.

### Not Kadane:

```text
Maximum sum subsequence
```

because elements do not necessarily need to be contiguous.

### Not automatically Kadane:

```text
Maximum sum with exactly K elements
```

This may require a sliding window.

### Not automatically Kadane:

```text
Maximum sum subarray of size K
```

This is typically:

```text
Sliding Window
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/triangle-alert.svg?color=%23ef4444" width="24"></td>
<td><b>DO NOT PATTERN-MATCH BLINDLY</b><br>
"Maximum" alone does not mean Kadane. Check whether you are finding the best <b>contiguous sum</b>.
</td>
</tr>
</table>

---

## 16. Common Variations

### 16.1 Maximum Subarray

Classic Kadane:

```text
Maximum sum
+
Contiguous subarray
```

---

### 16.2 Maximum Circular Subarray

Example:

```text
[5,-3,5]
```

Normal maximum:

```text
7
```

Circular maximum:

```text
5 + 5 = 10
```

A common approach uses:

```text
max(normal Kadane,
    totalSum - minimumSubarraySum)
```

with the important all-negative edge case.

---

### 16.3 Minimum Subarray

Kadane's idea can be inverted.

Instead of:

```java
Math.max(...)
```

use:

```java
Math.min(...)
```

Conceptually:

```text
maximum subarray → keep the best positive contribution

minimum subarray → keep the best negative contribution
```

---

### 16.4 Maximum Product Subarray

This is **not standard Kadane**.

Because:

```text
negative × negative = positive
```

you need both:

```text
currentMax
currentMin
```

So don't blindly apply the sum version.

---

## 17. Common Mistakes

### Mistake 1 — Initializing `maxSum` to zero

Wrong for all-negative arrays:

```java
int maxSum = 0;
```

Better:

```java
int maxSum = nums[0];
```

---

### Mistake 2 — Using only `currentSum`

Wrong:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);

return currentSum;
```

The final `currentSum` is only the best subarray **ending at the final index**.

We need the global maximum:

```java
maxSum
```

---

### Mistake 3 — Forgetting contiguity

Kadane works with:

```text
subarray
```

not arbitrary:

```text
subsequence
```

---

### Mistake 4 — Resetting whenever sum becomes zero

Do not write:

```java
if (currentSum < 0)
    currentSum = 0;
```

without understanding the problem's empty-subarray convention.

The safer general form for the classic problem is:

```java
currentSum = Math.max(nums[i],
                      currentSum + nums[i]);
```

---

### Mistake 5 — Confusing maximum sum with maximum product

They are different patterns.

```text
Maximum Sum     → Kadane
Maximum Product → track max + min
```

---

## 18. Edge Cases

### One Element

```text
[5]
```

Answer:

```text
5
```

---

### One Negative Element

```text
[-5]
```

Answer:

```text
-5
```

---

### All Negative

```text
[-5,-2,-8]
```

Answer:

```text
-2
```

---

### All Positive

```text
[1,2,3,4]
```

Answer:

```text
10
```

---

### Zeros

```text
[0,0,0]
```

Answer:

```text
0
```

---

### Mixed Values

```text
[-2,1,-3,4,-1,2,1,-5,4]
```

Answer:

```text
6
```

---

## 19. Complexity Analysis

Kadane scans the array exactly once.

### Time

```text
O(n)
```

### Space

```text
O(1)
```

Only a few variables are required.

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/gauge.svg?color=%2322c55e" width="24"></td>
<td><b>COMPLEXITY</b><br>
Time: <b>O(n)</b> &nbsp; | &nbsp; Space: <b>O(1)</b>
</td>
</tr>
</table>

---

## 20. Problem-Solving Process

When you encounter a new problem, don't immediately type Kadane's code.

Use this process.

### Step 1 — Identify the object

Ask:

```text
Am I working with an array?
```

### Step 2 — Identify the target

Ask:

```text
Am I maximizing or minimizing a sum?
```

### Step 3 — Check continuity

Ask:

```text
Does the subarray need to be contiguous?
```

### Step 4 — Think locally

Ask:

```text
What is the best subarray ending at this index?
```

### Step 5 — Make the choice

```text
Start fresh
OR
Extend previous subarray
```

### Step 6 — Track the global answer

```text
currentSum → local answer
maxSum     → global answer
```

### Step 7 — Check edge cases

Especially:

```text
all negative
single element
zeros
```

---

## 21. Top 10 Interview Questions

### Q1. What is Kadane's Algorithm?

Kadane's Algorithm finds the maximum sum of a contiguous subarray in O(n) time and O(1) space.

---

### Q2. What is the core recurrence?

```java
currentSum = Math.max(nums[i],
                      currentSum + nums[i]);
```

---

### Q3. Why do we discard a negative prefix?

Because adding a negative sum to a future subarray can only decrease that future sum.

---

### Q4. Why do we need `maxSum`?

Because `currentSum` only represents the best subarray ending at the current position.

`maxSum` stores the best result found anywhere.

---

### Q5. What is the time complexity?

```text
O(n)
```

---

### Q6. What is the space complexity?

```text
O(1)
```

---

### Q7. Does Kadane work with all-negative arrays?

Yes, if initialized correctly:

```java
currentSum = nums[0];
maxSum = nums[0];
```

---

### Q8. What is the difference between a subarray and subsequence?

A subarray must contain contiguous elements.

A subsequence does not necessarily have to be contiguous.

---

### Q9. Can Kadane find the actual subarray?

Yes. Maintain starting and ending indices while processing the array.

---

### Q10. Is maximum product subarray the same as Kadane?

No.

Maximum product requires tracking both the current maximum and current minimum because negative values can reverse their roles.

---

## 22. 30-Second Interview Answer

> "Kadane's Algorithm is used to find the maximum sum of a contiguous subarray in O(n) time and O(1) space. I maintain two variables: `currentSum`, which represents the maximum sum of a subarray ending at the current index, and `maxSum`, which stores the global maximum. For every element, I decide whether to start a new subarray with that element or extend the previous one using `Math.max(nums[i], currentSum + nums[i])`. Then I update `maxSum`. This works because a negative previous sum can only reduce the sum of any subarray that follows it."

---

## 23. Cheat Sheet

### Recognition

```text
Maximum
+
Sum
+
Contiguous Subarray
=
Kadane
```

### Core Formula

```java
currentSum = Math.max(nums[i],
                      currentSum + nums[i]);
```

### Global Answer

```java
maxSum = Math.max(maxSum, currentSum);
```

### Initialization

```java
int currentSum = nums[0];
int maxSum = nums[0];
```

### Complexity

```text
Time  → O(n)
Space → O(1)
```

### Mental Rule

```text
Previous sum negative?
→ Drop it.

Previous sum positive?
→ Consider extending it.
```

---

## 24. Practice Roadmap

### Level 1 — Classic

**LeetCode 53 — Maximum Subarray**

Focus on:

```text
currentSum
maxSum
```

---

### Level 2 — Actual Indices

Modify Kadane to return:

```text
start index
end index
maximum sum
```

---

### Level 3 — Minimum Subarray

Reverse the comparison:

```java
Math.min(...)
```

---

### Level 4 — Maximum Circular Subarray

Learn:

```text
Normal Kadane
+
Minimum Kadane
+
Total Sum
```

---

### Level 5 — Maximum Product Subarray

Move beyond simple Kadane and learn why:

```text
currentMax
currentMin
```

are both required.

---

## 25. Final Mental Model

Don't memorize this:

```java
current = Math.max(nums[i], current + nums[i]);
```

Understand this:

```text
I have a previous subarray.

Is its contribution useful?

        YES
         ↓
     Extend it

        NO
         ↓
    Start fresh
```

Then separately ask:

```text
Is this the best sum I've seen so far?

        YES
         ↓
      Update max
```

So the complete mental model is:

```text
             Current Element
                    │
             ┌──────┴──────┐
             │             │
        Start Fresh    Extend Previous
             │             │
             └──────┬──────┘
                    ↓
              currentSum
                    │
                    ↓
             Update maxSum
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/flame.svg?color=%23f97316" width="24"></td>
<td><b>FINAL CORE INSIGHT</b><br><br>
Kadane is not really about "resetting a sum whenever it becomes negative."<br><br>
It is about comparing two possibilities at every index:<br><br>
<b>1. Start a new subarray here.</b><br>
<b>2. Continue the best subarray from before.</b><br><br>
That is the entire algorithm.
</td>
</tr>
</table>

---

## One-Line Memory Trick

```text
BEST ENDING HERE → currentSum
BEST SEEN SO FAR → maxSum
```

Or even shorter:

```text
KEEP THE USEFUL PREFIX.
DROP THE HARMFUL PREFIX.
TRACK THE GLOBAL BEST.
```

---

## Quick Reference

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(
                nums[i],
                currentSum + nums[i]
            );

            maxSum = Math.max(
                maxSum,
                currentSum
            );
        }

        return maxSum;
    }
}
```

<table>
<tr>
<td width="42"><img src="https://api.iconify.design/lucide/book-open-check.svg?color=%2360a5fa" width="24"></td>
<td><b>REVISION CHECK</b><br>
If you can explain why <code>Math.max(nums[i], currentSum + nums[i])</code> is necessary without looking at the code, you understand Kadane's Algorithm.
</td>
</tr>
</table>
