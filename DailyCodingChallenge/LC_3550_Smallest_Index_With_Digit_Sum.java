/*
    Problem: Smallest Index With Digit Sum Equal to Index
    Difficulty: Easy
    Approach: Digit Sum

    Intuition:
    For every index, calculate the digit sum of nums[i] and
    check whether it is equal to the current index.

    Approach:
    1. Traverse the array using i.
    2. Calculate the digit sum of nums[i] using % 10 and / 10.
    3. If the digit sum is equal to i, return i.
    4. Return -1 if no such index exists.

    Why % 10 and / 10?
    % 10 gives the last digit, while / 10 removes the last digit.

    Key Idea:
    Digit Sum of nums[i] == i → return i.

    Time: O(n * d)
    Space: O(1)

    d = number of digits in nums[i].
*/

class Solution {
    public int smallestIndex(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            int sum = 0;

            while(nums[i] > 0) {
                int r = nums[i] % 10;
                sum += r;
                nums[i] /= 10;
            }

            if(sum == i) return i;
        }

        return -1;
    }
}
