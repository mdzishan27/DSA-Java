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
