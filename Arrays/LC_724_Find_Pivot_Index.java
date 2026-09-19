/*
    Problem: Find Pivot Index
    Difficulty: Easy
    Approach: Prefix Sum Array

    Intuition:
    For every index, the sum of elements on the left should be
    equal to the sum of elements on the right.

    Approach:using an array
    1. Calculate the total sum of the array.
    2. Create a leftSum array where leftSum[i] stores the sum
       of all elements before index i.
    3. Start from i = 1 because there are no elements before index 0.
    4. Use:
       leftSum[i] = leftSum[i - 1] + nums[i - 1]
       Here, i - 1 is used because nums[i - 1] is the element
       immediately before index i.
    5. For every index, calculate:
       rightSum = totalSum - leftSum[i] - nums[i]
    6. If leftSum[i] == rightSum, return i.
    7. If no pivot index is found, return -1.

    Why i - 1?
    leftSum[i] should contain only elements before index i.
    So we add nums[i - 1], not nums[i], because nums[i] is
    the current element.

    Key Idea:
    Left Sum + Current Element + Right Sum = Total Sum

    Time: O(n)
    Space: O(n)
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int x : nums){
            totalSum += x;
        }
         
        int[] leftSum = new int[n];

        for(int i=1; i<n; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
            
        }

        for(int i=0; i<n; i++){
            int rightSum = totalSum - leftSum[i] - nums[i];

            if(leftSum[i] == rightSum) return i;
        }

        return -1;


    }
}






/*
    Problem: Find Pivot Index
    Difficulty: Easy

    Intuition:
    For a pivot index, the sum of elements on the left must be
    equal to the sum of elements on the right.

    Approach:optimise space complexity
    1. Calculate the total sum of the array.
    2. Keep track of the sum of elements on the left using leftSum.
    3. For every index, calculate the right sum as:
       rightSum = totalSum - leftSum - nums[i]
    4. If leftSum == rightSum, the current index is the pivot,
       so return i.
    5. After checking the current index, add nums[i] to leftSum
       before moving to the next index.
    6. If no pivot index is found, return -1.

    Why subtract nums[i]?
    totalSum contains the left side, current element, and right side.
    So we remove leftSum and nums[i] to get only the right side.

    Key Idea:
    Right Sum = Total Sum - Left Sum - Current Element

    Time: O(n)
    Space: O(1)
*/


