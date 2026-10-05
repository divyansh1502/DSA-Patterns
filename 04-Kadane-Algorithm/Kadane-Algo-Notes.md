# 🎯 Kadane's Algorithm in Java — Complete DSA Guide

> **Goal:** Learn how to recognize, think about, implement, debug, and
> extend **Kadane's Algorithm** in Java for LeetCode and GeeksforGeeks problems.

---

## 📌 Table of Contents

1. [What Is Kadane's Algorithm?](#-what-is-kadanes-algorithm)
2. [Why Kadane?](#-why-kadane)
3. [Core Mental Model](#-core-mental-model)
4. [The Recurrence](#-the-recurrence)
5. [When to Think of Kadane](#-when-to-think-of-kadane)
6. [When NOT to Think of Kadane](#-when-not-to-think-of-kadane)
7. [Dry Run](#-dry-run)
8. [Canonical Java Template](#-canonical-java-template)
9. [Variation 1 — Return Start & End Indices](#-variation-1--return-start--end-indices)
10. [Variation 2 — All Negative Numbers](#-variation-2--all-negative-numbers)
11. [Variation 3 — Maximum Circular Subarray](#-variation-3--maximum-circular-subarray)
12. [Variation 4 — Maximum Product Subarray](#-variation-4--maximum-product-subarray)
13. [Variation 5 — Stock Buy/Sell as Kadane](#-variation-5--stock-buysell-as-kadane)
14. [Variation 6 — Minimum Subarray Sum](#-variation-6--minimum-subarray-sum)
15. [Kadane vs Sliding Window vs Two Pointers](#-kadane-vs-sliding-window-vs-two-pointers)
16. [How to Approach a LeetCode/GFG Problem](#-how-to-approach-a-leetcodegfg-problem)
17. [Brute Force vs Kadane](#-brute-force-vs-kadane)
18. [Time and Space Complexity](#-time-and-space-complexity)
19. [Common Mistakes](#-common-mistakes)
20. [Edge Cases Checklist](#-edge-cases-checklist)
21. [Practice Roadmap](#-practice-roadmap)
22. [Problem-Solving Checklist](#-problem-solving-checklist)
23. [Interview 30-Second Answer](#-interview-30-second-answer)
24. [Cheat Sheet](#-kadane-cheat-sheet)

---

# 🧠 What Is Kadane's Algorithm?

**Kadane's Algorithm** finds the **maximum sum of a contiguous subarray** in a single pass.

Example:

```text
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Best subarray → [4, -1, 2, 1]
Sum           → 6
```

The key idea:

> **At every index, decide: extend the previous subarray, or start fresh here?**

> 💡 **Tip:** Kadane is really a **1D Dynamic Programming** idea with O(1) space.
> You only need the previous state, so no DP array is required.

---

# 🚀 Why Kadane?

Brute force checks every subarray:

```text
(0,0) (0,1) (0,2) ... (0,n-1)
(1,1) (1,2) ...
...
```

That is **O(n²)** with a running sum, or **O(n³)** if you re-sum each time.

Kadane reduces this to:

```text
O(n³) → O(n²) → O(n)
```

> 🔥 **Important:** The speed-up comes from realizing that a *negative-sum prefix*
> can never help a future subarray, so we can drop it immediately.

---

# 🧠 Core Mental Model

Walk left to right. At each index `i`, keep **one number**:

```text
currentSum = best sum of a subarray that ENDS exactly at i
```

And a second number:

```text
maxSum = best answer seen anywhere so far
```

Now the decision at each element `x = nums[i]`:

```text
┌─────────────────────────────────────────────┐
│  Option A: extend  → currentSum + x         │
│  Option B: restart → x                      │
│                                             │
│  currentSum = max(A, B)                     │
└─────────────────────────────────────────────┘
```

**Why restart?**
If `currentSum` (the sum before `x`) is **negative**, attaching it to `x` only makes things worse.
A negative baggage is dead weight, so throw it away.

> 💡 **Tip:** Think of it as carrying a backpack. If the backpack is **heavy with debt**
> (negative sum), drop it and start fresh.

---

# 📐 The Recurrence

```text
dp[i] = max(nums[i], dp[i-1] + nums[i])

answer = max(dp[i]) over all i
```

Equivalent form:

```text
if (currentSum < 0) currentSum = 0;   // drop negative baggage
currentSum += nums[i];
```

> ⚠️ **Warning:** The "reset to 0" form is **not safe** when all numbers are negative
> (see [Variation 2](#-variation-2--all-negative-numbers)).
> The `max(nums[i], currentSum + nums[i])` form is always correct. **Prefer it.**

---

# 🔎 When to Think of Kadane

## Signal 1 — "Maximum/Minimum sum subarray"
```text
"largest sum contiguous subarray"
"maximum subarray"
"best contiguous segment"
```

## Signal 2 — Contiguity + optimization + negatives allowed
```text
contiguous  ✔
sum/product ✔
negatives   ✔   ← very strong signal
```

## Signal 3 — "Best ending here" can be defined
If you can say *"the best answer ending at index i depends only on the best ending at i-1"*,
Kadane-style DP applies.

## Signal 4 — Disguised problems
```text
Stock buy/sell (single transaction) → Kadane on price differences
Max absolute subarray sum           → Kadane for max AND min
Circular array max sum              → Kadane + total - min Kadane
Max product subarray                → Kadane tracking max AND min
```

> 🔥 **Hot take:** If a problem says *contiguous* and has *negatives*, think Kadane **before** thinking sliding window.

---

# 🚫 When NOT to Think of Kadane

### 1. Subsequence (non-contiguous) problems
Kadane needs the elements to be **adjacent**.

### 2. Fixed-size window
```text
"max sum of subarray of size K"
```
This is a **sliding window**, not Kadane.

### 3. Count of subarrays with sum = K
That is **prefix sum + HashMap**.

### 4. Constraints like "length at least K" or "at most K elements"
Needs modification (prefix sums, deque), plain Kadane is not enough.

### 5. You can't define "best ending at i"
If the state depends on more than the previous value, you may need full DP.

---

# 🧪 Dry Run

```text
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

| i | nums[i] | extend (cur+x) | restart (x) | currentSum | maxSum |
|---|---------|----------------|-------------|------------|--------|
| 0 | -2      | —              | -2          | -2         | -2     |
| 1 | 1       | -1             | 1           | **1**      | 1      |
| 2 | -3      | -2             | -3          | -2         | 1      |
| 3 | 4       | 2              | 4           | **4**      | 4      |
| 4 | -1      | 3              | -1          | 3          | 4      |
| 5 | 2       | 5              | 2           | 5          | 5      |
| 6 | 1       | 6              | 1           | 6          | **6**  |
| 7 | -5      | 1              | -5          | 1          | 6      |
| 8 | 4       | 5              | 4           | 5          | 6      |

```text
Answer = 6   →   subarray [4, -1, 2, 1]
```

> 💡 **Tip:** Notice at `i = 1` and `i = 3` the algorithm **restarted** because the previous sum was negative.
> That is the whole trick.

---

# 💻 Canonical Java Template

## ✅ LeetCode 53 — Maximum Subarray

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

### Why initialize with `nums[0]` and not `0`?

```text
If all numbers are negative, e.g. [-3, -1, -2],
initializing with 0 would wrongly return 0.
The true answer is -1.
```

### Complexity
```text
Time:  O(n)
Space: O(1)
```

> 🔥 **Memorize this one.** It is the base for every variation below.

---

# 🧩 Variation 1 — Return Start & End Indices

Many interview/GFG problems ask for the **actual subarray**.

```java
class Solution {
    public int[] maxSubArrayIndices(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];   // restart
                tempStart = i;
            } else {
                currentSum += nums[i];  // extend
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSum};
    }
}
```

### Thinking
```text
tempStart → where the CURRENT running subarray began
start/end → where the BEST subarray began/ended
```

> ⚠️ **Mistake alert:** Don't update `start` at the moment of restarting.
> Update `tempStart` on restart, and copy to `start` **only when a new best is found**.

---

# 🧩 Variation 2 — All Negative Numbers

```text
nums = [-5, -2, -8]
Expected answer = -2   (NOT 0)
```

### ❌ Wrong version
```java
int cur = 0, max = 0;          // max = 0 is the bug
for (int x : nums) {
    cur = Math.max(0, cur + x);
    max = Math.max(max, cur);
}
return max;                    // returns 0 ❌
```

### ✅ Correct version
```java
int cur = nums[0], max = nums[0];
for (int i = 1; i < nums.length; i++) {
    cur = Math.max(nums[i], cur + nums[i]);
    max = Math.max(max, cur);
}
return max;
```

> ⚠️ **Warning:** The "empty subarray allowed → answer ≥ 0" version is a **different problem**.
> Always read whether an empty subarray is permitted.

---

# 🧩 Variation 3 — Maximum Circular Subarray

**LeetCode 918 — Maximum Sum Circular Subarray**

```text
nums = [5, -3, 5]
Circular best = 5 + 5 = 10   (wraps around)
```

## Core idea

A circular best subarray is either:

```text
Case 1: Normal subarray (no wrap)       → regular Kadane
Case 2: Wrapping subarray               → total − (minimum subarray)
```

Why Case 2? A wrapping subarray = **everything except a middle chunk**.
To maximize what remains, **minimize the removed middle chunk**.

```text
answer = max( maxKadane , totalSum − minKadane )
```

## Special case 🔥

If **all numbers are negative**, `maxKadane < 0`.
Then `totalSum − minKadane` would be `0` (empty subarray), which is invalid.

```text
if (maxKadane < 0) return maxKadane;
```

## Java

```java
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];

        for (int x : nums) {
            total += x;

            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);
        }

        if (maxSum < 0) return maxSum;     // all negative

        return Math.max(maxSum, total - minSum);
    }
}
```

```text
Time:  O(n)
Space: O(1)
```

> 💡 **Tip:** `curMax = 0` initially is fine here because `max(x, 0 + x) = x` on the first step.

---

# 🧩 Variation 4 — Maximum Product Subarray

**LeetCode 152**

Why is product harder than sum?

```text
Negative × Negative = Positive
```

A very **small (negative)** product can suddenly become the **largest** after meeting another negative.
So we track **both** max and min.

```text
[2, 3, -2, 4]   → 6
[-2, 3, -4]     → 24
```

## Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            if (x < 0) {
                int temp = curMax;   // negative flips max <-> min
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(x, curMax * x);
            curMin = Math.min(x, curMin * x);

            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}
```

> 🔥 **Key insight:** A negative number **swaps** the roles of max and min.
> A zero **resets** both automatically thanks to `Math.max(x, ...)` / `Math.min(x, ...)`.

---

# 🧩 Variation 5 — Stock Buy/Sell as Kadane

**LeetCode 121 — Best Time to Buy and Sell Stock**

```text
prices = [7, 1, 5, 3, 6, 4]
daily differences = [-6, 4, -2, 3, -2]
```

Max profit = **maximum subarray sum of the differences**.

```text
4 + (-2) + 3 = 5
```

## Direct Kadane-style code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
```

> 💡 **Tip:** Same spirit. "Best ending today" = `price − cheapest so far`.

---

# 🧩 Variation 6 — Minimum Subarray Sum

Just flip `max` ↔ `min`.

```java
int cur = nums[0], min = nums[0];
for (int i = 1; i < nums.length; i++) {
    cur = Math.min(nums[i], cur + nums[i]);
    min = Math.min(min, cur);
}
```

### Related: LeetCode 1749 — Max Absolute Sum of Any Subarray

```text
answer = max( maxKadane , abs(minKadane) )
```

> 🔥 Run both Kadane versions in **one loop**.

---

# ⚔️ Kadane vs Sliding Window vs Two Pointers

| Feature | Kadane | Sliding Window | Two Pointers |
|---|---|---|---|
| Handles negatives | ✅ Yes | ❌ Usually no | Depends |
| Window size | Dynamic | Fixed / variable | Dynamic |
| Core idea | Extend or restart | Add right, remove left | Move based on property |
| Technique type | 1D DP | Window maintenance | Search-space elimination |
| Typical problem | Max subarray | Max sum of size K | Pair sum on sorted array |

```text
Positive numbers only + target sum → Sliding Window
Negatives + max sum contiguous     → Kadane
Sorted + pairs                     → Two Pointers
```

> ⚠️ **Why sliding window fails with negatives:**
> Adding an element no longer guarantees the sum grows, so you can't decide when to shrink the window.
> Kadane doesn't need to shrink anything. It simply restarts.

---

# 🧠 How to Approach a LeetCode/GFG Kadane Problem

## Step 1 — Identify the ask
```text
Contiguous? Sum or product? Max or min? Circular? Need indices?
```

## Step 2 — Write the brute force
```text
for i in 0..n
    for j in i..n
        sum of nums[i..j]
```
`O(n²)`

## Step 3 — Find the wasted work
```text
Recomputing sums of subarrays that start with a NEGATIVE prefix.
```

## Step 4 — Define the state in one sentence
```text
currentSum = best subarray sum ending at index i
```
If you can't say this sentence, stop and rethink.

## Step 5 — Define the transition
```text
currentSum = max(nums[i], currentSum + nums[i])
```

## Step 6 — Define what you return
```text
maxSum (the best across ALL i), not just the last currentSum.
```

## Step 7 — Dry run a tiny array
```text
[-2, 1, -3, 4]
```

> 💡 **Tip:** The most common bug is returning `currentSum` instead of `maxSum`.

---

# ⚡ Brute Force vs Kadane

### Brute force

```java
int max = Integer.MIN_VALUE;
for (int i = 0; i < n; i++) {
    int sum = 0;
    for (int j = i; j < n; j++) {
        sum += nums[j];
        max = Math.max(max, sum);
    }
}
```

```text
Time: O(n²)   Space: O(1)
```

### Kadane

```text
Time: O(n)    Space: O(1)
```

> 🔥 For `n = 10⁵`, brute force does ~10¹⁰ operations (TLE). Kadane does ~10⁵.

---

# ⏱️ Time and Space Complexity

```text
Time:  O(n)   → single pass
Space: O(1)   → only 2 variables
```

If you use a `dp[]` array to explain the DP formulation:

```text
Space: O(n)  → but can be reduced to O(1)
```

---

# ⚠️ Common Mistakes

## ❌ Mistake 1 — Initializing `max` to 0
Breaks all-negative arrays.
```text
Use nums[0]  or  Integer.MIN_VALUE
```

## ❌ Mistake 2 — Returning `currentSum`
```java
return currentSum;   // ❌ gives the best subarray ENDING at last index
return maxSum;       // ✅
```

## ❌ Mistake 3 — Forgetting to update `maxSum` every iteration
`maxSum` must be updated **after every** `currentSum` update.

## ❌ Mistake 4 — Using `Integer.MIN_VALUE` with addition
```java
int cur = Integer.MIN_VALUE;
cur + x    // may overflow ⚠️
```
Initialize with `nums[0]` to avoid overflow.

## ❌ Mistake 5 — Wrong circular logic for all-negative arrays
`total − minSum` can equal `0` (empty subarray). Guard with `if (maxSum < 0)`.

## ❌ Mistake 6 — Not swapping max/min in product Kadane
A negative `x` must swap `curMax` and `curMin` **before** multiplying.

## ❌ Mistake 7 — Updating `start` incorrectly (index version)
Use `tempStart` and copy to `start` only on a new best.

## ❌ Mistake 8 — Using Kadane for subsequences
Kadane is **contiguous only**.

---

# 🧪 Edge Cases Checklist

```text
[5]                       // single element
[-5]                      // single negative
[-3, -1, -2]              // all negative
[1, 2, 3]                 // all positive → whole array
[0, 0, 0]                 // all zeros
[-1, 0, -2]               // zero is the best
[5, -100, 5]              // restart is better than extend
[1, -1, 1, -1]            // ties
[Integer.MAX_VALUE, 1]    // overflow (use long if needed)
large n (10^5)            // brute force TLE
circular: all negative    // guard needed
product: zeros + negatives
```

> 💡 **Tip:** If sums can be huge, use `long` for `currentSum` and `maxSum`.

---

# 🏋️ Practice Roadmap

## 🟢 Beginner

| Problem | Platform | Pattern |
|---|---|---|
| Maximum Subarray (53) | LeetCode | Classic Kadane |
| Kadane's Algorithm | GFG | Classic Kadane |
| Best Time to Buy and Sell Stock (121) | LeetCode | Kadane / min-so-far |
| Maximum Absolute Sum of Any Subarray (1749) | LeetCode | Max + Min Kadane |

## 🟡 Intermediate

| Problem | Platform | Pattern |
|---|---|---|
| Maximum Sum Circular Subarray (918) | LeetCode | Kadane + total − min |
| Maximum Product Subarray (152) | LeetCode | Track max & min |
| Longest Turbulent Subarray (978) | LeetCode | Kadane-style state |
| Maximum Subarray Sum with One Deletion (1186) | LeetCode | Kadane + 2 states |

## 🔴 Challenging

```text
363   Max Sum of Rectangle No Larger Than K   (2D Kadane + TreeSet)
2321  Maximum Score Of Spliced Array           (Kadane on difference)
1191  K-Concatenation Maximum Sum
Max Sum Rectangle in a 2D Matrix              (2D Kadane)
```

---

# 🎯 Problem-Solving Checklist

```text
[ ] Is the subarray contiguous?
[ ] Can numbers be negative?
[ ] Am I maximizing or minimizing?
[ ] Sum or product?
[ ] Can I define "best ending at i"?
[ ] Is an empty subarray allowed?
[ ] Is the array circular?
[ ] Do I need indices or just the value?
[ ] Did I initialize with nums[0]?
[ ] Do I return maxSum, not currentSum?
[ ] Is overflow possible?
[ ] Did I dry run on all-negative input?
```

---

# 🎤 Interview: 30-Second Answer

> **Kadane's Algorithm finds the maximum sum contiguous subarray in O(n) time
> and O(1) space. At each index we keep the best sum of a subarray ending
> there, choosing between extending the previous subarray or starting fresh,
> using `current = max(nums[i], current + nums[i])`. We track the global
> maximum across all positions. It works because a negative prefix can never
> help a future subarray. It's essentially 1D dynamic programming, and it
> extends to circular arrays, product subarrays, and stock-profit problems.**

---

# 🧠 Kadane Cheat Sheet

```text
┌──────────────────────────────────────────────┐
│                  KADANE                       │
├──────────────────────────────────────────────┤
│ State                                         │
│ → cur = best sum ENDING at i                  │
│ → max = best sum anywhere                     │
│                                               │
│ Transition                                    │
│ → cur = max(nums[i], cur + nums[i])           │
│ → max = max(max, cur)                         │
│                                               │
│ Init                                          │
│ → cur = max = nums[0]                         │
│                                               │
│ Min subarray                                  │
│ → flip max ↔ min                              │
│                                               │
│ Circular                                      │
│ → max(maxKadane, total − minKadane)           │
│ → if maxKadane < 0 return maxKadane           │
│                                               │
│ Product                                       │
│ → track curMax & curMin, swap on negative     │
│                                               │
│ Complexity                                    │
│ → O(n) time, O(1) space                       │
└──────────────────────────────────────────────┘
```

---

# 🔥 Final Mental Model

```text
Contiguous + optimize + negatives?
        ↓
Can I define "best ending here"?
        ↓
Does it depend only on the previous one?
        ↓
Extend or restart?
        ↓
Kadane ✅
```

---

# 💎 One-Line Memory Trick

```text
Kadane = At every step, ask: "Is my past helping me or hurting me?"
         Helping → extend.   Hurting → drop it and restart.
```

> 💡 If you can explain **why a negative prefix gets dropped**, you truly understand Kadane.