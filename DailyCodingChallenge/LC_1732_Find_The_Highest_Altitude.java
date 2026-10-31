/*
Problem: Find the Highest Altitude (LeetCode 1732)
Difficulty: Easy

Intuition:
- We are given the altitude gain or loss between consecutive points.
- We need to find the maximum altitude reached during the journey.
- Using a running sum, we can calculate the altitude at each point without storing all altitudes.

Approach:
1. Initialize sum = 0 because the journey starts at altitude 0.
2. Initialize max = 0 because the starting altitude itself can be the highest altitude.
3. Traverse the gain array and add each element to sum because each value represents the altitude change from the previous point.
4. After updating sum, compare it with max using Math.max() because we need to keep track of the highest altitude reached so far.
5. Repeat this process for all elements and return max.

Why Running Sum?
- Each element represents the change in altitude, not the actual altitude.
- Adding each gain to the previous altitude gives the current altitude.
- This allows us to find the maximum altitude in a single traversal without using an extra array.

Key Idea:
- Use a prefix sum to calculate the altitude at every point.
- Maintain the maximum altitude while traversing the array.
- Consider the starting altitude as 0.

Time Complexity: O(n)
- We traverse the gain array exactly once, performing constant-time operations at each index.

Space Complexity: O(1)
- We use only two variables, sum and max, without using any extra data structure.
*/

class Solution {
    public int largestAltitude(int[] gain) {

        int n = gain.length;

        int max = 0;

        int sum = 0;

        for(int i=0; i<n; i++){
           
           sum +=  gain[i];

           max = Math.max(max,sum);
        }

        return max;
    }
}
