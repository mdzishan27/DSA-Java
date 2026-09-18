/*
    Problem: Find Numbers with Even Number of Digits
    Difficulty: Easy

    Intuition:
    For every number, count how many digits it contains.
    If the digit count is even, increase the answer.

    Approach:
    1. Traverse every number in the array.
    2. Use num / 10 repeatedly to remove the last digit.
    3. Count how many times we can divide the number by 10.
    4. If the digit count is even, increase count.
    5. Return the final count.

    Why num / 10?
    Each division by 10 removes one digit from the number.

    Example:
    345 → 34 → 3 → 0
    3 divisions = 3 digits → odd

    7896 → 789 → 78 → 7 → 0
    4 divisions = 4 digits → even

    Key Idea:
    Keep removing the last digit and count how many digits
    the number has.

    Time: O(n * d)
    Space: O(1)

    d = number of digits in the largest number.
*/

class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;

        int count = 0;

        for(int num : nums){
            int digit = 0;

            while(num > 0){
                num /= 10;
                digit++;
            
            }

            if(digit % 2 == 0){
                count++;
            }
        
        }

        return count;
    }
}
