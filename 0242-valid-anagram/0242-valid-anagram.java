class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false; 
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(sMap.containsKey(ch)){
                int freq = sMap.get(ch);
                sMap.put(ch,freq+1);
            }

            else sMap.put(ch,1);
        }

        for(char ch : t.toCharArray()){
            if(!sMap.containsKey(ch)) return false;
            
            else if(tMap.containsKey(ch)){
                int freq = tMap.get(ch);
                tMap.put(ch,freq+1);
            }

            else tMap.put(ch,1);
        }


        for(char ch : tMap.keySet()){
            int tFreq = tMap.get(ch);
            int sFreq = sMap.get(ch);

            if(sFreq < tFreq) return false;
        }

        return true;

    }
}