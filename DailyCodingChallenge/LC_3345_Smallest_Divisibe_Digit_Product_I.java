/*
Problem: Smallest Divisible Digit Product I (LeetCode 3345)
Difficulty: Easy

Intuition:
- We need to find the smallest number greater than or equal to n whose digit product is divisible by t.
- We can check the numbers one by one because the first valid number we find will be the smallest answer.

Approach:
1. Create a findDigitProd() method to calculate the product of all digits of a number because we need to check whether this product is divisible by t.
2. Extract each digit using num % 10 and remove the last digit using num /= 10 because this allows us to process every digit individually.
3. Initialize product to 1 because it is the identity value for multiplication.
4. Start a loop from n and check each number in increasing order because we need the smallest valid number greater than or equal to n.
5. Calculate the digit product of each number and check product % t == 0 because a remainder of 0 means the product is divisible by t.
6. Return the first number that satisfies the condition because all smaller candidates have already been checked.
7. If no valid number is found within the specified range, return -1.

Why Brute Force?
- We check numbers in increasing order, so the first valid number is automatically the smallest.
- Calculating the digit product is straightforward, making this approach simple and easy to implement.

Key Idea:
- Check each number starting from n.
- Return the first number whose digit product is divisible by t.

Time Complexity: O(d * r)
- Calculating the digit product takes O(d), where d is the number of digits.
- Checking r candidate numbers takes O(d * r) overall.

Space Complexity: O(1)
- Only a few variables are used, regardless of the number of digits.
*/


class Solution {

    public int findDigitProd(int num) {
        int product = 1;

        while (num > 0) {
            int digit = num % 10;
            product *= digit;

            num /= 10;
        }

        return product;
    }

    public int smallestNumber(int n, int t) {

        for (int num = n; num <= num + 10; num++) {

            if (findDigitProd(num) % t == 0) {
                return num;
            }
        }

        return -1;
    }
}
