class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int ele : map.keySet()){
            int freq = map.get(ele);

            if(set.contains(freq)) return false;

            else set.add(freq);
        }

      
        return true;
            
    }
}