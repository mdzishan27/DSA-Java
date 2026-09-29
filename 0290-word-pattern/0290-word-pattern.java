class Solution {
    public boolean wordPattern(String pattern, String s) {
       Map<Character,String> patternToWord = new HashMap<>();
       Map<String,Character> wordToPattern = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length)  return false;

        for(int i=0; i<pattern.length(); i++){

            char ch = pattern.charAt(i);
            String word = words[i];

           if(patternToWord.containsKey(ch)){
                if(!patternToWord.get(ch).equals(word)){
                    return false;
                }

                
            }

            else{
                    patternToWord.put(ch,word);
            }



           if(wordToPattern.containsKey(word)){
               if(wordToPattern.get(word) != ch){
                  return false;
                }

            
            }

            else {
                    wordToPattern.put(word,ch);
            }

        }


        return true;

    }
}