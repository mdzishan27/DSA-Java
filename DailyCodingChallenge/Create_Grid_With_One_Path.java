/*
Problem: Create Grid
Difficulty: Not Specified

Intuition:
- We need to create an m x n grid filled with '#' and replace the first row and last column with '.'.
- A 2D character array makes it easy to initialize and modify individual cells.

Approach:
1. Create a String array of size m to store the final grid because each row must be returned as a String.
2. Create an m x n character grid to represent the required pattern.
3. Fill every row with '#' using Arrays.fill() because all cells initially contain '#'.
4. Traverse the first row and replace every cell with '.' because the entire top row must contain dots.
5. Traverse the last column from row 1 to m - 1 and replace each cell with '.' because the remaining cells of the last column must also contain dots.
6. Convert each character row into a String because the required output is a String array.
7. Return the String array containing the completed grid.

Why 2D Character Array?
- It allows us to modify individual grid cells easily using row and column indices.
- After constructing the pattern, each row can be converted into a String for the required output.

Key Idea:
- Initialize the entire grid with '#'.
- Replace the first row and last column with '.'.
- Convert each row into a String and return the result.

Time Complexity: O(m * n)
- Initializing the grid takes O(m * n).
- Updating the first row and last column takes O(m + n).
- Converting all rows into Strings takes O(m * n).

Space Complexity: O(m * n)
- The 2D character grid and the resulting String array require O(m * n) space.
*/


class Solution {
    public String[] createGrid(int m, int n) {
        
        String[] ans = new String[m];

        char[][] grid = new char[m][n];
         
    
        for(int i=0; i<m; i++){
            Arrays.fill(grid[i],'#');
        }

        for(int j=0; j<n; j++){
            grid[0][j] = '.';
        }

        for(int i=1; i<m; i++){
            grid[i][n-1] = '.';
        }

        
        for(int i=0; i<m; i++){
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}
