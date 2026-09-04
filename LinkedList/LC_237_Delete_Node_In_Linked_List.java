/*
Approach:
1. We are given the node to delete, but we don't have access to its
   previous node, so we cannot directly remove this node.

2. Copy the value of the next node into the current node:
   node.val = node.next.val;
   - This makes the current node contain the value of the next node.

3. Skip the next node:
   node.next = node.next.next;
   - This removes the original next node from the linked list.

Key Idea:
Instead of deleting the given node directly, copy the next node's
value into it and then delete the next node by changing the link.

Example:
4 → 5 → 1 → 9
      ↓
4 → 1 → 9

Time Complexity: O(1)
Space Complexity: O(1)
*/


class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
