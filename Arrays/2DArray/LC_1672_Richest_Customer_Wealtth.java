/*
Approach:

1. Treat the 2D array as rows and columns:
   - accounts.length → number of rows (accounts/people).
   - accounts[i].length → number of elements in the current row.

2. Use the outer loop to visit each account:
      for(int i = 0; i < accounts.length; i++)

3. For every account, use the inner loop to visit all its values:
      for(int j = 0; j < accounts[i].length; j++)

   - accounts[i] selects the current row.
   - accounts[i].length tells us how many values are present
     in that particular row.
   - accounts[i][j] accesses each value inside the row.

4. Add all values of the current row to calculate that account's
   total wealth:
      sum += accounts[i][j];

5. Compare the current account's wealth with max:
      max = Math.max(max, sum);

6. After checking all accounts, return max.

Key Idea:
The outer loop selects the row/account, while the inner loop
visits every value inside that row and calculates its total.

Example:
accounts = {
    {1, 2, 3},
    {3, 2, 1},
    {5, 5, 5}
}

Row 0 → 1 + 2 + 3 = 6
Row 1 → 3 + 2 + 1 = 6
Row 2 → 5 + 5 + 5 = 15

Maximum Wealth = 15

Time Complexity: O(n × m)
Space Complexity: O(1)
*/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
       

        for(int i=0; i<accounts.length; i++){

            int sum=0;
            
            for(int j=0; j<accounts[i].length; j++){
                sum += accounts[i][j];
            }

            max = Math.max(max,sum);
        }

        return max;


    }
}
