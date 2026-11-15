// Approach:Recursion --> TLE error
class Solution {

    public int amount(int[] nums,int start,int end){
        if(start > end) return 0;

        int take = nums[start] + amount(nums,start+2,end);
        int skip = amount(nums,start+1,end);

        return Math.max(take,skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int case1 = amount(nums,0,n-2);
        int case2 = amount(nums,1,n-1);

        return Math.max(case1,case2);
    }

   



// Approach:Recursion+Memoization
