/*
    Intuition:
    We need to create [nums + nums].

    1. Create an array of size 2*n because the original
       array needs to appear twice.
    2. For every element nums[i], place it in:
       - ans[i]       → first copy
       - ans[i + n]   → second copy
    3. Return the completed array.

    Key Idea:
    The second copy starts at index n, so we use i + n.

    Example:
    nums = [1, 2, 3]
    ans  = [1, 2, 3, 1, 2, 3]

    Time: O(n)
    Space: O(n)
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];

        for(int i=0; i<n; i++){
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }

      return ans;

       
    }
}
