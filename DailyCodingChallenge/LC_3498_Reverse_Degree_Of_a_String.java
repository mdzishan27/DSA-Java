/*
    Problem: Reverse Degree of a String
    Difficulty: Easy

    Intuition:
    For each character, find its reverse alphabet value and
    multiply it by its position in the string.

    Approach:
    1. Traverse the string from left to right.
    2. Convert the character into its normal alphabet position:
       ch - 'a' + 1
       This converts the 0-based alphabet index into a 1-based
       alphabet position.
    3. Find the reverse alphabet value using:
       27 - alphabet
       Example: a = 1 → reverse = 26, c = 3 → reverse = 24.
    4. Convert the string index into a 1-based position using:
       i + 1
    5. Multiply reverse value with the character position.
    6. Add the product to sum.
    7. Return the final sum.

    Why +1?
    Java string indexes and ch - 'a' are 0-based, but the problem
    uses 1-based alphabet values and character positions.

    Key Idea:
    Reverse Alphabet Value × String Position → add to sum.

    Time: O(n)
    Space: O(1)
*/

class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            int alphabet = ch - 'a' + 1;

            int reverse = 27 - alphabet;

            int position = i + 1;

            int product = reverse * position;

            sum += product;

        }

        return sum;
    }
}
