class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false; 

        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0)+1);
        }
     
        
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)) return false;

            int freq = map.get(ch);
            if(freq == 0) return false;
            map.put(ch,freq-1);


        }
                

        return true;

    }
}