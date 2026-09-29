/*
    Intuition:
    Each pattern character must map to exactly one word,
    and each word must map to exactly one pattern character.

    Approach:
    Use two HashMaps to maintain the mapping in both directions:

    1. patternToWord:
       pattern character → word

    2. wordToPattern:
       word → pattern character

    For every pattern character and word:
    - If the pattern character is already mapped, check whether
      it is mapped to the same word. If not, return false.
    - If it is not mapped, create the mapping.
    - Do the same check in the reverse direction for the word.

    Why two maps?
    One map alone would allow cases like:
        pattern = "ab"
        s = "dog dog"

    which is invalid because both 'a' and 'b' cannot represent "dog".

    Time Complexity: O(n)
    Space Complexity: O(n)
*/


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
