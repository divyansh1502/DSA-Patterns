<div align="center">

# 🎯 Two Pointer Patterns — Practice List

*A quick revision hub: learn the pattern, attempt the problem yourself, then open the platform you prefer.*

![Total](https://img.shields.io/badge/Total-37_Problems-6C63FF?style=for-the-badge)
![Easy](https://img.shields.io/badge/Easy-14-2ea44f?style=for-the-badge)
![Medium](https://img.shields.io/badge/Medium-14-f0ad00?style=for-the-badge)
![Hard](https://img.shields.io/badge/Hard-9-e5484d?style=for-the-badge)

**[📖 Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)**

</div>

> [!NOTE]
> This is a curated pattern list (Two Pointers plus its close cousin, Sliding Window), not an official Striver A2Z section. A "—" means no link is added for that platform (no exact match, or the link is not verified). Under each problem name, the small text shows which pattern it trains.

---

## 🧭 Pattern Cheat Sheet

| Pattern | Use it when | Core idea |
| :-- | :-- | :-- |
| **Opposite Ends** | Sorted array, pairs, palindromes | `left = 0`, `right = n-1`; move inward based on the sum/comparison |
| **Read / Write** | In-place filtering or compaction | `read` scans every element, `write` marks where the next valid one goes |
| **Fast & Slow** | Linked lists, cycles, middle element | Slow moves 1 step, fast moves 2 (or starts with a gap) |
| **Two Sequences** | Merging or comparing two arrays/strings | One pointer per sequence, advance the smaller/matching one |
| **Three Pointers** | Partitioning into groups (0/1/2) | `low`, `mid`, `high` (Dutch National Flag) |
| **Sliding Window** | Longest/shortest/count of subarrays | Expand `right`, shrink `left` while the window is invalid |

---

<div align="center">

## 🟢 Two Pointers — Easy

<table>
<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">1</td>
<td><b>Valid Palindrome</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/palindrome-string0817/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/valid-palindrome/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">2</td>
<td><b>Reverse String</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/reverse-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">3</td>
<td><b>Valid Palindrome II</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/valid-palindrome-ii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">4</td>
<td><b>Reverse Vowels of a String</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/reverse-vowels-of-a-string/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">5</td>
<td><b>Squares of a Sorted Array</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/squares-of-a-sorted-array/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">6</td>
<td><b>Move Zeros to End</b><br/><sub>Read / Write</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/move-zeroes/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/move-zeros-to-end"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">7</td>
<td><b>Remove Duplicates from Sorted Array</b><br/><sub>Read / Write</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/remove-duplicates-in-place-from-sorted-array/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/remove-duplicates-from-sorted-array"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">8</td>
<td><b>Remove Element</b><br/><sub>Read / Write</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/remove-element/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">9</td>
<td><b>Merge Sorted Array</b><br/><sub>Two Sequences</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/merge-sorted-array/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/merge-two-sorted-arrays-without-extra-space"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">10</td>
<td><b>Is Subsequence</b><br/><sub>Two Sequences</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/is-subsequence/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">11</td>
<td><b>Backspace String Compare</b><br/><sub>Two Sequences</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/backspace-string-compare/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">12</td>
<td><b>Linked List Cycle</b><br/><sub>Fast & Slow</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/linked-list-cycle/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">13</td>
<td><b>Middle of the Linked List</b><br/><sub>Fast & Slow</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/middle-of-the-linked-list/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">14</td>
<td><b>Happy Number</b><br/><sub>Fast & Slow</sub></td>
<td align="center">🟢&nbsp;Easy</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/happy-number/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
</tbody>
</table>

---

## 🟡 Two Pointers — Medium

<table>
<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">15</td>
<td><b>Two Sum II — Input Array Is Sorted</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">16</td>
<td><b>Container With Most Water</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/container-with-most-water0535/1"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/container-with-most-water/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">17</td>
<td><b>3 Sum</b><br/><sub>Sort + Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/3sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/3-sum"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">18</td>
<td><b>3 Sum Closest</b><br/><sub>Sort + Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/3sum-closest/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">19</td>
<td><b>4 Sum</b><br/><sub>Sort + Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/4sum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/4-sum"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">20</td>
<td><b>Sort an Array of 0s, 1s and 2s</b><br/><sub>Three Pointers (Dutch Flag)</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/sort-colors/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center"><a href="https://takeuforward.org/practice/dsa/sort-an-array-of-0s-1s-and-2s"><img src="../Images/takeUforward.jpg" width="24" height="24" alt="TUF"></a></td>
</tr>
<tr>
<td align="center">21</td>
<td><b>Remove Duplicates from Sorted Array II</b><br/><sub>Read / Write</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">22</td>
<td><b>Max Number of K-Sum Pairs</b><br/><sub>Sort + Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">23</td>
<td><b>Boats to Save People</b><br/><sub>Sort + Opposite Ends</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/boats-to-save-people/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">24</td>
<td><b>Longest Palindromic Substring</b><br/><sub>Expand from Center</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-palindromic-substring/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">25</td>
<td><b>Linked List Cycle II</b><br/><sub>Fast & Slow</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/linked-list-cycle-ii/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">26</td>
<td><b>Find the Duplicate Number</b><br/><sub>Fast & Slow</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/find-the-duplicate-number/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">27</td>
<td><b>Remove Nth Node From End of List</b><br/><sub>Fast & Slow (Gap)</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">28</td>
<td><b>Reorder List</b><br/><sub>Fast & Slow + Reverse</sub></td>
<td align="center">🟡&nbsp;Medium</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/reorder-list/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
</tbody>
</table>

---

## 🔴 Two Pointers — Hard

<table>
<thead>
<tr>
<th align="center">#</th>
<th align="left">Problem</th>
<th align="center">Level</th>
<th align="center">GFG</th>
<th align="center">LeetCode</th>
<th align="center">TUF</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">29</td>
<td><b>Trapping Rain Water</b><br/><sub>Opposite Ends</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center"><a href="https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1/"><img src="../Images/gfg.png" width="24" height="24" alt="GFG"></a></td>
<td align="center"><a href="https://leetcode.com/problems/trapping-rain-water/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">30</td>
<td><b>Minimum Window Substring</b><br/><sub>Sliding Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/minimum-window-substring/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">31</td>
<td><b>Substring with Concatenation of All Words</b><br/><sub>Sliding Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">32</td>
<td><b>Sliding Window Maximum</b><br/><sub>Sliding Window + Deque</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/sliding-window-maximum/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">33</td>
<td><b>Subarrays with K Different Integers</b><br/><sub>Sliding Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/subarrays-with-k-different-integers/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">34</td>
<td><b>Count Subarrays With Score Less Than K</b><br/><sub>Sliding Window</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/count-subarrays-with-score-less-than-k/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">35</td>
<td><b>Longest Valid Parentheses</b><br/><sub>Two-Pass Scan</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/longest-valid-parentheses/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">36</td>
<td><b>Shortest Palindrome</b><br/><sub>Two Pointers + KMP</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/shortest-palindrome/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
<tr>
<td align="center">37</td>
<td><b>Median of Two Sorted Arrays</b><br/><sub>Two Sequences + Binary Search</sub></td>
<td align="center">🔴&nbsp;Hard</td>
<td align="center">—</td>
<td align="center"><a href="https://leetcode.com/problems/median-of-two-sorted-arrays/"><img src="../Images/leetcode.png" width="24" height="24" alt="LeetCode"></a></td>
<td align="center">—</td>
</tr>
</tbody>
</table>

</div>

---

## 🧠 Recommended Practice Flow

1. Read the problem only.
2. Write the brute-force (usually nested loops, O(n²)) first.
3. Ask: *can sorting, or a second pointer, remove the inner loop?*
4. Identify the pattern from the cheat sheet above.
5. Write the optimal solution yourself in VS Code.
6. Dry-run one normal example and one edge case (empty, single element, duplicates).
7. Only then check the editorial/video if needed.

### ✅ Quick Revision Checklist

- [ ] Two Pointers Easy — 14
- [ ] Two Pointers Medium — 14
- [ ] Two Pointers Hard — 9
- [ ] Total — 37

### 🔗 Related Resources

- [Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet)
- [Take U Forward](https://takeuforward.org/)
- [LeetCode](https://leetcode.com/)
- [GeeksforGeeks](https://www.geeksforgeeks.org/)

> [!IMPORTANT]
> Problems are grouped by the difficulty shown on LeetCode. Some Hard entries (Sliding Window variants) build directly on two-pointer thinking, so they are included to complete the pattern.