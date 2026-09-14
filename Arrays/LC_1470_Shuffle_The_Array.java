/*
    Problem: Shuffle the Array
    Difficulty: Easy

    Intuition:
    The array contains two halves:
        [x1, x2, x3, y1, y2, y3]

    We need to rearrange them as:
        [x1, y1, x2, y2, x3, y3]

    1. Create an answer array of size nums.length.
    2. Use i to traverse the first half of nums.
    3. Use j to traverse the second half of nums.
    4. Use k to track the position in the answer array.
    5. For every iteration:
       - Put nums[i] at ans[k].
       - Put nums[j] at ans[k + 1].
    6. Move i and j one step forward, and k two steps forward.
    7. Return the shuffled array.

    Key Idea:
    i → points to the first half
    j → points to the second half
    k → points to the answer array

    Time: O(n)
    Space: O(n)
*/


class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];

        int i = 0;
        int j = n;
        int k = 0;

       while(i < n){

        ans[k] = nums[i];

        ans[k+1] = nums[j];

        i++;
        j++;
        k += 2;


       }

       return ans;
    }
}
