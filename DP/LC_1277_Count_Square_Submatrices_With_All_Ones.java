/*
Problem: Count Square Submatrices with All Ones (LeetCode 1277)
Difficulty: Medium

Intuition:
- We need to count all square submatrices containing only 1s.
- Instead of checking every possible square separately, we can use DP to find the maximum square size ending at each cell.
- We modify the original matrix itself to store DP values, avoiding an extra 2D array.

Approach: Tabulation (In-Place DP)
1. Traverse the matrix row by row and column by column because we need to calculate the DP value for every cell.
2. If the current cell contains 0, skip it using continue because no square of 1s can end at that position.
3. For cells in the first row or first column, keep the original value unchanged because they cannot form a larger square using all three previous directions.
4. For every other cell, calculate the minimum of the top, left, and top-left diagonal cells because all three positions must support a square of 1s.
5. Add this minimum value to the current cell because the current cell is already 1 and can extend the smaller square by one.
6. Update count by adding the current cell's value because if a cell stores k, it contributes k different all-ones squares of sizes 1 to k.
7. After processing the entire matrix, return count because it contains the total number of all-ones square submatrices.

Why In-Place DP?
- Instead of creating a separate DP array, we use the original matrix to store the maximum square size ending at each cell.
- Since we traverse from top to bottom and left to right, the required top, left, and diagonal values are already calculated.
- This reduces the extra space required.

Key Idea:
- For every cell containing 1, calculate the maximum square size using the minimum of its top, left, and diagonal neighbours, then add the current cell's value.
- Each DP value represents the number of all-ones squares ending at that cell.
- Add all DP values to get the final count.

Time Complexity: O(m * n)
- We traverse every cell of the matrix exactly once.
- Each cell performs constant-time operations.

Space Complexity: O(1)
- We modify the original matrix itself to store DP values.
- No additional DP array or data structure is used.
*/

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0) continue;
                if(i > 0 && j > 0){
                    matrix[i][j] += min(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]);
                }

                count += matrix[i][j];
            }
        }

        return count;
    }

    public int min(int a,int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
