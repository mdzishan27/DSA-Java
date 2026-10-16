/*
Problem: Kth Smallest Element in an Array
Difficulty: Depends on the specific problem constraints

Intuition:
- The smallest element should be removed first, followed by the second smallest, and so on.
- A min-heap (PriorityQueue) always keeps the smallest element at the top.

Approach:
1. Insert all array elements into a min-heap.
2. Remove the smallest element k - 1 times.
3. The element at the top of the heap is now the kth smallest element.
4. Return the top element using peek().

Why PriorityQueue?
- Java's PriorityQueue is a min-heap by default.
- peek() returns the smallest element, while remove() removes it.

Key Idea:
- Remove the smallest element k - 1 times to reach the kth smallest element.

Time Complexity: O(n + k log n)
- Inserting n elements takes O(n log n) in the worst case when using repeated add() operations.
- Removing k - 1 elements takes O(k log n).
- Therefore, the overall worst-case time complexity is O(n log n + k log n).

Space Complexity: O(n)
- The PriorityQueue stores all n elements.
*/


class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele : arr){
            pq.add(ele);
        }

        for(int i=1; i<k; i++){
            pq.remove();
        }

        return pq.peek();

    }
}

/*
Problem: Kth Smallest Element in an Array
Difficulty: Depends on the specific problem constraints

Intuition:
- The previous approach stores all n elements in a min-heap.
- We can optimize space by maintaining only the k smallest elements using a max-heap.

Approach:optimised using maxHeap
1. Create a max-heap using Collections.reverseOrder().
2. Traverse each element and add it to the heap.
3. If the heap size exceeds k, remove the largest element.
4. After processing all elements, the heap contains the k smallest elements.
5. The largest element among them is the kth smallest element, so return pq.peek().

Why Max-Heap?
- It keeps the largest of the current k smallest elements at the top.
- When a smaller element arrives, removing the top helps retain the k smallest elements.

Key Idea:
- Maintain a max-heap of size at most k instead of storing all n elements.
- This optimizes the auxiliary space from O(n) to O(k).

Time Complexity: O(n log k)
- Each insertion or removal takes O(log k) while the heap size is bounded by k.

Space Complexity: O(k)
- The heap stores at most k elements.
*/


class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : arr){
            pq.add(ele);
            
            if(pq.size() > k) pq.remove();
        }


        return pq.peek();

    }
}

