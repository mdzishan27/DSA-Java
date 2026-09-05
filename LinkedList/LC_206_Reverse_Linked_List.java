/*
Brute Force Approach:

1. Traverse the linked list and store every node in an ArrayList.
   - This allows us to access the nodes in reverse order easily.

2. Traverse the ArrayList from the last node to the first node.
   - For each node, connect it to the previous node:
       t1.next = t2;
   - This reverses the direction of the links.

3. The original head becomes the last node after reversal.
   - Set its next pointer to null to avoid creating a cycle.

4. Return the last node of the ArrayList as the new head.

Key Idea:
Store all nodes in an ArrayList so that we can access them from
right to left and reverse their next pointers.

Example:
Original:  1 → 2 → 3 → 4 → null

ArrayList:
[1, 2, 3, 4]

Reverse links:
4 → 3 → 2 → 1 → null

New Head = 4

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return head;

        ListNode temp = head;
        ArrayList<ListNode> arr = new ArrayList<>();

        // Store all nodes in ArrayList
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }

        int n = arr.size();

        // Reverse the links from last node to first
        for(int i = n - 1; i >= 1; i--){
            ListNode t1 = arr.get(i);
            ListNode t2 = arr.get(i - 1);

            t1.next = t2;
        }

        // Original head becomes the last node
        arr.get(0).next = null;

        // Last node becomes the new head
        return arr.get(n - 1);
    }
}


/*
Approach 2:

1. Use three pointers to reverse the linked list:
   - curr → points to the current node.
   - prev → points to the previous node.
   - fwd  → stores the next node so we don't lose the remaining list.

2. For every node:
   - First store the next node:
       fwd = curr.next;
     This is important because we are about to change curr.next.

   - Reverse the current link:
       curr.next = prev;
     Now the current node points backward.

   - Move prev forward:
       prev = curr;

   - Move curr forward:
       curr = fwd;

3. Continue until curr becomes null.
   - At this point, prev is pointing to the new head of the
     reversed linked list.

4. Return prev.

Key Idea:
At every step, save the next node first, reverse the current link,
then move both prev and curr one step forward.

Example:
Before:
1 → 2 → 3 → 4 → null

After:
null ← 1 ← 2 ← 3 ← 4

New Head = 4

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = null;

        while(curr != null){
            fwd = curr.next;     // Store next node
            curr.next = prev;    // Reverse current link
            prev = curr;         // Move prev forward
            curr = fwd;          // Move curr forward
        }

        return prev;
    }
}


/*
Recursive Approach:

1. Base Case:
   - If head is null or there is only one node, the list is already
     reversed, so return head.

2. Store the next node:
      ListNode a = head.next;
   - We need this node because after breaking the current link,
     it will be used to reverse the remaining list.

3. Break the current link:
      head.next = null;
   - This separates the current node from the remaining list.

4. Recursively reverse the remaining list:
      ListNode b = reverseList(a);
   - The recursion goes until the last node.
   - The last node becomes the new head and is stored in b.

5. While returning from recursion:
      a.next = head;
   - Connect the next node back to the current head.
   - This reverses the direction of the link.

6. Return b:
   - b always points to the new head of the reversed linked list.

Key Idea:
First go to the last node using recursion, then while coming back,
reverse each link by connecting the next node back to the current node.

Example:
1 → 2 → 3 → 4 → null

Going down:
1 → 2 → 3 → 4

Coming back:
4 → 3
4 → 3 → 2
4 → 3 → 2 → 1

Time Complexity: O(n)
Space Complexity: O(n)  // recursion call stack
*/


class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode a = head.next;
        head.next = null;

        ListNode b = reverseList(a);
        a.next = head;

        return b;
    }
}
