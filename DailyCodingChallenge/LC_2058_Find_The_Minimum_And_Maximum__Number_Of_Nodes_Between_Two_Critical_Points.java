// ### Approach

// * Traverse the linked list while keeping track of the previous, current, and next nodes.
// * A node is a **critical point** if it is either:

//   * a local maximum: greater than both neighbors, or
//   * a local minimum: smaller than both neighbors.
// * Store the position of the **first critical point** and the **last critical point**.
// * For every new critical point, calculate the distance from the previous critical point and update the minimum distance.
// * The **minimum distance** is the smallest distance between two consecutive critical points.
// * The **maximum distance** is the distance between the first and last critical points.
// * If there are fewer than two critical points, return `[-1, -1]`.

// ### Complexity

// * **Time:** `O(n)` — traverse the linked list once.
// * **Space:** `O(1)` — only a few variables are used.


class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];

        ListNode prev = head;
        ListNode temp = head.next;

        int index = 1;
       
        int first = -1;
        int last = -1;

        
        int minDistance = Integer.MAX_VALUE;
        

        while(temp != null && temp.next != null){
            if((temp.val > prev.val && temp.val > temp.next.val) ||
            (temp.val < prev.val && temp.val < temp.next.val)){

               if(first == -1){

                first = index;

                last = index;

               } else {

                minDistance = Math.min(minDistance,index-last);

                last = index;


               }

              
        
            } 

            prev = temp;
            temp = temp.next;
            index++;

                
            
        }

        if(first == last){
            ans[0] = -1;
            ans[1] = -1;
        } else {
            ans[0] = minDistance;

            ans[1] = last - first;
        }
            



        return ans;
    }
}
