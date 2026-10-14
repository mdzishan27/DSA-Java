class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         int n = strs.length;

        HashMap<String, List<String>> map = new HashMap<>();


        for(int i=0; i<n; i++){
            String word = strs[i];

           char[] chars = word.toCharArray();
           Arrays.sort(chars);

           String key = new String(chars);

           if(map.containsKey(key)){

              map.get(key).add(word);

           }

           else {
              
              ArrayList<String> group = new ArrayList<>();
              
              group.add(word);

              map.put(key,group);


           }
            
        }

        return new ArrayList<>(map.values());
    }
}