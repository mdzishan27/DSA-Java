/*
Optimized Approach:

1. Create a minFromIndex[] array.
   - minFromIndex[i] stores the minimum element from index i
     to the end of the array.

2. Build the suffix minimum from right to left:
      minEle = Math.min(minEle, nums[i]);
      minFromIndex[i] = minEle;

   - Going from right to left allows us to keep track of the
     minimum value seen so far.

3. Traverse the array from left to right and maintain maxEle:
      maxEle = Math.max(maxEle, nums[i]);

   - maxEle represents the maximum element from index 0 to i.

4. For every index i, get the minimum element from i to the end:
      minEle = minFromIndex[i];

5. Calculate the instability score:
      maxEle - minEle

6. Check:
      maxEle - minEle <= k

   - If true, index i is stable.
   - Since we check from left to right, the first stable index
     is automatically the smallest stable index.
   - Return i.

7. If no stable index is found, return -1.

Key Idea:
Precompute the suffix minimum so that we don't repeatedly search
for the minimum on the right. At the same time, maintain the
maximum on the left while traversing the array.

This avoids the nested loops used in the brute-force approach.

Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;


        int[] minFromIndex = new int[n];

        int minEle = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--){

            minEle = Math.min(minEle,nums[i]);

            minFromIndex[i] = minEle;
        }

        int maxEle = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            maxEle = Math.max(maxEle,nums[i]);

        
            minEle = minFromIndex[i];

            if(maxEle - minEle <= k){
                return i;
            }


        
        }
         return -1;


    }
}
