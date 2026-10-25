/*
Problem: Kth Smallest Element in a Sorted Matrix (LeetCode 378)
Difficulty: Medium

Intuition:
- We need to find the kth smallest element in a sorted matrix.
- A min-heap helps us efficiently retrieve the smallest unprocessed element.

Approach:
1. Create a Triplet class to store the element's value, row, and column because we need its position to find the next element.
2. Use a min-heap ordered by value so the smallest available element is always at the top.
3. Insert the first element of each row because it is the smallest unprocessed element in that row.
4. Remove the smallest element k times because each removal gives the next smallest element in the matrix.
5. After removing an element, insert the next element from the same row if it exists. This works because each row is sorted in ascending order.
6. Store the removed element's value as the answer and return it after k removals.

Why Min-Heap?
- It keeps the smallest available element at the top for efficient retrieval.
- By adding the next element from the same row after each removal, we gradually explore the matrix in sorted order without inserting every element initially.

Key Idea:
- Maintain one available candidate from each row in the heap.
- The kth element removed from the min-heap is the kth smallest element.

Time Complexity: O((n + k) log n)
- Inserting the first element of each of the n rows takes O(n log n).
- The k removals and up to k insertions take O(k log n).

Space Complexity: O(n)
- The min-heap stores at most one candidate per row.
*/


class Solution {
    class Triplet implements Comparable<Triplet>{
        int val;
        int row; 
        int col;

        Triplet(int val,int row,int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet t){
            return this.val - t.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        for(int row=0; row<matrix.length; row++){
            pq.add(new Triplet(matrix[row][0],row,0));
        }

        int ans = -1;

        for(int i=0; i<k; i++){
            
            Triplet t = pq.remove();

            ans = t.val;
        

    
           if(t.col + 1 < matrix[t.row].length){
              int nextCol = t.col + 1;

              pq.add(new Triplet(matrix[t.row][nextCol],t.row,nextCol));
         
            }

        }

        return ans;
    }
}
