/*
Intuition:

- In a Toeplitz matrix, every diagonal from top-left to bottom-right
  contains the same value.
- For any element matrix[i][j], its upper-left diagonal neighbor is
  matrix[i-1][j-1].
- Therefore, if every element is equal to its upper-left neighbor,
  all diagonals will automatically have the same value.

Approach:

1. Get the number of rows and columns:
      m = matrix.length
      n = matrix[0].length

2. Start both loops from index 1:
      for(int i = 1; i < m; i++)
      for(int j = 1; j < n; j++)

   - We start from 1 because we need to access i-1 and j-1.
   - The first row and first column don't have an upper-left neighbor.

3. For every element, compare:
      matrix[i][j]
   with:
      matrix[i-1][j-1]

4. If they are different:
      return false;

   - This means the diagonal has different values, so the matrix
     is not Toeplitz.

5. If every element matches its upper-left neighbor, return true.

Key Idea:
Instead of checking complete diagonals, simply check whether every
element is equal to the element immediately above-left of it.

Example:
1  2  3
4  1  2
5  4  1

Check:
matrix[1][1] == matrix[0][0] → 1 == 1 ✓
matrix[1][2] == matrix[0][1] → 2 == 2 ✓
matrix[2][1] == matrix[1][0] → 4 == 4 ✓
matrix[2][2] == matrix[1][1] → 1 == 1 ✓

All checks pass → Toeplitz matrix.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){

                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }

        return true;
    }
}
