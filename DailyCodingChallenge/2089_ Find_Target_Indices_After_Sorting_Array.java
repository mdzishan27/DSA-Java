class Solution {

    public int findFirst(int[] nums,int target){
      
        int low=0, high = nums.length-1, first = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
               first = mid;
               high = mid-1;
            }
            else if(nums[mid] > target) high = mid-1;

            else low = mid + 1;
        }

        return first;
    }

    public int findLast(int[] nums,int target){
     
        int low=0, high = nums.length-1, last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
               last = mid;
               low = mid+1;
            }
            else if(nums[mid] > target) high = mid-1;

            else low = mid + 1;
        }

        return last;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
       

        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int first = findFirst(nums,target);
        int last = findLast(nums,target);

        if(first == -1) return ans;

        for(int i=first; i<=last; i++){
            ans.add(i);
        }
        

        return ans;
    }
}
