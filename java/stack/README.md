# Stack

This directory contains data structure implementatinos of stacks as well as programming questions for stacks.

Source: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1369/

### Thoughts

Linked Lists are not as fast as I expected for stack/queue. When rewritting min stack from custom array allocation to linked list, there didn't seem to be much perf gains. Linked List will have to do a memory allocation on each insertion it appears. Array Lists, on the other hand, do fewer memory allocations and have an amortized time complexity of O(1).

While I did use the Stack data structure in many of my solutions, it might be best to stick with ArrayLists or ArrayDeques for future Stack / Queue purposes.

Array implementations are also better for iteration and searching, as there are closer in memory (locality of reference).

So for these problems, the order of preference is: No Array > Fixed sized array > Array Implementations > LinkedList Implementations