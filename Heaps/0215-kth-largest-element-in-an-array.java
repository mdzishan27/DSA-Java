/*
Problem: Kth Largest Element in an Array (LeetCode 215)
Difficulty: Medium

Intuition:
- We need the kth largest element without sorting the entire array.
- A min-heap allows us to efficiently maintain only the k largest elements seen so far.

Approach:minHeap
1. Create a min-heap using Java's PriorityQueue.
2. Traverse each element in the array and add it to the heap.
3. If the heap size exceeds k, remove the smallest element.
4. After processing all elements, the heap contains the k largest elements.
5. The smallest element among them is the kth largest element, so return pq.peek().

Why Min-Heap?
- It keeps the smallest of the current k largest elements at the top.
- If the heap exceeds size k, removing the top discards an element that cannot belong to the k largest elements.

Key Idea:
- Maintain a min-heap of size at most k.
- The root becomes the kth largest element after processing the entire array.

Time Complexity: O(n log k)
- Each insertion takes O(log k), and removing an element when needed also takes O(log k).

Space Complexity: O(k)
- The heap stores at most k elements.
*/





class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums){
            pq.add(ele);
            
            if(pq.size() > k) pq.remove();
        }

        return pq.peek();
    }
}
