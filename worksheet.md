# A3 Worksheet: Design Document for the Linked List

**Name:Zoie Zeng**
**Onyen:zoiezeng**

Six sections, 15 points. Fill this in **before** you write any code. It is a design document, so it says what your methods must do and what must stay true, not how you will write them. Everything you need is in `README.md`. Keep it short: the whole document should fit on about one page. Write your answers directly under each prompt.

---

## 1. The problem in your own words (2 points)

In two or three sentences, describe the problem this assignment asks you to solve. Say what the six new methods let a program do with a list of whole numbers, and whether they build new lists or change the ones they are given.

We're adding methods to LinkedList so it'll be more flexible and versatile. We're using linkedLink because it's faster insertion and
deletion since arrays you have to shift everything if you want to insert an element, etc. In this assignment we're suppose to code
simpleMerge, removeAtIndex, isEqual, removeRepeats, reverse, and merge. SimpleMerge will take a list and the current list will be supplemented

List of Whole Integers = [1,2,3,4,5,6,7]
at the end of the list given. So they just change the ones we're given and makes the other list null.
RemoveAtIndex will remove the object/reference at the index given. This will just change
the ones they're given.
```

```

---

## 2. Operations (3 points)

For each method you will write, describe in a few words what it is responsible for. Then say which of the list's **first node**, **last node**, and **size** the method can change, and in what situation. If it can change none of them, write "none". For the two merge methods, also say what state `list2` is left in.

| Method | What it is responsible for | Which of first node / last node / size it can change, and when |
|---|---|---|
| `simpleMerge` |  |  |
| `removeAtIndex` |  |  |
| `isEqual` |  |  |
| `removeRepeats` |  |  |
| `reverse` |  |  |
| `merge` |  |  |

---

## 3. Data structure and justification (2 points)

This assignment uses a singly linked list that keeps a reference to both its first node and its last node. In one sentence, justify a linked list over an array-backed list (like the dynamic array from L11) for the work in Tasks 1 and 6. In a second sentence, explain what keeping a reference to the **last** node gives the class, and name one method, either provided or one of yours, that would have to do more work without it.

```

```

---

## 4. Class invariant (3 points)

State the invariant the `LinkedList` class must maintain: what is always true about `_head`, `_tail`, and `_size` whenever no method is in the middle of running. Your answer should cover an empty list and a non-empty list, and it should say how `_size` relates to the nodes actually in the list.

```

```

---

## 5. Three edge cases (3 points)

List three edge cases where a first attempt at one of your methods is likely to go wrong. Use at least two different methods, and don't reuse the main examples from the README. For each one, give the exact input (the list, plus `list2` or the index where one applies) and the correct result, including anything that must change about the first node, the last node, or the size.

| Method | Input | Correct result |
|---|---|---|
|  |  |  |
|  |  |  |
|  |  |  |

---

## 6. Test strategy (2 points)

In two or three sentences, describe how you will check each method before you submit to the autograder. Say what you will look at after each call besides the printed contents of the list, and where your edge cases from section 5 come in.

```

```

---

## Submitting

Turn this in with your answers as a `.md` file on Gradescope. The code goes to Gradescope separately; see `README.md`.
