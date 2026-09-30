<div align="center">

# 🎯 Sliding Window — Practice List

***Pure sliding window problems only. Learn the pattern, attempt it yourself, then open the platform you prefer.***

![Total](https://img.shields.io/badge/Total-30_Problems-6C63FF?style=for-the-badge)

![Easy](https://img.shields.io/badge/Easy-8-2ea44f?style=for-the-badge)

![Medium](https://img.shields.io/badge/Medium-17-f0ad00?style=for-the-badge)

![Hard](https://img.shields.io/badge/Hard-5-e5484d?style=for-the-badge)

**[📖 Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)**

</div>

> [!NOTE]
>
> Only problems where **Sliding Window is a core part of the intended approach** are included.
>
> TUF links are intentionally removed. The **Company** column shows companies associated with the problem through interview/company-tag sources. If no company could be verified, `—` is used.
>
> Sliding Window is divided into:
>
> * **Fixed Window**
> * **Variable Window**
> * **Frequency / HashMap Window**
> * **Exactly K / At Most K**
> * **Advanced Window / Deque**

---

## 🧭 The Sliding Window Patterns

| Pattern              | Use it when                                                 | Core idea                                                     |
| :------------------- | :---------------------------------------------------------- | :------------------------------------------------------------ |
| **Fixed Window**     | Window size `k` is fixed                                    | Add the new element and remove the element leaving the window |
| **Variable Window**  | Window size depends on a condition                          | Expand with `right`, shrink with `left`                       |
| **Frequency Window** | Characters/elements inside the window must be counted       | Maintain a frequency map/array                                |
| **At Most K**        | Window can contain at most `k` violations/distinct elements | Shrink while the condition is violated                        |
| **Exactly K**        | Need exactly `k` distinct elements/items                    | Often use `atMost(k) - atMost(k - 1)`                         |
| **Minimum Window**   | Need the smallest valid substring/subarray                  | Expand until valid, then shrink as much as possible           |
| **Deque Window**     | Need max/min for every fixed window                         | Maintain a monotonic deque                                    |

---

<div align="center">

## 🟢 Sliding Window — Easy

<table>

<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">Pattern</th>
<th align="center">Company</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">1</td>
<td><b>Maximum Sum Subarray of Size K</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">OYO Rooms, NPCI</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">2</td>
<td><b>First Negative Integer in Every Window of Size K</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">Amazon</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">3</td>
<td><b>Maximum Average Subarray I</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-average-subarray-i/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">4</td>
<td><b>Maximum Number of Vowels in a Substring of Given Length</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">5</td>
<td><b>Max Consecutive Ones</b><br/><sub>Variable Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Variable</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/max-consecutive-ones/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">6</td>
<td><b>Contains Duplicate II</b><br/><sub>Bounded Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">HashSet Window</td>
<td align="center">Amazon</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/contains-duplicate-ii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">7</td>
<td><b>Minimum Size Subarray Sum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Minimum</td>
<td align="center">Amazon, Microsoft, TikTok, Citi</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-size-subarray-sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">8</td>
<td><b>Longest Substring Without Repeating Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">HashMap / Set</td>
<td align="center">Microsoft, Freecharge, Citigroup</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

</tbody>
</table>

---

## 🟡 Sliding Window — Medium

<table>

<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">Pattern</th>
<th align="center">Company</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">9</td>
<td><b>Permutation in String</b><br/><sub>Fixed Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Frequency</td>
<td align="center">Microsoft</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/permutation-in-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">10</td>
<td><b>Find All Anagrams in a String</b><br/><sub>Fixed Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Frequency</td>
<td align="center">Databricks</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/anagram-1587115620/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">11</td>
<td><b>Longest Repeating Character Replacement</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K</td>
<td align="center">Amazon, Apple, DoorDash, Garmin</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/longest-repeating-character-replacement/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">12</td>
<td><b>Fruit Into Baskets</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most 2 Distinct</td>
<td align="center">—</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663136552/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/fruit-into-baskets/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">13</td>
<td><b>Longest Substring with At Most K Distinct Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K Distinct</td>
<td align="center">—</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">14</td>
<td><b>Subarrays with K Different Integers</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">DoorDash</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/subarrays-with-k-different-integers/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">15</td>
<td><b>Max Consecutive Ones III</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K</td>
<td align="center">LinkedIn</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/max-consecutive-ones-iii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">16</td>
<td><b>Subarray Product Less Than K</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/subarray-product-less-than-k/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">17</td>
<td><b>Number of Subarrays with Bounded Maximum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">18</td>
<td><b>Binary Subarrays With Sum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/binary-subarrays-with-sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">19</td>
<td><b>Count Number of Nice Subarrays</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/count-number-of-nice-subarrays/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">20</td>
<td><b>Number of Substrings Containing All Three Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Minimum Valid Window</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">21</td>
<td><b>Maximum Points You Can Obtain from Cards</b><br/><sub>Complement Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Fixed Complement</td>
<td align="center">Flipkart</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">22</td>
<td><b>Get Equal Substrings Within Budget</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most Cost</td>
<td align="center">IBM</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/get-equal-substrings-within-budget/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">23</td>
<td><b>Frequency of the Most Frequent Element</b><br/><sub>Sorted + Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most Cost</td>
<td align="center">Infosys</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">24</td>
<td><b>Longest Nice Subarray</b><br/><sub>Bitmask Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Bitmask</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-nice-subarray/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">25</td>
<td><b>Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</b><br/><sub>Deque Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Monotonic Deque</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

</tbody>
</table>

---

## 🔴 Sliding Window — Hard

<table>

<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">Pattern</th>
<th align="center">Company</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">26</td>
<td><b>Minimum Window Substring</b><br/><sub>Frequency + Minimum Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Minimum Window</td>
<td align="center">TikTok</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/smallest-window-containing-all-characters-of-another-string/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-window-substring/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">27</td>
<td><b>Sliding Window Maximum</b><br/><sub>Monotonic Deque</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Deque</td>
<td align="center">Oracle</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/sliding-window-maximum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">28</td>
<td><b>Substring with Concatenation of All Words</b><br/><sub>Multiple Frequency Windows</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Frequency</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">29</td>
<td><b>Minimum Window Subsequence</b><br/><sub>Minimum Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Minimum Window</td>
<td align="center">—</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-window-subsequence/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

<tr>
<td align="center">30</td>
<td><b>Shortest Subarray with Sum at Least K</b><br/><sub>Deque + Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Deque</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
</tr>

</tbody>
</table>

</div>

---

## 🧠 Recommended Practice Flow

1. Read the problem only.
2. Ask: **"Am I working with a contiguous subarray or substring?"**
3. Identify whether the window is **fixed** or **variable**.
4. Decide what information the window must maintain:

   * Sum
   * Frequency
   * Distinct count
   * Number of invalid elements
   * Maximum / minimum
   * Cost
5. Expand the `right` pointer.
6. If the window becomes invalid, shrink using `left`.
7. Update the answer at the correct point.
8. Dry-run one normal example and one edge case.
9. Only then check the solution/editorial.

---

## 🔥 Core Sliding Window Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add arr[right] to the window

    while (windowIsInvalid) {

        // Remove arr[left] from the window
        left++;
    }

    // Update answer
}
```

### Fixed Window Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add current element

    if (right - left + 1 > k) {
        // Remove left element
        left++;
    }

    if (right - left + 1 == k) {
        // Process current window
    }
}
```

---

## 🧩 Quick Pattern Recognition

| Question wording                        | Think                       |
| :-------------------------------------- | :-------------------------- |
| **Subarray / substring of size K**      | Fixed Window                |
| **Maximum sum of K elements**           | Fixed Window                |
| **Every window of size K**              | Fixed Window                |
| **Longest substring without repeating** | Frequency Window            |
| **At most K distinct**                  | HashMap + Variable Window   |
| **At most K replacements**              | Frequency + Variable Window |
| **Minimum window containing something** | Expand → Valid → Shrink     |
| **Exactly K distinct**                  | `atMost(K) - atMost(K - 1)` |
| **Maximum/minimum of every window**     | Monotonic Deque             |
| **Longest window under a budget**       | Variable Window             |
| **Cards from both ends**                | Complement Window           |

---

## 🧠 Sliding Window Memory Trick

**RIGHT → EXPAND**

**LEFT → SHRINK**

**WINDOW → MAINTAIN**

**ANSWER → UPDATE**

```text
             RIGHT
               ↓
        ┌───────────────┐
        │    WINDOW     │
        └───────────────┘
          ↑           ↑
        LEFT         RIGHT

RIGHT = explore
LEFT  = repair
WINDOW = current valid range
ANSWER = best result
```

---

### ✅ Quick Revision Checklist

* [ ] Fixed Window — 8
* [ ] Variable Window — 9
* [ ] Frequency / HashMap Window — 7
* [ ] Exactly K / At Most K — 3
* [ ] Deque / Advanced Window — 3
* [ ] Total — 30

### 🔗 Related Resources

* [Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)
* [Take U Forward](https://takeuforward.org/)
* [LeetCode](https://leetcode.com/)
* [GeeksforGeeks](https://www.geeksforgeeks.org/)

> [!IMPORTANT]
>
> **Sliding Window is a pattern, not just a list of questions.**
>
> The important skill is recognizing when a contiguous range can be maintained incrementally instead of recomputing every subarray/substring from scratch.
