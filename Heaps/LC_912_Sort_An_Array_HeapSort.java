class Solution {
    int[] arr;
    int size;

    public int[] sortArray(int[] nums) {
       arr = nums;
       size = nums.length;

       for(int i=1; i<size; i++){
          upheapify(i);
       }

       for(int i = size-1; i>0; i--){
          swap(0,i);
          size--;

          downHeapify(0);
        }

        return arr;

        
    }

    public void upheapify(int idx){
        if(idx == 0) return;

        int parent = (idx-1)/2;
        if(arr[idx] > arr[parent]){
            swap(idx,parent);
            upheapify(parent);
        }
    }

    public void downHeapify(int i){

        int lc = 2*i + 1;
        int rc = 2*i + 2;

        int maxIdx = i;

        if(lc < size && arr[lc] > arr[maxIdx]){
            maxIdx = lc;
        }

        if(rc < size && arr[rc] > arr[maxIdx]){
            maxIdx = rc;
        }

        if(i == maxIdx) return;

        swap(i,maxIdx);
        downHeapify(maxIdx);

    }

    public void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}




/*
Problem: Sort an Array (LeetCode 912)
Difficulty: Medium

Intuition:
- We need to sort the array in ascending order without using built-in sorting functions.
- A Max-Heap helps us efficiently access the largest element and place it at its correct position from the end of the array.

Approach:
1. Use the given array itself as the heap because we want to perform Heap Sort without creating an additional array.
2. Build a Max-Heap by inserting elements conceptually one by one, starting from index 1 because the first element alone is already a valid heap.
3. Use UpHeapify to maintain the Max-Heap property because whenever a newly inserted element is greater than its parent, it must move upward.
4. After building the Max-Heap, the largest element is available at the root (index 0).
5. Swap the root with the last element of the current heap because the largest element belongs at the end of the sorted array.
6. Decrease the heap size because the largest element is now in its correct sorted position and should no longer participate in heap operations.
7. Apply DownHeapify from the root because swapping changes the root value and may violate the Max-Heap property.
8. Repeat the extraction process until only one element remains because all other elements have been placed in their correct positions.
9. Return the modified array because it is now sorted in ascending order.

Why Max-Heap?
- It keeps the largest element at the root, allowing us to place the largest remaining element directly at the end of the array.
- Repeatedly extracting the maximum element produces ascending order when elements are placed from right to left.

Why UpHeapify and DownHeapify?
- UpHeapify maintains the Max-Heap property while building the heap through insertion.
- DownHeapify restores the Max-Heap property after extracting the root and reducing the heap size.

Key Idea:
- Build a Max-Heap using UpHeapify.
- Move the largest element to the end by swapping the root with the last element.
- Reduce the heap size and restore the Max-Heap using DownHeapify.
- Repeat until the entire array is sorted.

Time Complexity: O(n log n)
- Building the heap using repeated insertion takes O(n log n).
- Extracting all elements and restoring the heap takes O(n log n).

Space Complexity: O(log n)
- Heap Sort operates directly on the input array without creating an additional array.
- Recursive UpHeapify and DownHeapify use O(log n) auxiliary stack space.
*/
