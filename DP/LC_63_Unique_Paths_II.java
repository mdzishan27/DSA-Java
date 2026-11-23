/*
Problem: Unique Paths II (LeetCode 63)
Difficulty: Medium

Intuition:
- We need to find the number of unique paths from the top-left corner to the bottom-right corner while avoiding obstacles.
- From every cell, we can move either right or down.
- Recursion helps us explore both possible directions and count all valid paths.

Approach 1: Recursion
1. Create a recursive function solve(i, j, grid) where i and j represent the current row and column of the grid.
2. Handle the boundary condition: if i >= m or j >= n, return 0 because we have moved outside the grid and cannot form a valid path.
3. Check whether the current cell contains an obstacle (grid[i][j] == 1). If it does, return 0 because we cannot move through an obstacle.
4. Check whether the current position is the destination (m - 1, n - 1). If it is, return 1 because we have successfully found one valid path.
5. Calculate right by recursively moving to (i, j + 1) because moving right is one possible direction.
6. Calculate down by recursively moving to (i + 1, j) because moving down is the other possible direction.
7. Add both results because we need to count all valid paths that can reach the destination through either direction.
8. Start the recursion from (0, 0) because we begin at the top-left corner of the grid.
9. Return the total number of valid paths obtained from both recursive calls.

Why Recursion?
- The number of paths from the current cell depends on the number of paths from its right and bottom cells.
- Recursion breaks the problem into smaller subproblems by exploring both possible movements.
- Each call continues until it reaches the destination, an obstacle, or an out-of-bound position.

Key Idea:
- Move only right or down from each cell.
- Return 0 when the position goes outside the grid or contains an obstacle.
- Return 1 when the destination is reached.
- Add the results of both recursive directions to count all valid paths.

Time Complexity: O(2^(m+n))
- Each recursive call can generate up to two additional recursive calls.
- The same grid positions may be calculated repeatedly because memoization is not used.

Space Complexity: O(m + n)
- The recursion call stack can grow up to O(m + n) because each move increases either the row or column by one.
*/



class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return solve(0,0,obstacleGrid);

    }

    private int solve(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j>=n)  return 0;

        if(grid[i][j] == 1) return 0;

        if(i == m-1 && j == n-1){
            return 1;
        }

        int right = solve(i,j+1,grid);
        int down = solve(i+1,j,grid);

        return right+down;


    }
}





/*
Problem: Unique Paths II (LeetCode 63)
Difficulty: Medium

Intuition:
- We need to find the number of unique paths from the top-left corner to the bottom-right corner while avoiding obstacles.
- Similar to the previous Unique Paths problem, we can move only right or down.
- We improve the recursive approach using Memoization to avoid recalculating the same grid positions.

Approach: Memoization (Improved Version of Recursion)
1. Create a 2D dp array of size m x n and initialize all positions with -1 because -1 represents an uncalculated cell.
2. Create a recursive function solve(row, col, grid, dp) that returns the number of valid paths from the current cell to the destination.
3. Handle the boundary condition: if row >= m or col >= n, return 0 because we have moved outside the grid and cannot form a valid path.
4. Check whether the current cell contains an obstacle (grid[row][col] == 1). If it does, return 0 because we cannot pass through an obstacle.
5. If the current position is the destination (m - 1, n - 1), return 1 because we have successfully found one valid path.
6. Before making recursive calls, check dp[row][col]. If it is not -1, return the stored result because the number of paths from this cell has already been calculated.
7. Calculate the number of paths by recursively moving right (row, col + 1) and down (row + 1, col) because these are the only allowed movements.
8. Add both results because we need to count all valid paths that can reach the destination.
9. Store the calculated result in dp[row][col] because the same cell may be reached through different paths and its result can be reused.
10. Start the recursion from (0, 0) because the journey begins at the top-left corner and return the total number of valid paths.

Why Memoization?
- In plain recursion, the same grid positions can be calculated repeatedly when reached through different paths.
- Memoization stores the result for each cell and reuses it whenever that cell is encountered again.
- This avoids repeated calculations and improves the overall time complexity.

Key Idea:
- Move only right or down.
- Return 0 for out-of-bound positions and obstacle cells.
- Return 1 when the destination is reached.
- Store the number of valid paths from each cell in the dp array to avoid recalculation.

Time Complexity: O(m * n)
- Each grid cell is calculated at most once because of memoization.
- Each cell performs at most two recursive calls with constant-time operations.

Space Complexity: O(m * n)
- The 2D dp array requires O(m * n) space.
- The recursion call stack can grow up to O(m + n).
*/


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        return solve(0,0,obstacleGrid,dp);

    }

    private int solve(int row, int col, int[][] grid,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(row >= m || col>=n)  return 0;

        if(grid[row][col] == 1) return 0;

        if(row == m-1 && col == n-1){
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int right = solve(row,col+1,grid,dp);
        int down = solve(row+1,col,grid,dp);

        return dp[row][col] = right+down;


    }
}
