// Approach:Recursion --> TLE error
class Solution {

    public int amount(int[] nums,int start,int end){
        if(start > end) return 0;

        int take = nums[start] + amount(nums,start+2,end);
        int skip = amount(nums,start+1,end);

        return Math.max(take,skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int case1 = amount(nums,0,n-2);
        int case2 = amount(nums,1,n-1);

        return Math.max(case1,case2);
    }



    /*
Intuition:
Since houses are arranged in a circle, the first and last houses
are adjacent. Therefore, we cannot rob both.

Approach:Recursion + memoization
1. Handle the edge case where there is only one house.
2. Divide the problem into two cases:
   - Case 1: Exclude the last house (0 to n-2).
   - Case 2: Exclude the first house (1 to n-1).
3. Use recursion with memoization to calculate the maximum money:
   - Take: Rob the current house and move two steps ahead.
   - Skip: Skip the current house and move one step ahead.
4. Store the maximum of both choices in the DP array.
5. Use separate DP arrays for both cases because their
   subproblems have different ending indices.
6. Return the maximum result from both cases.

Why DP?
Memoization avoids recalculating overlapping subproblems.

Time Complexity: O(n)
Each state is calculated at most once in each case.

Space Complexity: O(n)
Two DP arrays and the recursion stack.
*/

 class Solution {

    public int amount(int[] nums,int start,int end,int[] dp){
        if(start > end) return 0;
        if(dp[start] != -1) return dp[start];

        int take = nums[start] + amount(nums,start+2,end,dp);
        int skip = amount(nums,start+1,end,dp);

        return dp[start] = Math.max(take,skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int case1 = amount(nums,0,n-2,dp1);
        int case2 = amount(nums,1,n-1,dp2);

        return Math.max(case1,case2);
    }

   
}  



/*
Problem: House Robber II (LeetCode 213)
Difficulty: Medium

Intuition:
Since houses are arranged in a circle, the first and last houses are adjacent.
Therefore, we cannot rob both. To handle this, divide the problem into two cases.

Approach:Tabulation
1. Handle the edge case where there is only one house.

2. Create two DP arrays to handle both cases independently.

3. Case 1: Exclude the last house.
   - Initialize dp1[0] = nums[0].
   - Initialize dp1[1] = max(nums[0], nums[1]).
   - Iterate from index 2 to n-2.
   - At each index, choose between robbing the current house or skipping it.
   - Store the maximum result in dp1[i].

4. Case 2: Exclude the first house.
   - Initialize dp2[1] = nums[1].
   - Initialize dp2[2] = max(nums[1], nums[2]).
   - Iterate from index 3 to n-1.
   - Apply the same take-or-skip logic and store the maximum in dp2[i].

5. Return the maximum of dp1[n-2] and dp2[n-1].

DP Transition:
dp[i] = max(nums[i] + dp[i-2], dp[i-1])

Why DP?
Dynamic Programming avoids recalculating overlapping subproblems by storing the maximum money that can be robbed up to each index.

Key Idea:
By excluding either the first or last house, the circular problem is converted into two independent linear House Robber problems.

Time Complexity: O(n)
We traverse the array twice, once for each case.

Space Complexity: O(n)
We use two DP arrays of size n.
*/

class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n == 1) return nums[0];
       
        int[] dp1 = new int[n];
        
        //excluding last house
        dp1[0] = nums[0];
        if(n > 1) dp1[1] = Math.max(nums[0],nums[1]);
        

        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(nums[i] + dp1[i-2],dp1[i-1]);
        }
       
        int[] dp2 = new int[n];
        //excluding first house
        dp2[1] = nums[1];
        if(n > 2) dp2[2] = Math.max(nums[1],nums[2]);

        for(int i=3; i<n; i++){
            dp2[i] = Math.max(nums[i] + dp2[i-2],dp2[i-1]);
        }


        return Math.max(dp1[n-2],dp2[n-1]);
    }
}



/*
Problem: House Robber II (LeetCode 213)
Difficulty: Medium

Intuition:
Since houses are arranged in a circle, the first and last houses are adjacent.
Therefore, we cannot rob both. We can solve this by dividing the problem into two independent linear ranges and finding the maximum money from each.

Approach:Using TWO variable
1. Handle the edge case where there is only one house.
2. Divide the circular arrangement into two cases:
   - Case 1: Exclude the last house (index 0 to n-2).
   - Case 2: Exclude the first house (index 1 to n-1).
3. Call robHelper() for both cases and return the maximum result.
4. Inside robHelper(), use two variables:
   - prev2: Stores the maximum money calculated two positions before.
   - prev1: Stores the maximum money calculated at the previous position.
5. Iterate through the given range:
   - Take: Rob the current house and add its value to prev2.
   - Not Take: Skip the current house and use prev1.
6. Calculate the maximum of both choices and store it in curr.
7. Update prev2 and prev1 to move forward without using a DP array.
8. Return prev1 as the maximum money robbed in the given range.

Why DP?
Each house presents two choices: rob it or skip it. We use previously calculated results to avoid recalculating subproblems.

Why Two Variables?
The current state depends only on the previous two states. Therefore, we can optimize space by maintaining prev1 and prev2 instead of storing the entire DP array.

Key Idea:
Convert the circular problem into two linear House Robber problems by excluding either the first or last house, then solve both using space-optimized tabulation.

Time Complexity: O(n)
We traverse the array twice, once for each case. Each traversal takes linear time.

Space Complexity: O(1)
Only three variables (prev1, prev2, and curr) are used, excluding the input array.
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        return Math.max(robHelper(nums, 0, n - 2),robHelper(nums, 1, n - 1));
    }

    private int robHelper(int[] nums,int start,int end) {
                          
        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++) {

            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

