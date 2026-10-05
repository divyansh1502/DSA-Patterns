# <img src="https://api.iconify.design/lucide/link-2.svg?color=%2360a5fa" width="30"> Slow & Fast Pointer Pattern in Java

<div align="center">

### A Deep-Dive Linked List + Two-Pointer Guide

<img src="https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=060a1a">
<img src="https://img.shields.io/badge/Pattern-Slow%20%26%20Fast%20Pointers-00f5d4?style=for-the-badge&labelColor=060a1a">
<img src="https://img.shields.io/badge/DSA-Linked%20List-7c5cff?style=for-the-badge&labelColor=060a1a">

<br><br>

<img src="https://img.shields.io/badge/Patterns-8%2F20_ready-00f5d4?style=for-the-badge&labelColor=060a1a">

<img src="https://img.shields.io/badge/Practice_Problems-10-7c5cff?style=for-the-badge&labelColor=060a1a">

<img src="https://img.shields.io/badge/Interview_Ready-Progressive-ff5ecb?style=for-the-badge&labelColor=060a1a">

</div>

---

> **Goal:** Understand Linked Lists in Java deeply enough that Slow/Fast Pointer problems, cycle detection, middle finding, palindrome, reorder, intersection, and duplicate-number problems become natural applications of the same underlying ideas.

---

# Table of Contents

