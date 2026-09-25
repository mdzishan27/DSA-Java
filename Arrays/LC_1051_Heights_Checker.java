/*
    Problem: Height Checker
    LeetCode: 1051
    Difficulty: Easy
    Approach: Sorting

    Intuition:
    The expected order is the heights array sorted in non-decreasing
    order. Compare the original array with this expected array and
    count how many positions are different.

    Approach:
    1. Clone heights so that the original array remains unchanged.
    2. Sort the cloned array to get the expected order.
    3. Compare heights[i] with expected[i].
    4. If they are different, that student is not in the expected
       position, so increase count.
    5. Return the total count.

    Why clone()?
    We need to sort the array to get the expected order, but we
    still need the original order for comparison.

    Why compare index by index?
    The problem asks how many students are standing at a position
    different from their expected position.

    Key Idea:
    Original array vs Sorted array → count mismatched positions.

    Time: O(n log n)  // Sorting
    Space: O(n)       // Cloned array
*/

class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] expected = heights.clone();

        Arrays.sort(expected);

        int count=0;

        for(int i=0; i<n; i++){
            if(heights[i] != expected[i]) count++;
        }

         return count;

    }
}
