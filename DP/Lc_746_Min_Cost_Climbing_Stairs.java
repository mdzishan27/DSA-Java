class Solution {

    public int minCost(int[] cost,int idx) {

        if(idx == 0 || idx == 1) return cost[idx];
         
        return cost[idx] + Math.min(minCost(cost,idx-1),minCost(cost,idx-2));

        
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(minCost(cost,n-1),minCost(cost,n-2));
    }
}


/*
Problem: Min Cost Climbing Stairs (LeetCode 746)
Difficulty: Easy

Intuition:
- We need to find the minimum cost required to reach the top of the staircase.
- I start from the last two stairs and recursively move backwards to find the minimum cost of reaching each stair.

Approach:
1. Create a recursive function minCost(cost, idx) that returns the minimum cost required to reach the stair at index idx.
2. Define the base cases:
   - If idx == 0, return cost[0].
   - If idx == 1, return cost[1].
   These are the starting stairs, so we return their respective costs.
3. For every other index, consider the two possible previous stairs (idx - 1 and idx - 2) because we can climb either one or two steps at a time.
4. Recursively calculate the minimum cost of reaching both previous stairs and choose the smaller one using Math.min().
5. Add cost[idx] because we must pay the cost of the current stair.
6. In the main function, call minCost() for the last two stairs (n - 1 and n - 2) because we can reach the top from either of these positions.
7. Return the minimum of both results because we need the least expensive way to reach the top.

Why Recursion?
- The minimum cost of reaching the current stair depends on the minimum cost of reaching either of its previous two stairs.
- We solve the problem by breaking it into smaller subproblems and recursively moving backwards until reaching the base cases.

Key Idea:
- Start from the last two stairs and explore the previous stairs recursively.
- At every index, choose the minimum cost between the previous two possibilities.
- Finally, choose the minimum cost of reaching the last two stairs.

Time Complexity: O(2^n)
- Each recursive call generates up to two additional calls.
- Repeated subproblems are calculated multiple times because memoization is not used.

Space Complexity: O(n)
- The maximum recursion depth is O(n).
*/



class Solution {

    public int minCost(int[] cost,int idx,int[] dp) {

        if(idx == 0 || idx == 1) return cost[idx];

        if(dp[idx] != -1) return dp[idx];
         
        return dp[idx] = cost[idx] + Math.min(minCost(cost,idx-1,dp),minCost(cost,idx-2,dp));

        
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        return Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
    }
}


/*
Approach: Memoization (Top-Down DP)

Intuition:
- Plain recursion recalculates the same subproblems multiple times.
- We can use a dp array to store previously calculated minimum costs and reuse them whenever needed.

Approach:
1. Create a dp array of size n and initialize all positions with -1 because -1 indicates that the subproblem has not been calculated yet.
2. Pass the dp array to the recursive function along with cost and idx so we can store and access previously calculated results.
3. Handle the base cases: if idx == 0 or idx == 1, return cost[idx] because these are the starting stairs.
4. Before making recursive calls, check whether dp[idx] is not -1. If it is already calculated, return the stored result to avoid repeated calculations.
5. Otherwise, calculate the minimum cost by considering the previous two stairs (idx - 1 and idx - 2) and add cost[idx] because we must pay the current stair's cost.
6. Store the calculated result in dp[idx] because the same subproblem may be encountered again during recursion.
7. In the main function, call minCost() for the last two stairs and return the minimum because we can reach the top from either position.

Why Memoization?
- It avoids recalculating the same recursive subproblems.
- Each index is calculated only once, and its result is reused whenever required.

Key Idea:
- Use the same recursive relation as the plain recursion approach.
- Store each calculated result in the dp array.
- Start from the last two stairs and recursively move backwards.

Time Complexity: O(n)
- Each index is calculated at most once because of memoization.
- Each calculation performs constant-time operations.

Space Complexity: O(n)
- The dp array requires O(n) space.
- The recursion call stack can also grow up to O(n).
*/
