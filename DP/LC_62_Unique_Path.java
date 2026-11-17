/*
Problem: Unique Paths (LeetCode 62)
Difficulty: Medium

Intuition:
- We need to find the total number of ways to reach the bottom-right corner of an m x n grid.
- From each cell, we have only two choices: move right or move down.
- Recursion helps us explore both possible directions and count all valid paths.

Approach: Recursion
1. Create a recursive function paths(row, col, m, n) where row and col represent the current position in the grid.
2. Define the boundary condition: if row >= m or col >= n, return 0 because we have moved outside the grid and cannot form a valid path.
3. Check whether the current position is the destination (m - 1, n - 1). If it is, return 1 because we have successfully found one valid path.
4. Calculate rightWays by recursively moving to the next column (col + 1) because moving right is one possible direction.
5. Calculate downWays by recursively moving to the next row (row + 1) because moving down is the other possible direction.
6. Add both results because we need to count all possible paths that can reach the destination through either direction.
7. In the main function, start the recursion from (0, 0) because we begin at the top-left corner of the grid.
8. Return the total number of paths obtained from both recursive choices.

Why Recursion?
- The number of paths from the current cell depends on the number of paths from the right and bottom cells.
- We break the problem into smaller subproblems by exploring both possible movements until reaching the destination or crossing the grid boundary.

Key Idea:
- Move only right or down from each cell.
- Return 0 when the position goes outside the grid.
- Return 1 when the destination is reached.
- Add the results of both directions to count all valid paths.

Time Complexity: Exponential
- Each recursive call can generate up to two additional recursive calls.
- The same grid positions are calculated repeatedly because memoization is not used.
- An upper bound is O(2^(m+n)).

Space Complexity: O(m + n)
- The recursion call stack can grow up to O(m + n) because every recursive path moves only right or down.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        return paths(0,0,m,n);
    }

    public int paths(int row,int col,Integer m,Integer n){
        if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;

        int rightWays = paths(row,col+1,m,n);
        int downWays = paths(row+1,col,m,n);

        return rightWays + downWays;
    }
}


/*
Problem: Unique Paths (LeetCode 62)
Difficulty: Medium

Intuition:
- In the recursive approach, we explore two possible directions from every cell: right and down.
- However, the same grid positions can be reached through different paths, causing repeated calculations.
- To avoid this, we use a 2D DP array to store the number of ways calculated for each position.

Approach 2: Memoization (Improved Version of Recursion)
1. Create a 2D dp array of size m x n and initialize every cell with -1 because -1 represents an uncalculated position.
2. Pass the dp array to the recursive function along with the current row and column so that previously calculated results can be stored and reused.
3. Handle the base cases:
   - If row >= m or col >= n, return 0 because we have moved outside the grid and cannot form a valid path.
   - If row == m - 1 and col == n - 1, return 1 because we have reached the destination and found one valid path.
4. Before making recursive calls, check dp[row][col]. If it is not -1, return the stored result because the number of paths from this position has already been calculated.
5. Calculate rightWays by recursively moving to (row, col + 1) because moving right is one possible direction.
6. Calculate downWays by recursively moving to (row + 1, col) because moving down is the other possible direction.
7. Add both results because we need to count all possible paths from the current position.
8. Store the calculated result in dp[row][col] because the same position may be reached through different paths and its result can be reused.
9. Start the recursion from (0, 0) because we begin at the top-left corner and return the total number of unique paths.

Why Memoization?
- In plain recursion, the same grid positions are calculated repeatedly when reached through different paths.
- Memoization stores the result for each position and reuses it whenever that position is encountered again.
- This avoids repeated calculations and improves the time complexity.

Key Idea:
- Explore both right and down directions using the same recursive logic.
- Store the number of paths from each position in the 2D dp array.
- Reuse previously calculated results instead of exploring the same position again.

Time Complexity: O(m * n)
- Each grid position is calculated at most once because of memoization.
- Each position performs two recursive calls with constant-time operations.

Space Complexity: O(m * n)
- The 2D dp array requires O(m * n) space.
- The recursion call stack can grow up to O(m + n).
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return paths(0,0,m,n,dp);
    }

    public int paths(int row,int col,Integer m,Integer n,int[][] dp){
        if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;
         
        if(dp[row][col] != -1) return dp[row][col];

        int rightWays = paths(row,col+1,m,n,dp);
        int downWays = paths(row+1,col,m,n,dp);

        return dp[row][col] = rightWays + downWays;
    }
}
