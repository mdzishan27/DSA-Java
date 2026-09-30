class Solution {
    public int findPairs(int[] nums, int k) {
        
       int count=0;

       if(k == 0){
           //for k=0 case1
            Map<Integer, Integer> freq = new HashMap<>();

            for(int x : nums){
             freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        

            for(int x : freq.keySet()){
                if(freq.get(x) >= 2) count++;
            }

            return count;
       
        }
       //case2 k>0
       Set<Integer> set = new HashSet<>();

       for(int ele : nums){
          set.add(ele);
        }
       
       for(int x : set){
          int diff = x - k;

          if(set.contains(diff)) count++;

          
        }
         
        
        return count;
    }

  
}