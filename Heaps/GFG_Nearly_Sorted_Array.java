/*
Problem: Nearly Sorted Array (K-Sorted Array)
Difficulty: Medium

Intuition:
- Each element is at most k positions away from its correct sorted position.
- A min-heap helps find the smallest element among the available candidates efficiently.

Approach:
1. Create a min-heap using Java's PriorityQueue.
2. Traverse the array and add each element to the heap.
3. Whenever the heap size exceeds k, remove the smallest element and place it at arr[idx].
4. Increment idx after placing each element.
5. After processing the array, remove all remaining elements from the heap and place them in the array in sorted order.

Why PriorityQueue?
- Java's PriorityQueue is a min-heap by default.
- peek/remove operations provide efficient access to the smallest element.

Key Idea:
- Maintain a heap of at most k + 1 elements.
- Write each removed minimum directly back into the original array, avoiding an additional result array.

Time Complexity: O(n log k)
- Each element is inserted into and removed from the heap in O(log k) time.

Space Complexity: O(k)
- The heap stores at most k + 1 elements.
*/

class Solution {
    public void nearlySorted(int[] arr, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int idx = 0;
        
        for(int ele : arr){
            
            pq.add(ele);
            
            if(pq.size() > k) {
                
                arr[idx] = pq.remove();
                idx++;
            }
        } 
        
        while(pq.size() > 0){
            
            arr[idx] = pq.remove();
            idx++;
        }
       
        
    }
}
