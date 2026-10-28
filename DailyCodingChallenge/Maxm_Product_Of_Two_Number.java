/*
Problem: Maximum Product of Two Digits (LeetCode 3536)
Difficulty: Easy

Intuition:
- We need to find the product of the two largest digits in n.
- Instead of storing and sorting all digits, we can track the two largest digits using two variables.

Approach:
1. Initialize largest and secondLargest to -1 because every digit is greater than or equal to 0.
2. Extract each digit using n % 10 and remove the last digit using n /= 10 because we need to examine every digit individually.
3. If digit >= largest, update secondLargest with the previous largest and make digit the new largest. This ensures duplicate largest digits are also considered.
4. Otherwise, if digit > secondLargest, update secondLargest because the current digit is smaller than the largest but may be the new second largest.
5. Repeat until all digits are processed, then return largest * secondLargest.

Why Two Variables?
- We only need the two largest digits, so storing every digit or sorting the digits is unnecessary.
- Updating these variables while traversing the digits allows us to find the answer in a single pass.

Key Idea:
- Maintain the largest and second-largest digits while extracting digits.
- Use >= for the largest condition to handle duplicate digits correctly, such as 9 and 9 in 994.

Time Complexity: O(d)
- Each digit is extracted and processed once, where d is the number of digits in n.

Space Complexity: O(1)
- Only two variables are used to track the largest and second-largest digits.
*/

class Solution {
    public int maxProduct(int n) {
        
        int largest = -11;
        int secondLargest = -1;

        while (n > 0) {

            int digit = n % 10;
    
            n /= 10;

            if(digit >= largest){
                secondLargest = largest;
                largest = digit;
            }


            else if(digit > secondLargest){
                secondLargest = digit;
            }

        }

        
        return largest * secondLargest;

    }
}
