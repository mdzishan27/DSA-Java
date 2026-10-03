/*
    Intuition:
    We need to find the character that occurs the maximum number
    of times in the string.

    Approach:
    - Treat every character as a possible answer.
    - For each character at index i, count how many times the same
      character occurs from i+1 to the end of the string.
    - Compare its frequency with maxFreq.
    - If its frequency is greater, update maxFreq and ans.
    - If its frequency is equal to maxFreq, choose the character
      that comes earlier in alphabetical order.

    Why two loops?
    The outer loop selects the character whose frequency we want
    to calculate, while the inner loop searches for its occurrences.

    Time Complexity: O(n²)
    Space Complexity: O(1)
*/

public static char getMaxOccuringChar(String s) {

        int maxFreq = 1;
        int ans = s.charAt(0);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int freq = 1;

            for(int j=i+1; j<s.length(); j++){
                if(freq > maxFreq){
                    maxFreq = freq;
                    ans = ch;
                }

                else if(freq == maxFreq && ch < ans){
                    ans = ch;
                }
            }


        }

        return ans;

    }



/*
    Intuition:
    We need to find the character with the highest frequency.
    If multiple characters have the same maximum frequency,
    we return the character that comes first alphabetically.

    Approach:HashMap
    1. Use a HashMap<Character, Integer> to store:
           character → frequency

    2. Traverse the string and update the frequency of every
       character in the HashMap.

    3. Traverse the HashMap to find the maximum frequency.

    4. Traverse the HashMap again:
       - If a character has maxFreq, it is a possible answer.
       - If multiple characters have maxFreq, choose the
         alphabetically smaller character.

    Why HashMap?
    We need to store each character along with its frequency.
    HashMap allows us to update and retrieve the frequency
    efficiently.

    Example:
    s = "aabbc"

    Frequency:
        a → 2
        b → 2
        c → 1

    maxFreq = 2
    Both 'a' and 'b' have the maximum frequency,
    so 'a' is selected because it comes first alphabetically.

    Time Complexity: O(n)
    Space Complexity: O(k)
    where k is the number of distinct characters.
*/

class Solution {
    public char getMaxOccuringChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find maximum frequency
        int maxFreq = 0;

        for(char ch : map.keySet()) {
            maxFreq = Math.max(maxFreq, map.get(ch));
        }

        // Find alphabetically smallest character
        // having maximum frequency
        char ans = 'z';

        for(char ch : map.keySet()) {
            if(map.get(ch) == maxFreq && ch < ans) {
                ans = ch;
            }
        }

        return ans;
    }
}
