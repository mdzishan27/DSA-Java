class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int moves = 0;

        int maxEle = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > maxEle){
                maxEle = nums[i];
            }
        }

        for(int i=0; i<n; i++){
            moves += maxEle - nums[i];
        }

       return moves;

    }
}
