/*
Approach 1:

1. Find the length of the linked list:
   - Traverse the entire list using temp.
   - Increment length for every node.

2. Start again from the head:
   - We need to reach the middle position.
   - The middle index is length / 2.
   - For an even-sized list, this automatically gives the second
     middle node, as required by the problem.

3. Traverse length / 2 steps:
      temp = temp.next;

   - After these steps, temp points to the middle node.

4. Return temp.

Key Idea:
First find the total number of nodes, then calculate the middle
position using length / 2 and traverse to that position.

Example:
1 → 2 → 3 → 4 → 5

length = 5
length / 2 = 2

Move 2 steps:
1 → 2 → 3
        ↑
      middle

For even length:
1 → 2 → 3 → 4 → 5 → 6

length / 2 = 3
Middle = 4 (second middle node)

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        temp = head;
        for(int i=0; i<length/2; i++){
            temp = temp.next;
        }
        return temp;
    }
}


/*
Approach 2: 

1. Use two pointers:
   - slow → moves one node at a time.
   - fast → moves two nodes at a time.

2. Move both pointers inside the loop:
      slow = slow.next;
      fast = fast.next.next;

3. Continue until fast reaches the end:
   - When fast becomes null or fast.next becomes null,
     slow will be pointing at the middle node.

4. Return slow.

Key Idea:
The fast pointer moves twice as fast as the slow pointer.
So, when fast reaches the end, slow has travelled exactly
half of the list and reaches the middle.

Example:
1 → 2 → 3 → 4 → 5

Start:
slow = 1
fast = 1

Step 1:
slow = 2
fast = 3

Step 2:
slow = 3
fast = 5

fast reaches the end, so slow = 3 → middle.

For even length:
1 → 2 → 3 → 4 → 5 → 6

slow finally points to 4, which is the second middle node.

Time Complexity: O(n)
Space Complexity: O(1)
*/ 

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
