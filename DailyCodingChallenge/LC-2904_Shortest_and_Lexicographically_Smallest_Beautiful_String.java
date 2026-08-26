// Brute Force Approach:
// Try every possible substring length starting from k.
// For each length, check every possible substring and count its number of '1's.
// If a substring contains exactly k ones, compare it with the current result
// and keep the lexicographically smaller one.
//
// Since we check lengths from smallest to largest, the first valid length
// gives the shortest beautiful substring, so we return the result immediately.
//
// This brute force approach is accepted because the constraint is small (n <= 100).
//
// Time Complexity: O(n^3)
// Space Complexity: O(n)

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        for(int len = k; len <= n; len++){
            String result = "";

            for(int start=0; start<=n-len; start++){
              String temp = s.substring(start,start+len);

              int ones=0;

               for(int i=0; i<temp.length(); i++){

                    char ch = temp.charAt(i);
                   
                    if(ch == '1') ones++;

                }  

               if(ones == k){
                   if(result.isEmpty() || temp.compareTo(result) < 0){
                       result = temp;
                    }
                }
            }

            if(!result.isEmpty())  return result;
        }

        return "";
    }
}
