/*
    Problem: Range Sum Query - Immutable
    LeetCode: 303
    Difficulty: Easy
    Approach: Brute Force

    Intuition:
    For each query, find the sum of all elements between
    the given left and right indexes.

    Approach:BruteForce
    1. Store the given array in nums so that sumRange() can
       access it later.
    2. Start from the left index and move up to the right index.
    3. Add nums[i] to sum for every index in this range.
    4. Return the total sum.

    Why nums[i] and not i?
    i represents the index, while nums[i] represents the value
    stored at that index. We need to add the values.

    Example:
    nums = [1, 2, 3, 4, 5]
    sumRange(1, 3) → 2 + 3 + 4 = 9

    Key Idea:
    Traverse only from left to right and add every element.

    Time: O(n) in the worst case
    Space: O(1) extra space
*/

class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;

        for(int i=left; i<=right; i++){
            sum += nums[i];
        }

        return sum;
    }
}

