/*
    Problem: Missing Number
    Difficulty: Easy

    Intuition:
    The array contains numbers from 0 to n with exactly one number missing.
    Find the sum of all numbers from 0 to n and subtract the sum
    of the elements present in the array.

    Approach:
    1. n = nums.length gives the last number in the range.
    2. Calculate the expected sum using:
       n * (n + 1) / 2
    3. Calculate the actual sum of all elements in nums.
    4. The difference between expected sum and actual sum
       is the missing number.
    5. Return the difference.

    Why use long?
    n * (n + 1) can become large, so long helps avoid
    integer overflow during the calculation.

    Key Idea:
    Expected Sum - Array Sum = Missing Number

    Time: O(n)
    Space: O(1)
*/

class Solution {
    public int missingNumber(int[] nums) {
        long n = nums.length;
        long sum=n*(n+1)/2;
        long arraySum=0;
        for(int ele : nums) {
            arraySum += ele;
        }
        return (int)(sum - arraySum);
    }
}
