<div align="center">

# 🎯 Sliding Window — Practice List

***Pure sliding-window problems only. Learn the pattern, attempt it yourself, then open the platform you prefer.***

![Total](https://img.shields.io/badge/Total-35_Problems-6C63FF?style=for-the-badge)

![Easy](https://img.shields.io/badge/Easy-12-2ea44f?style=for-the-badge)

![Medium](https://img.shields.io/badge/Medium-18-f0ad00?style=for-the-badge)

![Hard](https://img.shields.io/badge/Hard-5-e5484d?style=for-the-badge)

**[📖 Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)**

</div>

> [!NOTE]
>
> Only problems where the **sliding window technique is a core part of the intended solution** are included.
>
> The list is divided into:
>
> * **Fixed Window** — window size `k` remains constant.
> * **Variable Window** — expand/shrink the window according to a condition.
> * **Frequency / HashMap Window** — maintain counts inside the current window.
> * **Advanced Window** — harder variations requiring multiple conditions, frequency tracking, or optimized window maintenance.
>
> A "—" means no platform link is added for that platform (no exact match or link not verified).

---

## 🧭 The Sliding Window Patterns

| Pattern                       | Use it when                                            | Core idea                                                     |
| :---------------------------- | :----------------------------------------------------- | :------------------------------------------------------------ |
| **Fixed Window**              | Window size `k` is given                               | Add `right`, remove the element leaving from `left`           |
| **Variable Window — At Most** | Need longest/shortest window satisfying an upper bound | Expand with `right`, shrink while condition is violated       |
| **Variable Window — Minimum** | Need the smallest valid window                         | Expand until valid, then shrink aggressively                  |
| **Frequency Window**          | Characters/elements and their frequencies matter       | Maintain a `HashMap` / frequency array for the current window |
| **Exactly K**                 | Need exactly `k` distinct/items                        | Often solve using `atMost(k) - atMost(k-1)`                   |
| **Monotonic Deque Window**    | Need max/min of every window                           | Maintain a deque of useful candidates                         |

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
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">1</td>
<td><b>Maximum Sum Subarray of Size K</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">2</td>
<td><b>First Negative Integer in Every Window of Size K</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">3</td>
<td><b>Maximum Average Subarray I</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-average-subarray-i/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">4</td>
<td><b>Contains Duplicate II</b><br/><sub>Fixed / Bounded Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">HashSet Window</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/contains-duplicate-ii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">5</td>
<td><b>Maximum Number of Vowels in a Substring of Given Length</b><br/><sub>Fixed Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">6</td>
<td><b>Find All Anagrams in a String</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Frequency</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/anagram-1587115620/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">7</td>
<td><b>Permutation in String</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Frequency</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/permutation-in-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">8</td>
<td><b>Maximum Consecutive Ones I</b><br/><sub>Variable Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/max-consecutive-ones/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">9</td>
<td><b>Longest Substring Without Repeating Characters</b><br/><sub>Variable + Frequency Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">HashSet / Map</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">10</td>
<td><b>Longest Subarray of 1's After Deleting One Element</b><br/><sub>Variable Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">11</td>
<td><b>Max Consecutive Ones III</b><br/><sub>Variable Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">At Most K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/max-consecutive-ones-iii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">12</td>
<td><b>Defuse the Bomb</b><br/><sub>Fixed Circular Window</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">Fixed</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/defuse-the-bomb/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
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
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">13</td>
<td><b>Subarray Product Less Than K</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/subarray-product-less-than-k/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">14</td>
<td><b>Longest Repeating Character Replacement</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-repeating-character-replacement/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">15</td>
<td><b>Fruit Into Baskets</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most 2 Distinct</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663136552/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/fruit-into-baskets/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">16</td>
<td><b>Longest Substring with At Most K Distinct Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K Distinct</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center">—</td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">17</td>
<td><b>Subarrays with K Different Integers</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/subarrays-with-k-different-integers/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">18</td>
<td><b>Binary Subarrays With Sum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/binary-subarrays-with-sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">19</td>
<td><b>Number of Subarrays with Bounded Maximum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">20</td>
<td><b>Minimum Size Subarray Sum</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Minimum Window</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-size-subarray-sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">21</td>
<td><b>Permutation in String</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Fixed Frequency</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/permutation-in-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">22</td>
<td><b>Find All Anagrams in a String</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Fixed Frequency</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/anagram-1587115620/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">23</td>
<td><b>Count Number of Nice Subarrays</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Exactly K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/count-number-of-nice-subarrays/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">24</td>
<td><b>Number of Substrings Containing All Three Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Minimum Valid Window</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">25</td>
<td><b>Longest Substring with At Most Two Distinct Characters</b><br/><sub>Frequency Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most 2 Distinct</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">26</td>
<td><b>Maximum Points You Can Obtain from Cards</b><br/><sub>Fixed Complement Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Complement Window</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">27</td>
<td><b>Get Equal Substrings Within Budget</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most Cost</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/get-equal-substrings-within-budget/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">28</td>
<td><b>Frequency of the Most Frequent Element</b><br/><sub>Sorted + Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most Cost</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">29</td>
<td><b>Maximize the Confusion of an Exam</b><br/><sub>Variable Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">At Most K</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">30</td>
<td><b>Longest Nice Subarray</b><br/><sub>Bitmask Window</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">Bitmask</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-nice-subarray/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
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
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>

<tbody>

<tr>
<td align="center">31</td>
<td><b>Minimum Window Substring</b><br/><sub>Frequency + Minimum Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Frequency</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/smallest-window-containing-all-characters-of-another-string/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-window-substring/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">32</td>
<td><b>Sliding Window Maximum</b><br/><sub>Monotonic Deque Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Deque</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/sliding-window-maximum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">33</td>
<td><b>Substring with Concatenation of All Words</b><br/><sub>Multiple Frequency Windows</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Frequency</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">34</td>
<td><b>Longest Substring with At Most K Distinct Characters — Advanced</b><br/><sub>Frequency Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">At Most K</td>
<td align="center">—</td>
<td align="center">—</td>
<td align="center">—</td>
</tr>

<tr>
<td align="center">35</td>
<td><b>Minimum Window Subsequence</b><br/><sub>Window + Subsequence Validation</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">Minimum Window</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/minimum-window-subsequence/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>

</tbody>
</table>

</div>

---

## 🧠 Recommended Practice Flow

1. Read the problem only.
2. Ask: **"Is this asking about a contiguous subarray/substring?"**
3. Identify whether the window is **fixed** or **variable**.
4. If fixed → maintain exactly `k` elements.
5. If variable → expand `right` and shrink `left` whenever the condition becomes invalid.
6. Ask what information the window must remember:

   * Sum?
   * Frequency?
   * Number of distinct elements?
   * Number of invalid elements?
   * Maximum/minimum?
7. Write the solution yourself in VS Code.
8. Dry-run one normal example and one edge case.
9. Only then check the editorial/video if needed.

---

### 🔥 Sliding Window Mental Template

```text
left = 0

for right = 0 to n - 1:

    add arr[right] to window

    while window is invalid:

        remove arr[left] from window
        left++

    update answer
```

For a **fixed-size window**:

```text
for right = 0 to n - 1:

    add arr[right]

    if window size > k:
        remove arr[left]
        left++

    if window size == k:
        update answer
```

---

### 🧩 Quick Pattern Recognition

| Question wording                        | Think                     |
| :-------------------------------------- | :------------------------ |
| **Subarray / substring of size K**      | Fixed Window              |
| **Maximum / minimum sum of K elements** | Fixed Window              |
| **Longest substring without repeating** | Frequency Window          |
| **At most K distinct**                  | Variable + HashMap        |
| **At most K replacements**              | Variable + Frequency      |
| **Minimum window containing...**        | Expand → valid → shrink   |
| **Exactly K distinct**                  | `atMost(K) - atMost(K-1)` |
| **Every window of size K**              | Fixed Window              |
| **Maximum/minimum of every window**     | Deque Window              |
| **Longest window under a cost/budget**  | Variable Window           |

---

### ✅ Quick Revision Checklist

* [ ] Fixed Window — 12
* [ ] Variable Window — 10
* [ ] Frequency / HashMap Window — 8
* [ ] Advanced Window — 5
* [ ] Total — 35

### 🔗 Related Resources

* [Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)
* [Take U Forward](https://takeuforward.org/)
* [LeetCode](https://leetcode.com/)
* [GeeksforGeeks](https://www.geeksforgeeks.org/)

> [!IMPORTANT]
>
> The goal of this sheet is **pattern recognition**, not simply collecting questions. If a problem can be solved naturally by maintaining a contiguous range `[left...right]` and updating that range as it moves, it belongs to the sliding-window family.
