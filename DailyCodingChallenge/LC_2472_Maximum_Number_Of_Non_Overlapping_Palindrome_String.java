/*
    Problem: Maximum Number of Non-Overlapping Palindromes
    Difficulty: Hard

    First Approach: Recursion

    Intuition:
    We start with a substring of length k and try to find
    the maximum number of non-overlapping palindromes.

    At every (i, j), we have different choices:

    1. If s[i...j] is a palindrome:
       - takeIt → take this palindrome and move to the next
         non-overlapping part.
       - grow   → increase j and make the current substring bigger.
       - slide  → move both i and j forward.

    2. If s[i...j] is not a palindrome:
       - grow → increase j and try a bigger substring.
       - slide → move both i and j forward.

    3. Take the maximum result from all possible choices.

    Key Idea:
    Explore different ways of selecting palindromes and
    return the maximum number of non-overlapping palindromes.

    Problem with this approach:
    The same (i, j) states can be calculated many times,
    which makes the recursion very expensive.

    Also, isPalindrome() checks the whole substring every time,
    which adds more work.

    Result:
    Time Limit Exceeded (TLE)

    Learning:
    This approach helped identify that repeated recursive states
    and repeated palindrome checking need to be optimized.

    Time: O(Exponential) + O(n) palindrome checking
    Space: O(n) recursion stack
*/


class Solution {
    int n;

    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
              return false;
            }

           i++;
           j--;

        }

        return true;
    }


    public int solve(String s, int k, int i, int j , int[][] t){
        if(i >= n || j >= n) return 0;

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(isPalindrome(s,i,j)){

           int takeIt = 1 + solve(s,k,j+1,j+k, t);

           int grow = solve(s,k,i,j+1, t);

           int slide = solve(s,k,i+1,j+1, t);

           return t[i][j] =  Math.max(takeIt,Math.max(grow,slide));
            
        }

        int grow = solve(s,k,i,j+1,t);

        int slide = solve(s,k,i+1,j+1,t);

        return Math.max(grow,slide);
    }

    public int maxPalindromes(String s, int k) {
        n = s.length();

        int[][] t = new int[n][n];

        for(int[] row : t){
            Arrays.fill(row,-1);
        }

        return solve(s,k,0,k-1, t);
    }
}
