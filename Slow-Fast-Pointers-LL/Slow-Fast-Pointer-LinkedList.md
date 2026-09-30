# Slow & Fast Pointer Pattern — Linked List

> **Pattern:** Slow & Fast Pointers / Tortoise & Hare
> **Primary Data Structure:** Linked List
> **Core Goal:** Find middle, detect cycles, find cycle entry, maintain distance, and solve linked-list problems in O(n) time and O(1) extra space.

---

# 📌 Table of Contents

1. [What Is a Linked List?](#1-what-is-a-linked-list)
2. [Why Linked Lists Need Special Pointer Techniques](#2-why-linked-lists-need-special-pointer-techniques)
3. [What Is the Slow & Fast Pointer Pattern?](#3-what-is-the-slow--fast-pointer-pattern)
4. [Core Mental Model](#4-core-mental-model)
5. [The Fundamental Slow/Fast Structure](#5-the-fundamental-slowfast-structure)
6. [How Slow and Fast Actually Move](#6-how-slow-and-fast-actually-move)
7. [Why Does Fast Catch Slow in a Cycle?](#7-why-does-fast-catch-slow-in-a-cycle)
8. [When to Think of Slow/Fast Pointers](#8-when-to-think-of-slowfast-pointers)
9. [When NOT to Think of Slow/Fast Pointers](#9-when-not-to-think-of-slowfast-pointers)
10. [The Main Slow/Fast Patterns](#10-the-main-slowfast-patterns)
11. [Pattern 1 — Find the Middle](#11-pattern-1--find-the-middle)
12. [Pattern 2 — Detect a Cycle](#12-pattern-2--detect-a-cycle)
13. [Pattern 3 — Find the Start of a Cycle](#13-pattern-3--find-the-start-of-a-cycle)
14. [Pattern 4 — Maintain a Fixed Gap](#14-pattern-4--maintain-a-fixed-gap)
15. [Pattern 5 — Middle + Reverse](#15-pattern-5--middle--reverse)
16. [Pattern 6 — Middle + Reverse + Merge](#16-pattern-6--middle--reverse--merge)
17. [Pattern 7 — Two Pointers for Intersection](#17-pattern-7--two-pointers-for-intersection)
18. [Pattern 8 — Cycle Detection in a General State Sequence](#18-pattern-8--cycle-detection-in-a-general-state-sequence)
19. [How to Decide Pointer Initialization](#19-how-to-decide-pointer-initialization)
20. [How to Decide Pointer Movement](#20-how-to-decide-pointer-movement)
21. [How to Decide the Loop Condition](#21-how-to-decide-the-loop-condition)
22. [How to Know What Slow Means](#22-how-to-know-what-slow-means)
23. [How to Approach a Linked List Problem](#23-how-to-approach-a-linked-list-problem)
24. [Canonical Java Templates](#24-canonical-java-templates)
25. [Important Slow/Fast Problems](#25-important-slowfast-problems)
26. [Solved Example — Middle of the Linked List](#26-solved-example--middle-of-the-linked-list)
27. [Solved Example — Linked List Cycle](#27-solved-example--linked-list-cycle)
28. [Solved Example — Linked List Cycle II](#28-solved-example--linked-list-cycle-ii)
29. [Solved Example — Remove Nth Node From End](#29-solved-example--remove-nth-node-from-end)
30. [Solved Example — Palindrome Linked List](#30-solved-example--palindrome-linked-list)
31. [Solved Example — Reorder List](#31-solved-example--reorder-list)
32. [Solved Example — Intersection of Two Linked Lists](#32-solved-example--intersection-of-two-linked-lists)
33. [Solved Example — Happy Number](#33-solved-example--happy-number)
34. [Solved Example — Find the Duplicate Number](#34-solved-example--find-the-duplicate-number)
35. [Solved Example — Circular Array Loop](#35-solved-example--circular-array-loop)
36. [How the Problems Are Connected](#36-how-the-problems-are-connected)
37. [Common Mistakes](#37-common-mistakes)
38. [Brute Force vs Slow/Fast](#38-brute-force-vs-slowfast)
39. [Time and Space Complexity](#39-time-and-space-complexity)
40. [Advantages](#40-advantages)
41. [Disadvantages](#41-disadvantages)
42. [Edge Cases Checklist](#42-edge-cases-checklist)
43. [Slow/Fast Problem-Solving Checklist](#43-slowfast-problem-solving-checklist)
44. [Interview Questions](#44-interview-questions)
45. [Interview 30-Second Answer](#45-interview-30-second-answer)
46. [Final Cheat Sheet](#46-final-cheat-sheet)
47. [Memory Map](#47-memory-map)

---

# 1. What Is a Linked List?

A **Linked List** is a linear data structure made of nodes.

Each node normally contains:

```text
data
next
```

For a singly linked list:

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

Example:

```text
10 → 20 → 30 → 40 → null
```

Each node stores the address/reference of the next node.

---

## Linked List vs Array

| Property                       | Array                            | Linked List            |
| ------------------------------ | -------------------------------- | ---------------------- |
| Memory                         | Usually contiguous               | Nodes can be scattered |
| Random access                  | O(1)                             | O(n)                   |
| Access element by index        | Easy                             | Requires traversal     |
| Insert/delete after known node | Costly due to shifting in arrays | O(1)                   |
| Traversal                      | Index based                      | Pointer based          |

The important difference for this pattern is:

> **A linked list naturally gives us a `next` pointer, so pointer movement becomes extremely powerful.**

---

# 2. Why Linked Lists Need Special Pointer Techniques

Consider:

```text
1 → 2 → 3 → 4 → 5 → null
```

With an array, we can easily do:

```text
arr[0]
arr[n/2]
arr[n-1]
```

But in a linked list:

```text
head
 ↓
1 → 2 → 3 → 4 → 5
```

We don't have direct access to the middle.

We have to follow:

```text
1 → 2 → 3
```

So instead of calculating the length and traversing again, we can use:

```text
slow
fast
```

This is where the pattern becomes useful.

---

# 3. What Is the Slow & Fast Pointer Pattern?

The **Slow & Fast Pointer Pattern** uses two pointers that move through a linked list at different speeds.

Usually:

```text
slow → 1 step
fast → 2 steps
```

Example:

```text
1 → 2 → 3 → 4 → 5
```

Start:

```text
slow = 1
fast = 1
```

Then:

```text
slow = slow.next
fast = fast.next.next
```

The difference in speed creates useful information.

---

# 4. Core Mental Model

Don't memorize:

```java
slow = slow.next;
fast = fast.next.next;
```

as random code.

Understand this:

> **Fast travels twice as quickly as slow.**

Therefore:

```text
Fast reaches the end
        ↓
Slow is around the middle
```

And:

```text
Fast enters a cycle
        ↓
Fast keeps gaining on slow
        ↓
Fast eventually catches slow
```

This gives us two of the biggest applications:

```text
MIDDLE
CYCLE
```

---

# 5. The Fundamental Slow/Fast Structure

The most common template is:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}
```

Think:

```text
slow → +1
fast → +2
```

The condition:

```java
fast != null && fast.next != null
```

is important because `fast` moves two nodes at a time.

We need to make sure both are available.

---

# 6. How Slow and Fast Actually Move

Consider:

```text
1 → 2 → 3 → 4 → 5 → 6 → null
```

Initially:

```text
S
F
↓
1 → 2 → 3 → 4 → 5 → 6
```

After one iteration:

```text
1 → 2 → 3 → 4 → 5 → 6
     S       F
```

After another:

```text
1 → 2 → 3 → 4 → 5 → 6
          S           F
```

Fast reaches the end much earlier.

Slow is around the middle.

### Mental formula

If:

```text
slow speed = 1
fast speed = 2
```

then:

```text
fast distance ≈ 2 × slow distance
```

That's why slow ends up around half the list.

---

# 7. Why Does Fast Catch Slow in a Cycle?

Suppose:

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

Both pointers eventually enter the cycle.

Inside the cycle:

```text
slow → 1 step
fast → 2 steps
```

So every iteration:

```text
fast gains 1 position
```

on slow.

Because the cycle is finite:

```text
fast
 ↓
slow
```

must eventually meet.

Therefore:

```java
if (slow == fast)
```

means a cycle exists.

---

# 8. When to Think of Slow/Fast Pointers

Think about this pattern when the problem contains words like:

### Middle

```text
middle
middle node
split into two halves
```

Think:

```text
slow + fast
```

---

### Cycle

```text
cycle
loop
circular
repeated state
```

Think:

```text
Floyd's Cycle Detection
```

---

### Nth From End

```text
nth node from end
kth node from end
remove nth node from end
```

Think:

```text
two pointers + fixed gap
```

---

### Palindrome

```text
linked list palindrome
```

Think:

```text
middle
+
reverse second half
+
compare
```

---

### Reorder

```text
1 → 2 → 3 → 4 → 5

1 → 5 → 2 → 4 → 3
```

Think:

```text
middle
+
reverse
+
merge
```

---

# 9. When NOT to Think of Slow/Fast Pointers

Don't force this pattern.

### ❌ If the problem is simply:

```text
Find maximum value
Find minimum value
Count nodes
Search for a value
```

A normal traversal may be enough.

### ❌ If direct array indexing is central

You may need:

```text
Binary Search
Two Pointers
Sliding Window
Prefix Sum
```

instead.

### ❌ If a HashSet is explicitly allowed and gives a simpler solution

For cycle detection:

```java
Set<ListNode> set = new HashSet<>();
```

can work.

But Floyd is preferable when:

```text
O(1) extra space
```

is required.

---

# 10. The Main Slow/Fast Patterns

There isn't only one form of this pattern.

The major variations are:

```text
1. Find Middle
2. Detect Cycle
3. Find Cycle Entrance
4. Maintain Fixed Gap
5. Middle + Reverse
6. Middle + Reverse + Merge
7. Two-Pointer Intersection
8. Cycle Detection on General States
```

Understanding these variations is more important than memorizing individual problems.

---

# 11. Pattern 1 — Find the Middle

### Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

### Why?

Fast moves twice as fast.

When fast reaches the end:

```text
slow ≈ middle
```

### Example

```text
1 → 2 → 3 → 4 → 5
```

Result:

```text
3
```

For:

```text
1 → 2 → 3 → 4
```

this version returns:

```text
3
```

So always understand whether the problem needs the first or second middle.

---

# 12. Pattern 2 — Detect a Cycle

This is **Floyd's Cycle Detection Algorithm**.

### Template

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

### Mental model

```text
No cycle:

slow → → → → null
fast → → → → null
```

Therefore:

```text
fast becomes null
```

Cycle:

```text
slow ↘
      cycle
fast ↗
```

Eventually:

```text
slow == fast
```

---

# 13. Pattern 3 — Find the Start of a Cycle

This is a two-phase algorithm.

### Phase 1

Find a meeting point:

```text
slow == fast
```

### Phase 2

Reset one pointer:

```java
slow = head;
```

Then:

```java
slow = slow.next;
fast = fast.next;
```

until:

```text
slow == fast
```

That node is the cycle entrance.

---

## Why Reset Works

Suppose:

```text
a = distance from head to cycle entrance
b = distance from entrance to meeting point
c = remaining cycle distance
```

At the meeting:

```text
slow = a + b
```

Fast has traveled twice as far:

```text
fast = 2(a + b)
```

The difference is a multiple of the cycle length.

This leads to the important relationship:

```text
distance(head → entrance)
=
distance(meeting → entrance) modulo cycle length
```

Therefore:

```text
head → entrance
```

and:

```text
meeting → entrance
```

take the same number of steps when traversed appropriately.

So:

```text
slow = head
```

and moving both one step makes them meet at the entrance.

---

# 14. Pattern 4 — Maintain a Fixed Gap

This is useful when the problem asks:

```text
Nth node from the end
```

Example:

```text
1 → 2 → 3 → 4 → 5
```

Find:

```text
2nd node from end
```

Answer:

```text
4
```

Instead of calculating length:

```text
n = 5
```

then:

```text
n - 2
```

we maintain a gap.

```text
fast
 ↓
1 → 2 → 3 → 4 → 5
slow
```

Move `fast` ahead by `n`.

Then move both together.

When fast reaches the end:

```text
slow = target
```

For deletion, we usually want:

```text
slow = node BEFORE target
```

which is why a dummy node is useful.

---

# 15. Pattern 5 — Middle + Reverse

This combination is extremely important.

Used in:

```text
Palindrome Linked List
```

Process:

```text
Find middle
      ↓
Reverse second half
      ↓
Compare halves
```

Example:

```text
1 → 2 → 2 → 1
```

Find middle:

```text
1 → 2 | 2 → 1
```

Reverse second half:

```text
1 → 2 | 1 → 2
```

Compare:

```text
1 == 1
2 == 2
```

Therefore:

```text
Palindrome
```

---

# 16. Pattern 6 — Middle + Reverse + Merge

Used in:

```text
Reorder List
```

Example:

```text
1 → 2 → 3 → 4 → 5
```

### Step 1 — Find middle

```text
1 → 2 → 3 | 4 → 5
```

### Step 2 — Reverse second half

```text
1 → 2 → 3
5 → 4
```

### Step 3 — Merge alternately

```text
1 → 5 → 2 → 4 → 3
```

So don't memorize Reorder List as one giant solution.

Remember:

```text
Middle
↓
Reverse
↓
Merge
```

---

# 17. Pattern 7 — Two Pointers for Intersection

Two linked lists may eventually share the same nodes:

```text
A: 1 → 2 → 3
             ↘
               8 → 9
             ↗
B:     4 → 5
```

The important thing is:

```text
same node/reference
```

not:

```text
same value
```

Elegant solution:

```java
ListNode a = headA;
ListNode b = headB;

while (a != b) {

    a = (a == null) ? headB : a.next;
    b = (b == null) ? headA : b.next;
}

return a;
```

The idea:

```text
A pointer travels A + B
B pointer travels B + A
```

Therefore both cover the same total distance.

---

# 18. Pattern 8 — Cycle Detection in a General State Sequence

This is a powerful extension.

The structure doesn't necessarily need to literally be a linked list.

Suppose:

```text
state → next state
```

For example:

```text
19 → 82 → 68 → 100 → 1
```

or:

```text
index → nums[index]
```

If the process eventually repeats a state, we can use cycle detection.

This gives us:

```text
Happy Number
Find the Duplicate Number
Circular Array Loop
```

The mental model becomes:

> **A deterministic sequence of states can behave like a linked list.**

---

# 19. How to Decide Pointer Initialization

There are several common choices.

### Case 1 — Middle / Cycle

Usually:

```java
slow = head;
fast = head;
```

### Case 2 — Nth From End

Often:

```java
slow = dummy;
fast = dummy;
```

Then create a gap.

### Case 3 — Intersection

```java
a = headA;
b = headB;
```

Then switch heads when a pointer reaches null.

---

# 20. How to Decide Pointer Movement

Ask:

### Do I need the middle?

Use:

```java
slow = slow.next;
fast = fast.next.next;
```

### Do I need cycle detection?

Same movement:

```java
slow = slow.next;
fast = fast.next.next;
```

### Do I need Nth from end?

Use:

```text
same speed
+
fixed distance
```

### Do I need intersection?

Use:

```text
same speed
+
switch heads
```

---

# 21. How to Decide the Loop Condition

For normal slow/fast traversal:

```java
while (fast != null && fast.next != null)
```

Why both?

Because we want to safely execute:

```java
fast.next.next
```

If:

```text
fast == null
```

we cannot access:

```text
fast.next
```

If:

```text
fast.next == null
```

we cannot move two steps.

---

# 22. How to Know What Slow Means

This is the most important habit.

Never ask:

> "What code do I memorize?"

Ask:

> **"What does slow represent right now?"**

Examples:

### Middle

```text
slow = middle
```

### Cycle detection

```text
slow and fast = positions inside traversal
```

### Cycle entrance

After reset:

```text
slow = distance from head
fast = distance from meeting point
```

### Remove Nth

```text
slow = node before target
```

### Palindrome

```text
slow = beginning of second half
```

Understanding the meaning makes the code much easier to reproduce.

---

# 23. How to Approach a Linked List Problem

Use this sequence in an interview.

### Step 1 — Understand the structure

Ask:

```text
Singly?
Doubly?
Cycle?
Sorted?
```

### Step 2 — Identify what the problem wants

```text
Middle?
End?
Cycle?
Intersection?
Reversal?
Comparison?
```

### Step 3 — Check whether pointers can solve it

Ask:

```text
Can I maintain two useful positions?
```

### Step 4 — Choose the pattern

```text
Middle → slow/fast
Cycle → Floyd
Nth from end → fixed gap
Palindrome → middle + reverse
Reorder → middle + reverse + merge
Intersection → pointer switching
```

### Step 5 — Handle edge cases

Check:

```text
null
one node
two nodes
even length
odd length
cycle
head deletion
```

---

# 24. Canonical Java Templates

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

# 25. Important Slow/Fast Problems

These are the problems I would keep in your pattern revision list:

| #  | Problem                          |  LC | Main Idea                |
| -- | -------------------------------- | --: | ------------------------ |
| 1  | Middle of the Linked List        | 876 | Slow/Fast                |
| 2  | Linked List Cycle                | 141 | Floyd                    |
| 3  | Linked List Cycle II             | 142 | Cycle Entry              |
| 4  | Remove Nth Node From End         |  19 | Fixed Gap                |
| 5  | Palindrome Linked List           | 234 | Middle + Reverse         |
| 6  | Reorder List                     | 143 | Middle + Reverse + Merge |
| 7  | Intersection of Two Linked Lists | 160 | Two Pointers             |
| 8  | Happy Number                     | 202 | Cycle Detection          |
| 9  | Find the Duplicate Number        | 287 | Floyd                    |
| 10 | Circular Array Loop              | 457 | Cycle Detection          |

### Priority

If you're learning this pattern for interviews, make sure these are rock solid:

```text
LC 876
LC 141
LC 142
LC 19
LC 234
LC 143
LC 160
LC 287
```

---

# 26. Solved Example — Middle of the Linked List

## Problem

Given:

```text
1 → 2 → 3 → 4 → 5
```

return:

```text
3
```

## Brute Force

First calculate length:

```text
n = 5
```

Then traverse:

```text
n / 2
```

This requires extra reasoning and potentially two traversals.

## Better Approach

Use:

```text
slow = 1 step
fast = 2 steps
```

### Dry Run

```text
Start:

S
F
↓
1 → 2 → 3 → 4 → 5
```

After 1:

```text
1 → S(2) → 3 → F(4) → 5
```

After 2:

```text
1 → 2 → S(3) → 4 → F(5)
```

Fast finishes.

Therefore:

```text
slow = 3
```

---

# 27. Solved Example — Linked List Cycle

## Problem

Determine whether a linked list contains a cycle.

Example:

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

## Approach

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

## Dry Run

Inside the cycle:

```text
slow moves +1
fast moves +2
```

Fast continuously gains on slow.

Eventually:

```text
slow == fast
```

Therefore:

```text
cycle exists
```

---

# 28. Solved Example — Linked List Cycle II

## Problem

Return the node where the cycle starts.

Example:

```text
1 → 2 → 3 → 4 → 5
        ↑         ↓
        ← ← ← ← ←
```

Cycle starts at:

```text
3
```

## Approach

### Phase 1

Detect meeting point.

### Phase 2

Reset:

```java
slow = head;
```

Move both one step.

### Key Memory

```text
Meeting point ≠ cycle entrance
```

The first meeting only proves:

```text
cycle exists
```

Then the reset phase finds:

```text
cycle entrance
```

---

# 29. Solved Example — Remove Nth Node From End

## Example

```text
1 → 2 → 3 → 4 → 5
```

Remove:

```text
2nd from end
```

Result:

```text
1 → 2 → 3 → 5
```

### Why fixed gap works

Create a gap of 2 nodes.

When fast reaches the end:

```text
slow
 ↓
3 → 4 → 5
```

For deletion, we position slow at:

```text
3
```

so:

```java
slow.next = slow.next.next;
```

removes:

```text
4
```

The exact initial gap depends on whether you use a dummy node and whether you want the target or its previous node.

---

# 30. Solved Example — Palindrome Linked List

Example:

```text
1 → 2 → 2 → 1
```

### Step 1

Find middle.

```text
1 → 2 | 2 → 1
```

### Step 2

Reverse second half.

```text
1 → 2 | 1 → 2
```

### Step 3

Compare.

```text
1 == 1
2 == 2
```

Return:

```text
true
```

### Pattern

```text
Slow/Fast
    ↓
Middle
    ↓
Reverse
    ↓
Compare
```

---

# 31. Solved Example — Reorder List

Input:

```text
1 → 2 → 3 → 4 → 5
```

Expected:

```text
1 → 5 → 2 → 4 → 3
```

### Step 1

Find middle:

```text
1 → 2 → 3 | 4 → 5
```

### Step 2

Reverse:

```text
1 → 2 → 3
5 → 4
```

### Step 3

Merge:

```text
1
↓
1 → 5
     ↓
1 → 5 → 2
          ↓
1 → 5 → 2 → 4
               ↓
1 → 5 → 2 → 4 → 3
```

### Memory

```text
Middle
Reverse
Merge
```

---

# 32. Solved Example — Intersection of Two Linked Lists

Suppose:

```text
A: 1 → 2 → 3
             ↘
               8 → 9
             ↗
B:     4 → 5
```

The intersection is node:

```text
8
```

Use:

```java
ListNode a = headA;
ListNode b = headB;

while (a != b) {

    a = (a == null) ? headB : a.next;
    b = (b == null) ? headA : b.next;
}

return a;
```

### Key idea

```text
A + B
B + A
```

Both pointers traverse equal total distances.

---

# 33. Solved Example — Happy Number

Example:

```text
19
```

Generate next state:

```text
19
↓
1² + 9² = 82
↓
68
↓
100
↓
1
```

The state eventually reaches:

```text
1
```

For an unhappy number, the sequence enters a cycle.

So we can use:

```text
slow → one generated state
fast → two generated states
```

This is the same idea as linked-list cycle detection.

### Big Lesson

> **Cycle detection is not limited to `ListNode`.**

It works whenever:

```text
state → next state
```

is deterministic.

---

# 34. Solved Example — Find the Duplicate Number

Input:

```text
[1, 3, 4, 2, 2]
```

Think of:

```text
index → nums[index]
```

as a pointer.

For example:

```text
0 → 1
1 → 3
3 → 2
2 → 4
4 → 2
```

We eventually repeat:

```text
2
```

That repetition forms a cycle.

Use Floyd:

```java
int slow = nums[0];
int fast = nums[0];

do {
    slow = nums[slow];
    fast = nums[nums[fast]];
} while (slow != fast);

slow = nums[0];

while (slow != fast) {
    slow = nums[slow];
    fast = nums[fast];
}

return slow;
```

### Important

This is one of the best examples of **thinking in patterns instead of data structures**.

The input is an array.

But the underlying structure behaves like a linked list.

---

# 35. Solved Example — Circular Array Loop

In this problem, every index points to another index.

Therefore:

```text
index → next index
```

creates a sequence.

Use:

```text
slow = next(slow)
fast = next(next(fast))
```

The same Floyd idea can detect cycles.

But unlike a simple linked-list cycle, you must carefully validate:

```text
same direction
valid movement
cycle length > 1
```

This is an advanced application of the pattern.

---

# 36. How the Problems Are Connected

This is the most important section for revision.

Don't memorize:

```text
LC 876
LC 141
LC 142
LC 234
...
```

as unrelated questions.

They are connected.

### Middle

```text
slow + fast
```

↓

### Cycle

```text
slow + fast
```

↓

### Cycle Entrance

```text
slow + fast
+
reset
```

↓

### Palindrome

```text
middle
+
reverse
```

↓

### Reorder

```text
middle
+
reverse
+
merge
```

↓

### Nth From End

```text
two pointers
+
fixed gap
```

↓

### Duplicate Number

```text
cycle detection
+
state mapping
```

Once you understand the base pattern, many questions become variations.

---

# 37. Common Mistakes

## Mistake 1 — Wrong loop condition

Dangerous:

```java
while (fast != null) {
    fast = fast.next.next;
}
```

Correct:

```java
while (fast != null && fast.next != null)
```

---

## Mistake 2 — Comparing values

Wrong:

```java
if (slow.val == fast.val)
```

Correct for cycle detection:

```java
if (slow == fast)
```

---

## Mistake 3 — Thinking the first meeting is the cycle entrance

It isn't.

First meeting:

```text
cycle exists
```

Reset + move together:

```text
cycle entrance
```

---

## Mistake 4 — Forgetting even-length behavior

For:

```text
1 → 2 → 3 → 4
```

you must know whether your algorithm needs:

```text
2
```

or:

```text
3
```

as the middle.

---

## Mistake 5 — Not using a dummy node

For:

```text
Remove Nth Node From End
```

a dummy node makes head deletion much easier.

---

## Mistake 6 — Reversing the wrong part

For palindrome/reorder problems, carefully identify:

```text
where the second half starts
```

before reversing.

---

## Mistake 7 — Losing the remaining list

When modifying links, save references when necessary.

Example:

```java
ListNode next = current.next;
```

before changing:

```java
current.next = previous;
```

---

# 38. Brute Force vs Slow/Fast

## Cycle Detection

### Brute Force

Use:

```java
HashSet<ListNode>
```

Store every visited node.

Complexity:

```text
Time  → O(n)
Space → O(n)
```

### Floyd

```text
Time  → O(n)
Space → O(1)
```

Therefore Floyd is useful when constant extra space is required.

---

## Finding Middle

### Brute Force

```text
count nodes
→ traverse again
```

### Slow/Fast

```text
one traversal
```

---

# 39. Time and Space Complexity

Most slow/fast solutions:

```text
Time  → O(n)
Space → O(1)
```

Why O(n)?

Each pointer traverses at most a constant number of times.

Why O(1)?

We only maintain:

```text
slow
fast
```

and a few temporary references.

No array or HashSet is required.

---

# 40. Advantages

### 1. Constant extra space

```text
O(1)
```

### 2. Often one-pass

Many problems can be solved without calculating length separately.

### 3. Very powerful

One basic movement rule solves multiple problems.

### 4. Interview favorite

Commonly tested in:

```text
Linked Lists
Cycle Detection
Pointers
Memory Optimization
```

### 5. Generalizable

The same cycle idea works for:

```text
Linked List
Happy Number
Duplicate Number
Circular Array
```

---

# 41. Disadvantages

### 1. Pointer logic can be tricky

Especially:

```text
cycle entrance
reversal
reorder
```

### 2. Easy to make null-pointer mistakes

Because:

```java
fast.next.next
```

requires careful checking.

### 3. Even-length lists need attention

Different definitions of "middle" can change the implementation.

### 4. Modification problems are harder

Problems like:

```text
Palindrome
Reorder
```

combine multiple linked-list operations.

---

# 42. Edge Cases Checklist

Before submitting a linked-list solution, test:

### Empty

```text
null
```

### One node

```text
1 → null
```

### Two nodes

```text
1 → 2
```

### Odd length

```text
1 → 2 → 3 → 4 → 5
```

### Even length

```text
1 → 2 → 3 → 4
```

### No cycle

```text
1 → 2 → 3 → null
```

### Cycle at head

```text
1 → 2 → 3
↑       ↓
← ← ← ←
```

### Cycle in middle

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

### Delete head

Important for:

```text
Remove Nth Node
```

---

# 43. Slow/Fast Problem-Solving Checklist

When you see a linked-list problem:

```text
1. What is the problem asking?
        ↓
2. Middle?
   Cycle?
   End?
   Comparison?
        ↓
3. Can two pointers help?
        ↓
4. Do I need different speeds?
        ↓
5. Do I need a fixed gap?
        ↓
6. What does slow represent?
        ↓
7. What does fast represent?
        ↓
8. What is the safe loop condition?
        ↓
9. What happens for null?
        ↓
10. Test odd/even/small cases
```

---

# 44. Interview Questions

## Q1. What is the slow and fast pointer technique?

It uses two pointers moving at different speeds through a linked list. Usually slow moves one step and fast moves two steps.

---

## Q2. Why can it find the middle?

Because fast moves twice as quickly as slow. When fast reaches the end, slow has traveled approximately half the distance.

---

## Q3. What is Floyd's Cycle Detection Algorithm?

It uses a slow pointer moving one step and a fast pointer moving two steps. If they meet, the sequence contains a cycle.

---

## Q4. Why will fast catch slow?

Inside a finite cycle, fast gains one position on slow every iteration.

---

## Q5. Why do we use `slow == fast`?

Because we need to know whether both references point to the same node.

Two different nodes may contain:

```text
val = 5
```

so comparing values is not enough.

---

## Q6. What is the complexity?

```text
Time  → O(n)
Space → O(1)
```

for the standard Floyd-based solutions.

---

## Q7. How do you find the cycle entrance?

First find a meeting point. Then reset one pointer to `head` and move both one step until they meet again.

---

## Q8. Can slow/fast work on arrays?

Yes, if the array can be interpreted as a deterministic state transition.

Examples:

```text
Find Duplicate Number
Circular Array Loop
```

---

## Q9. Why is a dummy node useful?

It creates a node before `head`, making deletion logic uniform, especially when the head itself needs to be removed.

---

## Q10. What problems combine multiple linked-list patterns?

Examples:

```text
Palindrome:
Middle + Reverse + Compare

Reorder:
Middle + Reverse + Merge
```

---

## Q11. Is slow/fast always better than HashSet?

Not always.

A HashSet may be simpler, but it uses:

```text
O(n)
```

extra space.

Floyd uses:

```text
O(1)
```

extra space.

---

## Q12. What is the main thing to remember?

Don't memorize the code.

Understand:

```text
what slow represents
what fast represents
why they move at those speeds
what their meeting means
```

---

# 45. Interview 30-Second Answer

> The slow and fast pointer pattern uses two pointers that traverse a linked list at different speeds. Usually, slow moves one node and fast moves two nodes. This allows us to find the middle because when fast reaches the end, slow is around the middle. The same technique can detect a cycle because if a cycle exists, fast eventually catches slow. Floyd's algorithm can then find the cycle's starting node by resetting one pointer to the head and moving both pointers one step at a time. The technique is powerful because many problems can be solved in O(n) time and O(1) extra space.

---

# 46. Final Cheat Sheet

```text
┌─────────────────────────────────────────┐
│      SLOW & FAST POINTER PATTERN        │
└─────────────────────────────────────────┘

slow → 1 step
fast → 2 steps

             │
      ┌──────┼──────┐
      ↓      ↓      ↓
   Middle   Cycle   Gap
      │      │       │
      ↓      ↓       ↓
    slow   meeting  Nth from
   = mid   point     end
             │
             ↓
       reset + move
        both 1 step
             │
             ↓
       cycle entrance
```

### Main Combinations

```text
Middle
  ↓
Reverse
  ↓
Compare
  =
Palindrome
```

```text
Middle
  ↓
Reverse
  ↓
Merge
  =
Reorder List
```

### Core Templates

```java
// Middle / Cycle
slow = slow.next;
fast = fast.next.next;
```

```java
// Cycle
if (slow == fast)
```

```java
// Cycle entrance
slow = head;
```

```java
// Fixed gap
fast = fast.next;
```

```java
// Intersection
a = (a == null) ? headB : a.next;
b = (b == null) ? headA : b.next;
```

---

# 47. Memory Map

The entire pattern can be remembered as:

```text
                    SLOW + FAST
                         │
          ┌──────────────┼──────────────┐
          ↓              ↓              ↓
       MIDDLE          CYCLE          GAP
          │              │              │
          │              │              └── Nth From End
          │              │
          │              ├── Detect Cycle
          │              │
          │              └── Find Entrance
          │
          ├── Palindrome
          │      │
          │      └── Reverse + Compare
          │
          └── Reorder
                 │
                 └── Reverse + Merge
```

## 🔥 The Ultimate Pattern Recognition

When you see:

```text
"middle"
```

think:

```text
slow + fast
```

When you see:

```text
"cycle"
```

think:

```text
Floyd
```

When you see:

```text
"cycle starts where?"
```

think:

```text
meeting → reset → move together
```

When you see:

```text
"nth from end"
```

think:

```text
fixed gap
```

When you see:

```text
"palindrome linked list"
```

think:

```text
middle → reverse → compare
```

When you see:

```text
"reorder linked list"
```

think:

```text
middle → reverse → merge
```

When you see:

```text
"duplicate number / repeated state"
```

think:

```text
state → next state → cycle detection
```

> **Don't memorize 10 different solutions. Learn the pointer relationship, understand what each pointer represents, and the code becomes a consequence of the pattern.**
