/*
Approach: BruteForce as n is <=100

1. For every index i, calculate the instability score:
      max(nums[0..i]) - min(nums[i..n-1])

2. Find the maximum element from index 0 to i:
   - Traverse from 0 to i.
   - This gives the maximum value in the left/prefix part.

3. Find the minimum element from index i to n - 1:
   - Traverse from i to the end.
   - This gives the minimum value in the right/suffix part.

4. Important:
   - Reset maxElement and minElement for every new index i.
   - Otherwise, minElement may keep the minimum from a previous
     suffix, which would give the wrong instability score.

5. Check:
      maxElement - minElement <= k

   - If true, index i is stable.
   - Since we check indices from left to right, the first stable
     index is automatically the smallest stable index.
   - Return i.

6. If no index satisfies the condition, return -1.

Key Idea:
For each index, compare the maximum value on its left (including i)
with the minimum value on its right (including i). If their difference
is at most k, that index is stable.

Time Complexity: O(n²)
Space Complexity: O(1)
*/


class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;


        for(int i=0; i<n; i++){

            int maxElement = Integer.MIN_VALUE;
            int minElement = Integer.MAX_VALUE;
            
            for(int j=0; j<=i; j++){
                maxElement = Math.max(maxElement,nums[j]);
            }

            for(int j=i; j<=n-1; j++){
                minElement = Math.min(minElement,nums[j]);
            }

            if(maxElement - minElement <= k){
                return i;
            }
        }

        return -1;

    
    }
}