1. [What Is a Linked List?](#1-what-is-a-linked-list)
2. [Why Learn the Java Structure First?](#2-why-learn-the-java-structure-first)
3. [Array vs Linked List](#3-array-vs-linked-list)
4. [What Exactly Is a Node?](#4-what-exactly-is-a-node)
5. [Understanding References in Java](#5-understanding-references-in-java)
6. [Building a Linked List Manually](#6-building-a-linked-list-manually)
7. [What Is `head`?](#7-what-is-head)
8. [What Is `null`?](#8-what-is-null)
9. [Traversing a Linked List](#9-traversing-a-linked-list)
10. [How `current = current.next` Works](#10-how-current--currentnext-works)
11. [Searching in a Linked List](#11-searching-in-a-linked-list)
12. [Insertion in a Linked List](#12-insertion-in-a-linked-list)
13. [Deletion in a Linked List](#13-deletion-in-a-linked-list)
14. [Why Linked Lists Are Pointer Problems](#14-why-linked-lists-are-pointer-problems)
15. [What Is the Slow & Fast Pointer Pattern?](#15-what-is-the-slow--fast-pointer-pattern)
16. [The Core Mental Model](#16-the-core-mental-model)
17. [Why Does Fast Move Twice?](#17-why-does-fast-move-twice)
18. [Pattern 1 — Find the Middle](#18-pattern-1--find-the-middle)
19. [Pattern 2 — Detect a Cycle](#19-pattern-2--detect-a-cycle)
20. [Floyd's Cycle Detection](#20-floyds-cycle-detection)
21. [Why Must We Compare Nodes, Not Values?](#21-why-must-we-compare-nodes-not-values)
22. [Pattern 3 — Find Cycle Entrance](#22-pattern-3--find-cycle-entrance)
23. [Pattern 4 — Maintain a Fixed Gap](#23-pattern-4--maintain-a-fixed-gap)
24. [Pattern 5 — Middle + Reverse](#24-pattern-5--middle--reverse)
25. [Pattern 6 — Middle + Reverse + Merge](#25-pattern-6--middle--reverse--merge)
26. [Pattern 7 — Intersection of Two Linked Lists](#26-pattern-7--intersection-of-two-linked-lists)
27. [Pattern 8 — Cycle Detection in General State Sequences](#27-pattern-8--cycle-detection-in-general-state-sequences)
28. [How to Decide Pointer Initialization](#28-how-to-decide-pointer-initialization)
29. [How to Decide Pointer Movement](#29-how-to-decide-pointer-movement)
30. [How to Decide the Loop Condition](#30-how-to-decide-the-loop-condition)
31. [How to Know What `slow` Means](#31-how-to-know-what-slow-means)
32. [How to Approach a Linked List Problem](#32-how-to-approach-a-linked-list-problem)
33. [Canonical Java Templates](#33-canonical-java-templates)
34. [Important Problems](#34-important-problems)
35. [Solved Example — Middle of Linked List](#35-solved-example--middle-of-linked-list)
36. [Solved Example — Linked List Cycle](#36-solved-example--linked-list-cycle)
37. [Solved Example — Linked List Cycle II](#37-solved-example--linked-list-cycle-ii)
38. [Solved Example — Remove Nth Node](#38-solved-example--remove-nth-node)
39. [Solved Example — Palindrome Linked List](#39-solved-example--palindrome-linked-list)
40. [Solved Example — Reorder List](#40-solved-example--reorder-list)
41. [Solved Example — Intersection](#41-solved-example--intersection)
42. [Solved Example — Happy Number](#42-solved-example--happy-number)
43. [Solved Example — Find Duplicate Number](#43-solved-example--find-duplicate-number)
44. [How the Problems Are Connected](#44-how-the-problems-are-connected)
45. [Common Mistakes](#45-common-mistakes)
46. [Complexity](#46-complexity)
47. [Edge Cases Checklist](#47-edge-cases-checklist)
48. [Problem-Solving Checklist](#48-problem-solving-checklist)
49. [Top Interview Questions](#49-top-interview-questions)
50. [30-Second Interview Answer](#50-30-second-interview-answer)
51. [Final Cheat Sheet](#51-final-cheat-sheet)
52. [Memory Map](#52-memory-map)

---

# 1. What Is a Linked List?

A **Linked List** is a linear data structure made up of individual objects called **nodes**, where each node stores some data and a reference to another node.

A basic singly linked-list node contains:

```java
class ListNode {

    int val;
    ListNode next;

}
```

There are two important parts:

```text
val
 ↓
the actual data

next
 ↓
reference to the next node
```

For example:

```text
10 → 20 → 30 → 40 → null
```

Each box is a node.

```text
┌───────┐      ┌───────┐      ┌───────┐
│  10   │      │  20   │      │  30   │
│ next ─┼─────→│ next ─┼─────→│ next ─┼──→ null
└───────┘      └───────┘      └───────┘
```

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/lightbulb.svg?color=%23fbbf24" width="22"></td>
<td>

<b>Important:</b> A Linked List is not just "a collection of values".

It is a collection of <b>nodes connected through references</b>.

</td>
</tr>
</table>

---

# 2. Why Learn the Java Structure First?

Before solving:

```text
Middle of Linked List
Cycle Detection
Palindrome Linked List
Reorder List
Remove Nth Node
```

you should understand what this actually means:

```java
slow = slow.next;
```

If you only memorize that line, you may remember the code today and forget it later.

But if you understand:

```text
node
 ↓
next reference
 ↓
another node
 ↓
another next reference
```

then:

```java
slow = slow.next;
```

becomes completely natural.

### The learning order should be:

```text
Java Class
     ↓
Node
     ↓
Reference
     ↓
head
     ↓
next
     ↓
Traversal
     ↓
Insertion / Deletion
     ↓
Two Pointers
     ↓
Slow & Fast
     ↓
Linked List Problems
```

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/flame.svg?color=%23f97316" width="22"></td>
<td>

<b>CORE IDEA</b><br><br>
Don't learn Slow/Fast Pointer as an isolated trick.<br><br>
It is simply a clever way of <b>moving through linked nodes</b>.

</td>
</tr>
</table>

---

# 3. Array vs Linked List

Understanding the difference is extremely important.

| Property            | Array                | Linked List                       |
| ------------------- | -------------------- | --------------------------------- |
| Memory              | Usually contiguous   | Nodes can be scattered            |
| Access by index     | O(1)                 | O(n)                              |
| Traversal           | Index based          | Reference based                   |
| Insert at beginning | O(n) generally       | O(1)                              |
| Delete known node   | Can require shifting | Can be O(1) with proper reference |
| Random access       | Yes                  | No                                |
| Main connection     | Index                | Reference                         |

### Array

```text
arr[0]
arr[1]
arr[2]
arr[3]
```

You can directly jump to:

```text
arr[100]
```

if it exists.

### Linked List

```text
head
 ↓
10 → 20 → 30 → 40 → 50
```

To reach `50`, you normally follow:

```text
10
 ↓
20
 ↓
30
 ↓
40
 ↓
50
```

You cannot simply say:

```java
head[4]
```

There is no such random-access operation.

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/triangle-alert.svg?color=%23ef4444" width="22"></td>
<td>

<b>Common misunderstanding:</b> A Linked List does not automatically make insertion/deletion O(1) everywhere.

If you first need to <b>find the position</b>, finding it can still take O(n).

</td>
</tr>
</table>

---

# 4. What Exactly Is a Node?

Let's create the node class.

```java
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

Suppose:

```java
ListNode node1 = new ListNode(10);
```

Conceptually:

```text
node1
  ↓
┌─────────────┐
│ val = 10    │
│ next = null │
└─────────────┘
```

Now:

```java
ListNode node2 = new ListNode(20);
```

We have:

```text
node1
  ↓
┌──────┬──────┐
│  10  │  ?   │
└──────┴──────┘

node2
  ↓
┌──────┬──────┐
│  20  │ null │
└──────┴──────┘
```

Connect them:

```java
node1.next = node2;
```

Now:

```text
node1
 ↓
10 → 20 → null
```

That single line:

```java
node1.next = node2;
```

creates the link.

---

# 5. Understanding References in Java

This is where many beginners get confused.

Consider:

```java
ListNode a = new ListNode(10);
ListNode b = new ListNode(20);

a.next = b;
```

`a` does not contain the complete node object.

It holds a **reference** to the node object.

Conceptually:

```text
a ───────────────┐
                 ↓
             ┌─────────┐
             │ val = 10│
             │ next ───┼──────┐
             └─────────┘      │
                               ↓
                           ┌─────────┐
                           │ val = 20│
                           │ next=null│
                           └─────────┘
```

Therefore:

```java
a.next
```

means:

> Go to the node referenced by `a`, then follow its `next` reference.

And:

```java
a.next.next
```

means:

> Go one node forward, then one more node forward.

For:

```text
10 → 20 → 30 → null
```

we get:

```text
a
↓
10

a.next
↓
20

a.next.next
↓
30
```

This is the foundation of:

```java
fast.next.next
```

---

# 6. Building a Linked List Manually

Let's create:

```text
10 → 20 → 30 → 40 → null
```

### Step 1

```java
ListNode first = new ListNode(10);
```

### Step 2

```java
ListNode second = new ListNode(20);
```

### Step 3

```java
ListNode third = new ListNode(30);
```

### Step 4

```java
ListNode fourth = new ListNode(40);
```

Connect:

```java
first.next = second;
second.next = third;
third.next = fourth;
```

Now:

```text
first
 ↓
10 → 20 → 30 → 40 → null
```

Usually we call the first node:

```text
head
```

So:

```java
ListNode head = first;
```

---

# 7. What Is `head`?

`head` is a reference to the **first node** of the linked list.

Example:

```text
head
 ↓
10 → 20 → 30 → 40 → null
```

If:

```java
head == null
```

the list is empty.

If:

```java
head != null
```

the list contains at least one node.

### Important

`head` is not the entire linked list.

It is the entry point into the linked list.

Once you have:

```text
head
 ↓
10 → 20 → 30 → null
```

you can reach every node by following:

```text
head.next
head.next.next
head.next.next.next
```

---

# 8. What Is `null`?

`null` means:

> This reference currently points to no object.

In a normal singly linked list, the last node has:

```java
last.next = null;
```

Therefore:

```text
10 → 20 → 30 → null
```

The `null` marks the end.

This is why normal traversal can stop:

```java
while (current != null) {
    ...
    current = current.next;
}
```

---

# 9. Traversing a Linked List

Traversal means:

> Visit every node one by one.

Example:

```text
10 → 20 → 30 → 40 → null
```

Java:

```java
ListNode current = head;

while (current != null) {

    System.out.println(current.val);

    current = current.next;
}
```

Let's understand it.

Initially:

```text
current
   ↓
10 → 20 → 30 → 40 → null
```

After:

```java
current = current.next;
```

we get:

```text
10 → current → 20 → 30 → 40
```

Again:

```java
current = current.next;
```

Now:

```text
10 → 20 → current → 30 → 40
```

Eventually:

```text
10 → 20 → 30 → 40 → current
                         ↓
                       null
```

Loop stops.

---

# 10. How `current = current.next` Works

This line is extremely important.

It does **not** modify the linked list.

It only moves the reference called `current`.

Suppose:

```text
head
 ↓
10 → 20 → 30 → null
```

Initially:

```java
current = head;
```

So:

```text
current
   ↓
  10
```

Then:

```java
current = current.next;
```

means:

```text
current
   ↓
  20
```

The original list remains:

```text
10 → 20 → 30 → null
```

This is why we can safely use temporary pointer variables.

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/lightbulb.svg?color=%23fbbf24" width="22"></td>
<td>

<b>MEMORY TRICK</b><br><br>

<code>current = current.next</code> means:

<b>"Move my reference to the next node."</b>

It does not mean "change the next node."

</td>
</tr>
</table>

---

# 11. Searching in a Linked List

Suppose we want to find `30`.

```java
ListNode current = head;

while (current != null) {

    if (current.val == 30) {
        return true;
    }

    current = current.next;
}

return false;
```

Why O(n)?

Because in the worst case we may have to visit every node.

```text
10 → 20 → 30 → 40 → 50
↑
start

                  ↑
                 target
```

---

# 12. Insertion in a Linked List

Suppose:

```text
10 → 20 → 40
```

We want:

```text
10 → 20 → 30 → 40
```

If we already have a reference to `20`:

```java
ListNode newNode = new ListNode(30);

newNode.next = current.next;
current.next = newNode;
```

Before:

```text
20 → 40
```

After:

```text
20 → 30 → 40
```

The order matters.

Correct:

```java
newNode.next = current.next;
current.next = newNode;
```

If you overwrite:

```java
current.next = newNode;
```

first, you can lose the reference to `40`.

---

# 13. Deletion in a Linked List

Suppose:

```text
10 → 20 → 30 → 40
```

Remove `30`.

We need:

```text
20.next
```

to point to:

```text
40
```

So:

```java
current.next = current.next.next;
```

Before:

```text
20 → 30 → 40
```

After:

```text
20 ───────→ 40
```

The node `30` is no longer connected from the list.

---

# 14. Why Linked Lists Are Pointer Problems

Now the connection becomes clear.

A linked list does not primarily give us:

```text
index
```

It gives us:

```text
next
```

So most linked-list problems are really about controlling references.

Examples:

```text
Traversal
→ current

Middle
→ slow + fast

Cycle
→ slow + fast

Nth from end
→ two pointers + gap

Palindrome
→ middle + reverse

Reorder
→ middle + reverse + merge

Intersection
→ pointer switching
```

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/brain.svg?color=%238b5cf6" width="22"></td>
<td>

<b>SHIFT YOUR THINKING</b><br><br>

Don't think:

"Which line of code solves this problem?"

Think:

<b>"What useful positions do I need to maintain while traversing the nodes?"</b>

</td>
</tr>
</table>

---

# 15. What Is the Slow & Fast Pointer Pattern?

The Slow & Fast Pointer Pattern uses two references moving through a structure at different speeds.

Usually:

```java
slow = slow.next;
fast = fast.next.next;
```

Therefore:

```text
slow → 1 step
fast → 2 steps
```

Example:

```text
1 → 2 → 3 → 4 → 5 → null
```

Initially:

```text
slow
 ↓
1

fast
 ↓
1
```

After one iteration:

```text
slow
 ↓
2

fast
 ↓
3
```

After another:

```text
slow
 ↓
3

fast
 ↓
5
```

Fast reached the end.

Slow is around the middle.

---

# 16. The Core Mental Model

Never memorize:

```java
slow = slow.next;
fast = fast.next.next;
```

as two random statements.

Understand the reason:

```text
fast moves 2× faster than slow
```

Therefore:

```text
Fast travels toward the end
             ↓
Slow travels at half the speed
             ↓
When fast reaches the end,
slow is around the middle
```

And in a cycle:

```text
Fast keeps gaining on slow
             ↓
They eventually meet
```

This gives us two fundamental applications:

```text
MIDDLE
  ↓
slow + fast

CYCLE
  ↓
slow + fast
```

---

# 17. Why Does Fast Move Twice?

Suppose a list has 10 nodes.

If:

```text
slow = 1 step
fast = 2 steps
```

after 5 iterations:

```text
slow → approximately 5 steps
fast → approximately 10 steps
```

Therefore when `fast` reaches the end:

```text
slow ≈ middle
```

This avoids:

```text
1. Count length
2. Divide by 2
3. Traverse again
```

Instead, we can solve it in one traversal.

---

# 18. Pattern 1 — Find the Middle

### Problem

Given:

```text
1 → 2 → 3 → 4 → 5
```

find the middle.

Use:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

Dry run:

```text
Initial:

slow = 1
fast = 1
```

Iteration 1:

```text
slow = 2
fast = 3
```

Iteration 2:

```text
slow = 3
fast = 5
```

Iteration 3:

```text
fast.next == null
```

Stop.

Answer:

```text
3
```

### Even-length list

```text
1 → 2 → 3 → 4
```

With this initialization:

```java
slow = head;
fast = head;
```

the result is:

```text
3
```

If a problem wants the **first middle**, the initialization/loop condition can be adjusted.

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/triangle-alert.svg?color=%23ef4444" width="22"></td>
<td>

<b>IMPORTANT</b><br><br>

For an even-length list, always check whether the problem wants the <b>first middle</b> or <b>second middle</b>.

</td>
</tr>
</table>

---

# 19. Pattern 2 — Detect a Cycle

Consider:

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

There is no `null`.

The list keeps looping.

Use:

```java
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

If there is no cycle:

```text
fast → null
```

and the loop stops.

If there is a cycle:

```text
slow ↘
       cycle
fast ↗
```

Fast eventually catches slow.

---

# 20. Floyd's Cycle Detection

This is commonly called:

**Floyd's Tortoise and Hare Algorithm**

because:

```text
slow = tortoise
fast = hare
```

The movement:

```text
slow → 1 step
fast → 2 steps
```

### Why must they meet?

Inside a cycle, imagine the cycle as a circular track.

Slow moves:

```text
1 step
```

Fast moves:

```text
2 steps
```

So every iteration fast gains:

```text
2 - 1 = 1
```

position relative to slow.

Eventually the faster pointer catches the slower one.

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/flame.svg?color=%23f97316" width="22"></td>
<td>

<b>CORE INSIGHT</b><br><br>

Cycle detection works because inside a finite cycle, two pointers moving at different speeds cannot keep avoiding each other forever.

</td>
</tr>
</table>

---

# 21. Why Must We Compare Nodes, Not Values?

Correct:

```java
if (slow == fast)
```

Wrong:

```java
if (slow.val == fast.val)
```

Why?

Because two different nodes can contain the same value.

Example:

```text
10 → 20 → 10 → 30
```

The two `10`s may be different node objects.

For cycle detection, we care about:

> Are both references pointing to the **same node object**?

Therefore:

```java
slow == fast
```

means:

```text
same object
```

while:

```java
slow.val == fast.val
```

means only:

```text
same value
```

---

# 22. Pattern 3 — Find Cycle Entrance

Detecting a cycle and finding its entrance are two different problems.

### Phase 1

Find the meeting point:

```java
while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        break;
    }
}
```

Suppose they meet somewhere inside the cycle.

### Phase 2

Reset one pointer:

```java
slow = head;
```

Then move both one step:

```java
slow = slow.next;
fast = fast.next;
```

When:

```java
slow == fast
```

that node is the cycle entrance.

### Full code

```java
public ListNode detectCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    return null;
}
```

The mathematical reason comes from the relationship between:

```text
distance from head → cycle entrance
distance from entrance → meeting point
```

You don't need to memorize the proof first.

Understand the two phases:

```text
PHASE 1
Detect cycle
       ↓
Meeting point

PHASE 2
Reset slow to head
       ↓
Move both equally
       ↓
Cycle entrance
```

---

# 23. Pattern 4 — Maintain a Fixed Gap

Problem:

> Find the Nth node from the end.

Example:

```text
1 → 2 → 3 → 4 → 5
```

Find:

```text
2nd from end
```

Answer:

```text
4
```

Instead of calculating length:

```text
length = 5
target = 5 - 2
```

we maintain a gap.

```text
fast
 ↓
1

slow
 ↓
1
```

Move `fast` ahead by `n` positions.

Then move both:

```text
slow → 1 step
fast → 1 step
```

When fast reaches the end:

```text
slow
 ↓
4
```

### Dummy Node Version

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode slow = dummy;
ListNode fast = dummy;

for (int i = 0; i <= n; i++) {
    fast = fast.next;
}

while (fast != null) {
    slow = slow.next;
    fast = fast.next;
}

slow.next = slow.next.next;

return dummy.next;
```

The dummy node makes deleting the head much easier.

---

# 24. Pattern 5 — Middle + Reverse

This pattern is extremely important.

Problem:

> Is a linked list a palindrome?

Example:

```text
1 → 2 → 3 → 2 → 1
```

A palindrome reads the same from both directions.

### Strategy

```text
1. Find middle
2. Reverse second half
3. Compare first half and second half
```

So:

```text
Palindrome
   ↓
Middle
   ↓
Reverse
   ↓
Compare
```

This is why understanding individual linked-list operations first is so important.

---

# 25. Pattern 6 — Middle + Reverse + Merge

Reorder List:

```text
1 → 2 → 3 → 4 → 5
```

Expected:

```text
1 → 5 → 2 → 4 → 3
```

This looks complicated until we break it down.

### Step 1

Find middle:

```text
1 → 2 → 3 | 4 → 5
```

### Step 2

Reverse second half:

```text
5 → 4
```

### Step 3

Merge alternately:

```text
1 → 5 → 2 → 4 → 3
```

So:

```text
Reorder
   ↓
Middle
   +
Reverse
   +
Merge
```

---

# 26. Pattern 7 — Intersection of Two Linked Lists

Suppose:

```text
A: 1 → 2 ───────┐
                ↓
                8 → 9
                ↑
B: 5 → 6 → 7 ──┘
```

The intersection begins at:

```text
8
```

Important:

> Intersection means the **same node object**, not merely equal values.

A beautiful solution is pointer switching:

```java
ListNode a = headA;
ListNode b = headB;

while (a != b) {

    a = (a == null) ? headB : a.next;
    b = (b == null) ? headA : b.next;
}

return a;
```

Each pointer effectively travels:

```text
A + B
```

Therefore the length difference gets canceled.

---

# 27. Pattern 8 — Cycle Detection in General State Sequences

This is where the pattern becomes more powerful.

You don't always need an actual `ListNode`.

Suppose:

```text
number → next number
```

creates a sequence.

For Happy Number:

```text
19
 ↓
82
 ↓
68
 ↓
100
 ↓
1
```

or potentially:

```text
...
 ↓
4
 ↓
16
 ↓
37
 ↓
58
 ↓
4
```

The second sequence contains a cycle.

We can use the same idea:

```text
slow = next(slow)
fast = next(next(fast))
```

This is a powerful DSA lesson:

> The pattern depends on the **structure of the state transitions**, not necessarily on a Linked List class.

---

# 28. How to Decide Pointer Initialization

Initialization matters.

### For Middle

Usually:

```java
ListNode slow = head;
ListNode fast = head;
```

### For Cycle

Usually:

```java
ListNode slow = head;
ListNode fast = head;
```

### For Nth From End

Often:

```java
ListNode slow = dummy;
ListNode fast = dummy;
```

because we need a fixed gap.

### General question

Don't ask:

> "Which initialization did I memorize?"

Ask:

> "What relationship do I want between these two pointers?"

---

# 29. How to Decide Pointer Movement

### Need the middle?

```java
slow = slow.next;
fast = fast.next.next;
```

### Need cycle detection?

Same movement:

```java
slow = slow.next;
fast = fast.next.next;
```

### Need Nth from end?

Same speed after establishing:

```text
fixed gap
```

### Need intersection?

Same speed:

```text
switch heads
```

This gives a useful map:

```text
Middle
→ different speeds

Cycle
→ different speeds

Nth from end
→ same speed + fixed gap

Intersection
→ same speed + head switching
```

---

# 30. How to Decide the Loop Condition

For:

```java
fast = fast.next.next;
```

we need:

```java
while (fast != null && fast.next != null)
```

Why?

Because:

```java
fast.next.next
```

actually requires two valid references.

First:

```text
fast != null
```

Then:

```text
fast.next != null
```

Only then is:

```java
fast.next.next
```

safe.

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/shield-alert.svg?color=%23ef4444" width="22"></td>
<td>

<b>NULL-SAFETY RULE</b><br><br>

Whenever your code contains:

<code>fast.next.next</code>

immediately think:

<code>fast != null && fast.next != null</code>

</td>
</tr>
</table>

---

# 31. How to Know What `slow` Means

This is probably the most important habit in linked-list problems.

Never think:

> "`slow` is just a pointer."

Ask:

> **"What does `slow` represent at this exact moment?"**

### Middle

```text
slow = middle
```

### Cycle detection

```text
slow = one position in the traversal
```

### Cycle entrance

After resetting:

```text
slow = distance from head
```

### Nth from end

```text
slow = node before target
```

when using the dummy-node version.

### Palindrome

```text
slow = beginning of second half
```

The variable name doesn't matter.

Its **meaning** matters.

---

# 32. How to Approach a Linked List Problem

Use this sequence.

### Step 1 — Understand the structure

Ask:

```text
Singly?
Doubly?
Circular?
Possibly cyclic?
```

### Step 2 — Understand the task

Is it asking for:

```text
Middle?
Cycle?
Cycle entrance?
Nth from end?
Palindrome?
Reorder?
Intersection?
```

### Step 3 — Decide what information is needed

Maybe:

```text
Two positions
A fixed gap
A middle point
A previous node
A reversed half
```

### Step 4 — Choose the pointer pattern

```text
Middle
→ slow/fast

Cycle
→ Floyd

Nth from end
→ fixed gap

Palindrome
→ middle + reverse

Reorder
→ middle + reverse + merge

Intersection
→ pointer switching
```

### Step 5 — Check null cases

Always test:

```text
null
one node
two nodes
odd length
even length
cycle
head deletion
```

---

# 33. Canonical Java Templates

## Template A — Middle

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

---

## Template B — Cycle Detection

```java
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

---

## Template C — Cycle Entrance

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

return null;
```

---

## Template D — Nth From End

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode slow = dummy;
ListNode fast = dummy;

for (int i = 0; i <= n; i++) {
    fast = fast.next;
}

while (fast != null) {
    slow = slow.next;
    fast = fast.next;
}

slow.next = slow.next.next;

return dummy.next;
```

---

# 34. Important Problems

|  # | Problem                          |  LC | Main Pattern             |
| -: | -------------------------------- | --: | ------------------------ |
|  1 | Middle of Linked List            | 876 | Slow/Fast                |
|  2 | Linked List Cycle                | 141 | Floyd                    |
|  3 | Linked List Cycle II             | 142 | Cycle Entrance           |
|  4 | Remove Nth Node From End         |  19 | Fixed Gap                |
|  5 | Palindrome Linked List           | 234 | Middle + Reverse         |
|  6 | Reorder List                     | 143 | Middle + Reverse + Merge |
|  7 | Intersection of Two Linked Lists | 160 | Pointer Switching        |
|  8 | Happy Number                     | 202 | Cycle Detection          |
|  9 | Find the Duplicate Number        | 287 | Floyd                    |
| 10 | Circular Array Loop              | 457 | State Cycle              |

### Recommended Order

```text
876
 ↓
141
 ↓
142
 ↓
19
 ↓
234
 ↓
143
 ↓
160
 ↓
202
 ↓
287
 ↓
457
```

Don't rush to the advanced problems.

Build the pattern progressively.

---

# 35. Solved Example — Middle of Linked List

### Problem

```text
1 → 2 → 3 → 4 → 5
```

Return:

```text
3
```

### Thinking

We don't want:

```text
Count length
→ divide by 2
→ traverse again
```

Instead:

```text
slow = 1
fast = 1
```

Then:

```text
slow = 2
fast = 3
```

Then:

```text
slow = 3
fast = 5
```

Stop.

Answer:

```text
3
```

### Code

```java
public ListNode middleNode(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

---

# 36. Solved Example — Linked List Cycle

Input:

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

Movement:

```text
slow → 1 step
fast → 2 steps
```

Eventually:

```text
slow == fast
```

Therefore cycle exists.

### Code

```java
public boolean hasCycle(ListNode head) {

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
}
```

---

# 37. Solved Example — Linked List Cycle II

Goal:

> Return the node where the cycle begins.

Two phases:

```text
Phase 1 → Detect meeting
Phase 2 → Find entrance
```

```java
public ListNode detectCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    return null;
}
```

---

# 38. Solved Example — Remove Nth Node

Example:

```text
1 → 2 → 3 → 4 → 5
```

Remove:

```text
2nd from end
```

Answer:

```text
1 → 2 → 3 → 5
```

Create:

```text
dummy → 1 → 2 → 3 → 4 → 5
```

Maintain a gap of `n + 1`.

Then:

```text
slow
 ↓
3

fast
 ↓
null
```

So:

```java
slow.next = slow.next.next;
```

removes `4`.

---

# 39. Solved Example — Palindrome Linked List

Input:

```text
1 → 2 → 3 → 2 → 1
```

### Step 1

Find middle:

```text
1 → 2 → 3
```

### Step 2

Reverse second half:

```text
1 → 2 → 3

1 ← 2
```

Conceptually:

```text
1 → 2 → 3
     ↑
     2 → 1
```

### Step 3

Compare:

```text
1 == 1
2 == 2
```

Palindrome.

### Pattern

```text
Middle
   ↓
Reverse
   ↓
Compare
```

---

# 40. Solved Example — Reorder List

Input:

```text
1 → 2 → 3 → 4 → 5
```

Required:

```text
1 → 5 → 2 → 4 → 3
```

Break it down:

### Middle

```text
1 → 2 → 3 | 4 → 5
```

### Reverse second half

```text
5 → 4
```

### Merge

```text
1 → 5 → 2 → 4 → 3
```

This problem is not one trick.

It is three known operations combined:

```text
Middle
+
Reverse
+
Merge
```

---

# 41. Solved Example — Intersection

Suppose:

```text
A: 1 → 2 → 8 → 9
             ↑
B: 5 → 6 → 7 ┘
```

The answer is node `8`.

Notice:

```text
A.val == B.val
```

is not the definition.

The actual definition is:

```text
A == B
```

meaning both references point to the same object.

### Pointer Switching

```java
ListNode a = headA;
ListNode b = headB;

while (a != b) {

    a = (a == null) ? headB : a.next;
    b = (b == null) ? headA : b.next;
}

return a;
```

---

# 42. Solved Example — Happy Number

This is where you should realize:

> Slow/Fast is not only for Linked Lists.

Suppose:

```text
n = 19
```

Next state:

```text
19 → 82 → 68 → 100 → 1
```

For an unhappy number, the sequence eventually repeats.

Repeated state means:

```text
cycle
```

Therefore we can use Floyd's idea.

The structure is effectively:

```text
current state
     ↓
next state
     ↓
next state
     ↓
...
```

That is enough for cycle detection.

---

# 43. Solved Example — Find Duplicate Number

This problem looks like an array problem.

But think about the mapping:

```text
index → nums[index]
```

That creates a state-transition structure.

For example:

```text
0 → nums[0]
      ↓
   another index
      ↓
   another index
```

Eventually a cycle exists.

So:

```text
Array
↓
State transitions
↓
Cycle
↓
Floyd
```

This is one of the best examples of **thinking in patterns instead of data structures**.

---

# 44. How the Problems Are Connected

Don't memorize:

```text
LC 876
LC 141
LC 142
LC 19
LC 234
LC 143
```

as six unrelated problems.

They form a progression.

```text
                SLOW & FAST
                     │
          ┌──────────┴──────────┐
          │                     │
       MIDDLE                  CYCLE
          │                     │
          │                ┌────┴────┐
          │                │         │
          │             Detect    Entrance
          │
          ↓
       REVERSE
          │
          ↓
      PALINDROME
          │
          ↓
       REORDER
```

And another branch:

```text
TWO POINTERS
     │
     ├── Fixed Gap
     │      ↓
     │   Nth From End
     │
     └── Head Switching
            ↓
       Intersection
```

This is the real pattern map.

---

# 45. Common Mistakes

## Mistake 1 — Wrong Null Condition

Dangerous:

```java
while (fast != null) {
    fast = fast.next.next;
}
```

Potential `NullPointerException`.

Use:

```java
while (fast != null && fast.next != null)
```

when moving two steps.

---

## Mistake 2 — Comparing Values

Wrong for cycle/intersection identity:

```java
slow.val == fast.val
```

Correct:

```java
slow == fast
```

---

## Mistake 3 — Thinking First Meeting Is Cycle Entrance

First meeting means:

```text
cycle exists
```

not:

```text
this is necessarily the entrance
```

For entrance:

```text
slow = head
```

then move both one step.

---

## Mistake 4 — Forgetting Even-Length Behavior

For:

```text
1 → 2 → 3 → 4
```

know which middle your problem requires.

---

## Mistake 5 — Losing a Reference During Modification

Wrong order:

```java
current.next = newNode;
newNode.next = current.next;
```

The original next node may already be lost.

Correct:

```java
newNode.next = current.next;
current.next = newNode;
```

---

## Mistake 6 — Forgetting the Dummy Node

For deletion problems, especially:

```text
Remove Nth Node From End
```

a dummy node often makes head deletion much cleaner.

---

# 46. Complexity

| Operation / Pattern |     Time |          Space |
| ------------------- | -------: | -------------: |
| Traversal           |     O(n) |           O(1) |
| Search              |     O(n) |           O(1) |
| Find Middle         |     O(n) |           O(1) |
| Cycle Detection     |     O(n) |           O(1) |
| Cycle Entrance      |     O(n) |           O(1) |
| Nth From End        |     O(n) |           O(1) |
| Palindrome          |     O(n) | O(1) auxiliary |
| Reorder             |     O(n) | O(1) auxiliary |
| Intersection        | O(n + m) |           O(1) |

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/gauge.svg?color=%2322c55e" width="22"></td>
<td>

<b>THE BIG WIN</b><br><br>

Many of these problems could be solved using arrays, lengths, or extra HashMaps.

Slow/Fast Pointer often reduces them to:

<b>O(n) time + O(1) extra space.</b>

</td>
</tr>
</table>

---

# 47. Edge Cases Checklist

Before submitting a linked-list solution, test:

### Empty

```text
null
```

### One Node

```text
1 → null
```

### Two Nodes

```text
1 → 2 → null
```

### Odd Length

```text
1 → 2 → 3 → 4 → 5
```

### Even Length

```text
1 → 2 → 3 → 4
```

### No Cycle

```text
1 → 2 → 3 → null
```

### Cycle at Head

```text
1 → 2 → 3
↑       ↓
← ← ← ←
```

### Cycle in Middle

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

### Delete Head

Always test:

```text
head deletion
```

especially when using:

```java
slow.next = slow.next.next;
```

---

# 48. Problem-Solving Checklist

When you see a Linked List question:

```text
┌──────────────────────────────┐
│ 1. What does the question ask?│
└──────────────┬───────────────┘
               ↓
        Middle / Cycle /
        End / Compare /
        Reorder / Delete
               ↓
┌──────────────────────────────┐
│ 2. What positions do I need? │
└──────────────┬───────────────┘
               ↓
        Two useful pointers?
               ↓
┌──────────────────────────────┐
│ 3. What should each pointer  │
│    represent?                │
└──────────────┬───────────────┘
               ↓
        slow / fast / gap
               ↓
┌──────────────────────────────┐
│ 4. What is the safe movement?│
└──────────────┬───────────────┘
               ↓
        .next / .next.next
               ↓
┌──────────────────────────────┐
│ 5. What happens at null?     │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│ 6. Test small edge cases     │
└──────────────────────────────┘
```

---

# 49. Top Interview Questions

## Q1. What is a Linked List?

A linked list is a linear data structure consisting of nodes where each node stores data and a reference to another node.

---

## Q2. What is the difference between an Array and Linked List?

An array provides direct index-based access, usually in O(1), while a linked list requires traversal to reach a position, typically O(n).

---

## Q3. What is a node?

A node is an object containing the data and one or more references connecting it to other nodes.

---

## Q4. What is `head`?

`head` is a reference to the first node of the linked list.

---

## Q5. What does `current = current.next` mean?

It moves the `current` reference from the current node to the next node.

---

## Q6. Why does Slow/Fast find the middle?

Because fast moves twice as quickly as slow. When fast reaches the end, slow has traveled approximately half the distance.

---

## Q7. How does Floyd's algorithm detect a cycle?

Slow moves one step while fast moves two. If a cycle exists, fast eventually catches slow inside the cycle.

---

## Q8. Why use `slow == fast` instead of comparing values?

Because cycle detection depends on both references pointing to the same node object, not merely having equal values.

---

## Q9. What is the complexity of cycle detection?

```text
Time  → O(n)
Space → O(1)
```

---

## Q10. How do you find the cycle entrance?

First detect the meeting point. Then reset one pointer to `head` and move both pointers one step at a time. Their next meeting point is the cycle entrance.

---

## Q11. How do you find the Nth node from the end?

Maintain two pointers with a fixed gap of `n` or `n + 1`, depending on whether a dummy node is used. Then move both together until the leading pointer reaches the end.

---

## Q12. Why use a dummy node?

A dummy node creates a guaranteed node before `head`, which makes operations involving deletion of the first node much simpler.

---

## Q13. How can a linked list be checked for palindrome?

Find the middle, reverse the second half, then compare corresponding nodes from both halves.

---

## Q14. How can Reorder List be solved?

Find the middle, reverse the second half, then merge the two halves alternately.

---

## Q15. Can Slow/Fast Pointer be used without Linked Lists?

Yes.

It can be applied whenever states form a deterministic sequence, such as Happy Number or Find the Duplicate Number.

---

# 50. 30-Second Interview Answer

> "A linked list is a sequence of nodes where each node stores data and a reference to the next node. Since linked lists don't provide direct random access, many problems can be solved efficiently using pointer techniques. In the Slow and Fast Pointer pattern, slow usually moves one node at a time while fast moves two. This allows us to find the middle of a linked list because when fast reaches the end, slow is around the middle. The same movement can detect cycles because inside a cycle, the faster pointer eventually catches the slower one. Depending on the problem, we can also use fixed gaps, pointer switching, reversing, and merging to solve problems such as Nth Node From End, Palindrome, Reorder List, and Intersection."

---

# 51. Final Cheat Sheet

## Linked List Fundamentals

```text
Node
 ↓
data + reference

head
 ↓
first node

next
 ↓
next node

null
 ↓
end of list
```

---

## Traversal

```java
ListNode current = head;

while (current != null) {

    // use current

    current = current.next;
}
```

---

## Middle

```java
slow = slow.next;
fast = fast.next.next;
```

---

## Cycle

```java
if (slow == fast)
```

---

## Cycle Entrance

```text
meet
 ↓
slow = head
 ↓
move both one step
 ↓
meet again
 ↓
entrance
```

---

## Nth From End

```text
fixed gap
+
same-speed movement
```

---

## Palindrome

```text
middle
+
reverse
+
compare
```

---

## Reorder

```text
middle
+
reverse
+
merge
```

---

## Intersection

```text
A → switch to B
B → switch to A
```

---

## Complexity

```text
Most pointer problems
        ↓
O(n) time
O(1) extra space
```

---

# 52. Memory Map

The entire pattern can be compressed into this:

```text
                    LINKED LIST
                         │
                         ↓
                  nodes + references
                         │
                         ↓
                     head / next
                         │
                         ↓
                    TWO POINTERS
                         │
          ┌──────────────┼──────────────┐
          ↓              ↓              ↓
       slow/fast      fixed gap      switching
          │              │              │
          ↓              ↓              ↓
       Middle         Nth End      Intersection
          │
          ↓
       Cycle
          │
          ↓
    Floyd Detection
          │
          ↓
    Cycle Entrance
          │
          ↓
       Reverse
          │
      ┌───┴────┐
      ↓        ↓
 Palindrome  Reorder
               │
               ↓
             Merge
```

<table>
<tr>
<td><img src="https://api.iconify.design/lucide/flame.svg?color=%23f97316" width="24"></td>
<td>

<b>THE REAL THING TO REMEMBER</b>

Don't memorize 10 different Linked List solutions.

Learn these building blocks:

<br>

<b>1. Move a pointer</b><br> <code>current = current.next</code>

<b>2. Move two pointers at different speeds</b><br> <code>slow = slow.next</code><br> <code>fast = fast.next.next</code>

<b>3. Maintain a gap</b><br> <code>fast</code> stays ahead of <code>slow</code>

<b>4. Reverse links</b><br>
Change <code>next</code> references carefully.

<b>5. Merge structures</b><br>
Connect nodes in a controlled order.

<br>

Once these five ideas are clear, most of the "different" questions at the end are simply combinations of them.

</td>
</tr>
</table>

---

## One-Line Memory Trick

```text
LINKED LIST
→ Follow references.

MIDDLE
→ Fast moves 2×.

CYCLE
→ Fast catches slow.

CYCLE ENTRANCE
→ Meet → Reset → Meet.

NTH FROM END
→ Maintain a gap.

PALINDROME
→ Middle + Reverse + Compare.

REORDER
→ Middle + Reverse + Merge.

INTERSECTION
→ Switch heads.
```

---

<div align="center">

<img src="https://img.shields.io/badge/Pattern-UNDERSTAND%20THE%20POINTERS-00f5d4?style=for-the-badge&labelColor=060a1a">

<img src="https://img.shields.io/badge/Don't-Memorize%20Blindly-ff5ecb?style=for-the-badge&labelColor=060a1a">

<br><br>

<b>Understand what every pointer represents.</b>

<br>

<code>slow</code> and <code>fast</code> are not magic variables.<br>
They are simply references whose movement creates useful information.

</div>
