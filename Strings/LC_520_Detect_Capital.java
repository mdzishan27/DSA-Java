// Approach:
// Count all uppercase characters in the word.
//
// Then check 3 valid cases:
// 1. uppercase == word.length() → all letters are uppercase.
// 2. uppercase == 0 → all letters are lowercase.
// 3. uppercase == 1 && first character is uppercase → only the first letter is uppercase.
//
// If any one of these conditions is true, return true.
// Otherwise, return false.
//
// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public boolean detectCapitalUse(String word) {
       int uppercase = 0;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if(Character.isUpperCase(ch)) uppercase++;
        }

        return uppercase == word.length() || 
                
                uppercase == 0 ||

                (uppercase == 1 && Character.isUpperCase(word.charAt(0)));
               
    }
}
