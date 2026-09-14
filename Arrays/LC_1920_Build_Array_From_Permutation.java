/*
    Problem: Build Array from Permutation
    Difficulty: Easy

    Intuition:
    We need to create a new array where:
    ans[i] = nums[nums[i]]

    1. Traverse every index i of nums.
    2. nums[i] gives us an index.
    3. Use that index to access nums again:
           nums[nums[i]]
    4. Store the result in ans[i].
    5. Return the completed array.

    Example:
    nums = [0, 2, 1, 5, 3, 4]

    i = 0 → nums[0] = 0 → nums[0] = 0 → ans[0] = 0
    i = 1 → nums[1] = 2 → nums[2] = 1 → ans[1] = 1
    i = 2 → nums[2] = 1 → nums[1] = 2 → ans[2] = 2

    Key Idea:
    nums[i] is used as an index to access nums again.

    Time: O(n)
    Space: O(n)
*/

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){

        ans[i] = nums[nums[i]];

        }

        return ans;
    }
}
