// Solved Two Sum using the Brute Force approach in Java.

// Approach: Check every possible pair of elements and return their indices when their sum equals the target.

// Complexity:

// Time: O(n²)
// Space: O(1)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
       for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            if(nums[i] + nums[j] == target) return new int[] {i,j};
        }
       }
        return new int[] {};
    }
}
