class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;

        int minEleIdx = 0;
        int maxEleIdx = 0;

        for(int i=0; i<n; i++){
            if(nums[i] < nums[minEleIdx]){
                minEleIdx = i;
            }

            
            if(nums[i] > nums[maxEleIdx]){
                maxEleIdx = i;
            }
            
        }

        int left = Math.min(minEleIdx,maxEleIdx);
        int right = Math.max(minEleIdx,maxEleIdx);

        return Math.min(Math.min(left+1+ n- right,right + 1),n - left);
        

        
    }
}