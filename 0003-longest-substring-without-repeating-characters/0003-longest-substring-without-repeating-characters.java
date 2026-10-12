/*
    Problem: Longest Substring Without Repeating Characters
    Difficulty: Medium

    Intuition:
    Use the Sliding Window technique to find the longest substring
    containing no repeated characters.

    Approach:
    1. Use a HashMap to store each character and its most recent index.
    2. Maintain two pointers:
       - i = starting index of the current window.
       - j = ending index of the current window.
    3. For every character s.charAt(j):
       - If it already exists in the map and its last index is
         greater than or equal to i, a duplicate exists in the
         current window.
       - Calculate the current window length (j - i) and update maxLen.
       - Move i forward until it passes the previous occurrence
         of the duplicate character.
    4. Update the character's latest index in the map and move j forward.
    5. After the loop, calculate the length of the remaining window
       and update maxLen.

    Why Check map.get(ch) >= i?
    A character may have appeared earlier but outside the current
    window. We only need to handle it if its previous occurrence
    lies inside the current window.

    Key Idea:
    Keep the window free of duplicate characters by moving the
    starting pointer whenever a repeated character is found.

    Time Complexity: O(n)
    Space Complexity: O(min(n, k))
    where k is the size of the character set.
*/




class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;

        HashMap<Character,Integer> map = new HashMap<>();

        int maxLen = 0;

        int i=0 , j=0;

        while(j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i){
                int len = j - i;
                maxLen = Math.max(maxLen,len);

                while(s.charAt(i) != ch)  i++;
                i++;
            }

            map.put(ch,j);
            j++;
        }

           int len = j - i;
           maxLen = Math.max(maxLen,len);

           return maxLen;
    }
}
