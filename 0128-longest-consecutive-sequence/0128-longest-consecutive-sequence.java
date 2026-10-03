class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int maxLen = 1;

        for(int x : set){
            if(!set.contains(x-1)){
                int start = x;

                int len = 1;

                while(set.contains(start+1)){
                    start++;

                    len++;
                }

                maxLen = Math.max(maxLen,len);
            }
        }

        return maxLen;
    }
}