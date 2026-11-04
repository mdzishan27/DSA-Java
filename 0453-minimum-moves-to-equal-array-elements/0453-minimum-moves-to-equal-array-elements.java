class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        
        int minEle = nums[0];

        for(int i=0; i<n; i++){
            if(nums[i] < minEle){
                minEle = nums[i];
            }
        }


        int moves = 0;

        for(int i=0; i<n; i++){
           moves += Math.abs(nums[i] - minEle);
        }

        return moves;
    }
}