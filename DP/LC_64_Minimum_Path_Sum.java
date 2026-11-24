//Recursion approach

/*
Problem: Minimum Path Sum
LeetCode: 64
Difficulty: Medium

Intuition:
- We need to find the minimum sum path from the top-left cell (0,0) to the bottom-right cell.
- From each cell, we have two possible choices: move down or move right.
- We recursively explore both choices and select the path with the minimum sum.

Approach: Recursion (Brute Force)

1. Start recursion from the top-left cell (0,0).
2. If the current row or column goes outside the grid, return Integer.MAX_VALUE because it represents an invalid path.
3. If we reach the destination (bottom-right cell), return its value.
4. Make two recursive calls:
   - Down: Move to (i+1, j).
   - Right: Move to (i, j+1).
5. Find the minimum sum between the two recursive paths.
6. Add the current cell's value to the minimum of both paths.
7. Return the result.

Why Recursion?
- Each cell has at most two possible choices: down and right.
- Recursion explores all possible valid paths and finds the minimum path sum.

Key Idea:
At every cell, choose the direction that gives the minimum remaining path sum.

Time Complexity: O(2^(m+n))
- At each cell, we make up to two recursive calls.
- In the worst case, we explore an exponential number of paths.

Space Complexity: O(m+n)
- No extra DP array is used.
- The recursion stack can go at most (m+n-1) levels deep.
*/


class Solution {
    public int minPathSum(int[][] grid) {
        return solve(0,0,grid);
    }

    public int solve(int row, int col, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(row>=m || col>=n) {
            return Integer.MAX_VALUE;
        }

        if(row == m-1 && col == n-1){
            return grid[i][j];
        }

        int down = solve(i + 1, j, grid);
        int right = solve(i ,j+1 ,grid);
        int min = Math.min(down,right);

        return grid[i][j] + min;
    }
}
/*
Problem: Minimum Path Sum
LeetCode: 64
Difficulty: Medium

Intuition:
- We need to find the minimum sum path from the top-left cell (0,0) to the bottom-right cell.
- From each cell, we have only two possible movements: right or down.
- We recursively explore both paths and choose the one with the minimum sum.

Approach: Recursion + Memoization (Top-Down DP)

1. Start from the top-left cell (0,0).
2. At every cell, calculate two possible paths:
   - Down: Move to (row + 1, col).
   - Right: Move to (row, col + 1).
3. If the current position goes outside the grid, return Integer.MAX_VALUE because it represents an invalid path.
4. If we reach the destination (bottom-right cell), return its grid value.
5. Before exploring further, check whether the current cell's result is already stored in dp. If yes, return the stored result to avoid recomputation.
6. Find the minimum between the down and right paths.
7. Add the current cell's value to the minimum path sum and store the result in dp.
8. Handle Integer.MAX_VALUE separately to prevent integer overflow when both paths are invalid.

Why Memoization?
- The same cells can be reached through different paths.
- Memoization stores the minimum path sum for each cell so that we calculate it only once.

Key Idea:
dp[row][col] represents the minimum path sum from the current cell (row, col) to the destination.

Time Complexity: O(m × n)
- Each cell is calculated at most once.
- Each cell performs constant work by checking two possible directions.

Space Complexity: O(m × n)
- O(m × n) for the DP array.
- O(m + n) for the recursive call stack in the worst case.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,grid,dp);
    }

    public int solve(int row, int col,int[][] grid,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(row>=m || col>=n) {
            return Integer.MAX_VALUE;
        }

        if(row == m-1 && col == n-1){
            return grid[row][col];
        }

        if(dp[row][col] != -1) return dp[row][col];

        int down = solve(row + 1, col, grid,dp);
        int right = solve(row ,col+1 ,grid,dp);
        int min = Math.min(down,right);
        
        if(min == Integer.MAX_VALUE) return dp[row][col] = Integer.MAX_VALUE;
        return dp[row][col] = grid[row][col] + min;

        
    }
}



/*
Problem: Minimum Path Sum (LeetCode 64)
Difficulty: Medium

Intuition:
- We need to find the minimum sum of a path from the top-left corner to the bottom-right corner.
- We can move only right or down.
- Instead of exploring every possible path using recursion, we use a 2D DP array to store the minimum path sum required to reach each cell.

Approach: Tabulation (Bottom-Up DP)
1. Create a 2D dp array of size m x n because we need to store the minimum path sum for every cell.
2. Start traversing the grid from (0, 0) because we calculate the minimum path sum from the top-left corner towards the destination.
3. Handle the starting cell: if i == 0 and j == 0, store grid[0][0] directly because it is the starting point and has no previous cell.
4. For the first row (i == 0), add the current cell value to dp[i][j-1] because we can only reach these cells by moving right. This builds a cumulative sum from left to right.
5. For the first column (j == 0), add the current cell value to dp[i-1][j] because we can only reach these cells by moving down. This builds a cumulative sum from top to bottom.
6. For all other cells, consider the minimum path sum from the top (dp[i-1][j]) and left (dp[i][j-1]) because these are the only two possible ways to reach the current cell.
7. Add grid[i][j] to the minimum of both previous path sums because we must include the current cell's value in the total path sum.
8. Store the calculated result in dp[i][j] because it represents the minimum path sum required to reach the current cell.
9. Finally, return dp[m-1][n-1] because it contains the minimum path sum to reach the bottom-right corner.

Why Tabulation?
- Instead of using recursion and calculating the same subproblems repeatedly, we solve smaller subproblems first and store their results in the DP array.
- Each cell depends only on its top and left cells, which are already calculated because we traverse the grid from top to bottom and left to right.

Why Cumulative Sum for First Row and Column?
- The first row can only be reached by moving right, so we keep adding the previous cell's path sum.
- The first column can only be reached by moving down, so we keep adding the cell above.
- This handles the boundary conditions where only one movement direction is possible.

Key Idea:
- Store the minimum path sum required to reach each cell.
- Use cumulative sums for the first row and first column.
- For every other cell, choose the minimum path sum from the top or left and add the current cell's value.
- The bottom-right DP cell gives the final minimum path sum.

Time Complexity: O(m * n)
- We traverse every cell of the grid exactly once.
- Each cell performs constant-time operations.

Space Complexity: O(m * n)
- The 2D DP array stores the minimum path sum for every cell.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(i==0 && j==0) dp[i][j] = grid[i][j];
               else if(i == 0) dp[i][j] = grid[i][j] + dp[i][j-1];
               else if(j == 0) dp[i][j] = grid[i][j] + dp[i-1][j];
               else dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);

            }
        }

        return dp[m-1][n-1];
       
    }

    

        
    
}
