/*
Problem: Perfect Squares (LeetCode 279)
Difficulty: Medium

Intuition:
- We need to find the minimum number of perfect squares whose sum is equal to n.
- We can recursively divide n into two smaller parts and find the minimum number of perfect squares required for both parts.

Approach: Recursion
1. Create an isPerfect() function to check whether a number is a perfect square by calculating its square root and checking whether sqrt * sqrt == n.
2. In the numSquares() function, first check whether n is a perfect square. If it is, return 1 because only one perfect square is needed.
3. Otherwise, initialize min = Integer.MAX_VALUE to store the minimum number of perfect squares required.
4. Run a loop from 1 to n / 2 because we divide n into two parts: i and n - i.
5. Recursively calculate the minimum number of perfect squares required for both parts using numSquares(i) and numSquares(n - i).
6. Add both results because we need the total number of perfect squares required to form n.
7. Update min using Math.min() because we need the minimum count among all possible splits.
8. Return min after checking all possible splits.

Why Recursion?
- We break the original number into smaller parts and solve each part recursively.
- Each part is further divided until it becomes a perfect square, where the recursion returns 1.

Key Idea:
- If n itself is a perfect square, return 1.
- Otherwise, try every possible split of n into two parts.
- Add the minimum square counts of both parts and choose the minimum result among all splits.

Time Complexity: Exponential
- The same subproblems are calculated repeatedly because memoization is not used.
- Every recursive call can generate multiple additional calls.

Space Complexity: O(n)
- The recursion call stack can grow up to O(n) in the worst case.
*/

class Solution {
    public boolean isPerfect(int n){
           
        int sqrt = (int)(Math.sqrt(n));

        return (sqrt*sqrt == n);
    }
    public int numSquares(int n) {
        if(isPerfect(n)) return 1;
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=n/2; i++){
            int count = numSquares(i) + numSquares(n-i);
            min = Math.min(min,count);
        }

        return min;
    }
}   


/*
Problem: Perfect Squares (LeetCode 279)
Difficulty: Medium

Intuition:
- In the previous recursive approach, we tried different ways to divide n into two smaller parts and calculated the minimum number of perfect squares required for both parts.
- However, the same values of n were calculated repeatedly.
- To avoid these repeated calculations, we use Memoization to store and reuse previously calculated results.

Approach 2: Memoization (Improved Version of Recursion)
1. Create an isPerfect() function to check whether a number is a perfect square by calculating its square root and checking whether sqrt * sqrt == n.
2. Create a dp array of size n + 1 and initialize it with -1 because we need to store the minimum number of perfect squares required for different values of n.
3. Create a recursive function minSquares(n, dp) that returns the minimum number of perfect squares required to represent n.
4. First, check whether n is a perfect square. If it is, return 1 because only one perfect square is required.
5. Check dp[n] before making recursive calls. If it is not -1, return the stored result because that subproblem has already been calculated.
6. Initialize min = Integer.MAX_VALUE to store the minimum number of perfect squares among all possible splits.
7. Run a loop from 1 to n / 2 because we divide n into two smaller parts: i and n - i.
8. Recursively calculate the minimum number of perfect squares required for both parts using minSquares(i, dp) and minSquares(n - i, dp).
9. Add both recursive results because they represent the total number of perfect squares required to form n through the current split.
10. Update min using Math.min() because we need the minimum count among all possible splits.
11. Store the calculated result in dp[n] because the same subproblem may be needed again during recursion.
12. Finally, return minSquares(n, dp) from the main function to get the minimum number of perfect squares.

Why Memoization?
- In the previous recursive approach, the same subproblems were calculated multiple times.
- Memoization stores previously calculated results in the dp array and reuses them whenever the same value of n occurs again.
- This avoids repeated recursive calculations.

Key Idea:
- If n is a perfect square, return 1.
- Otherwise, try every possible split of n into two parts.
- Add the minimum square counts of both parts and choose the minimum result.
- Store the results in dp to avoid recalculating the same subproblems.

Time Complexity: O(n^2)
- There are O(n) different subproblems because each value of n is calculated at most once.
- For each subproblem, we run a loop up to n / 2, taking O(n) time in the worst case.
- Checking whether a number is a perfect square takes O(sqrt(n)), which does not change the overall O(n^2) complexity.

Space Complexity: O(n)
- The dp array requires O(n) space.
- The recursion call stack can also grow up to O(n).
*/

class Solution {
    public boolean isPerfect(int n){
           
        int sqrt = (int)(Math.sqrt(n));

        return (sqrt*sqrt == n);
    }

    public int minSquares(int n,int[] dp) {
        if(isPerfect(n)) return 1;

        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=n/2; i++){
            int count = minSquares(i,dp) + minSquares(n-i,dp);
            min = Math.min(min,count);
        }

        return dp[n] = min;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return minSquares(n,dp);
    }
}




/*
Problem: Perfect Squares (LeetCode 279)
Difficulty: Medium

Intuition:
- We need to find the minimum number of perfect squares whose sum equals n.
- In the previous approach, we tried every possible split of n into two parts.
- We can improve this by considering only perfect squares because each selected part must be a perfect square.

Approach 3: Optimized Memoization
1. Create an isPerfect() function to check whether a number is a perfect square by calculating its square root and checking whether sqrt * sqrt == n.
2. Create a dp array of size n + 1 and initialize it with -1 because we need to store the minimum number of perfect squares required for different values of n.
3. Create a recursive function minSquares(n, dp) that returns the minimum number of perfect squares required to represent n.
4. First, check whether n is a perfect square. If it is, return 1 because only one perfect square is required.
5. Check dp[n] before making recursive calls. If it is not -1, return the stored result because that subproblem has already been calculated.
6. Initialize min = Integer.MAX_VALUE to store the minimum number of perfect squares required.
7. Run a loop from i = 1 while i * i <= n because we only need to consider perfect squares smaller than or equal to n.
8. For each perfect square i * i, calculate the number of perfect squares required for the remaining value (n - i * i) using recursion.
9. Add minSquares(i * i, dp) and minSquares(n - i * i, dp) because we are dividing n into the selected perfect square and the remaining value.
10. Update min using Math.min() because we need the minimum count among all possible perfect-square choices.
11. Store the calculated result in dp[n] because the same subproblem may be needed again during recursion.
12. Return minSquares(n, dp) from the main function to get the minimum number of perfect squares.

Why Optimized Memoization?
- In the previous approach, we checked every possible split from 1 to n / 2.
- Here, we only consider perfect squares (1, 4, 9, 16, ...) because these are the valid numbers we can use.
- This reduces the number of choices considered in each recursive call.

Key Idea:
- If n is already a perfect square, return 1.
- Otherwise, try subtracting every possible perfect square from n.
- Recursively calculate the minimum number of perfect squares required for the remaining value.
- Store previously calculated results in dp to avoid repeated calculations.

Time Complexity: O(n * sqrt(n))
- There are O(n) possible subproblems.
- For each subproblem, we check perfect squares up to n, resulting in O(sqrt(n)) iterations.
- Memoization ensures each subproblem is calculated only once.

Space Complexity: O(n)
- The dp array requires O(n) space.
- The recursion call stack can grow up to O(n) in the worst case.
*/

class Solution {
    public boolean isPerfect(int n){
           
        int sqrt = (int)(Math.sqrt(n));

        return (sqrt*sqrt == n);
    }

    public int minSquares(int n,int[] dp) {
        if(isPerfect(n)) return 1;

        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;

        for(int i=1; i*i<=n; i++){
            int count = minSquares(i*i,dp) + minSquares(n-i*i,dp);
            min = Math.min(min,count);
        }

        return dp[n] = min;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return minSquares(n,dp);
    }
}

/*
Problem: Perfect Squares (LeetCode 279)
Difficulty: Medium

Intuition:
- We need to find the minimum number of perfect squares whose sum equals n.
- In the previous Memoization approach, we recursively selected perfect squares and calculated the minimum count for the remaining value.
- We can solve the same problem using Tabulation by storing the answers for smaller values first and using them to calculate larger values.

Approach 4: Tabulation (Bottom-Up DP)
1. Create a dp array of size n + 1 because we need to store the minimum number of perfect squares required for every value from 0 to n.
2. Traverse from i = 1 to n because we calculate the answers in increasing order, ensuring that the smaller subproblems are already solved.
3. Check whether i is a perfect square using isPerfect(). If it is, set dp[i] = 1 because only one perfect square is needed to represent it.
4. Otherwise, initialize min = Integer.MAX_VALUE to store the minimum number of perfect squares required for the current value.
5. Run a loop from j = 1 while j * j <= i because we only need to consider perfect squares that are less than or equal to i.
6. For every perfect square j * j, calculate dp[j * j] + dp[i - j * j] because we divide the current value into the selected perfect square and the remaining value.
7. Update min using Math.min() because we need the minimum number of perfect squares among all possible choices.
8. Store the minimum result in dp[i] because it represents the minimum number of perfect squares required to form i.
9. After calculating all values up to n, return dp[n] because it contains the final minimum count.

Why Tabulation?
- In the previous Memoization approach, we used recursion to solve smaller subproblems and stored their results in the dp array.
- Here, we calculate the same subproblems iteratively from smaller values to larger values.
- This removes recursion and avoids the recursive call stack.

Key Idea:
- If i is already a perfect square, dp[i] = 1.
- Otherwise, try every perfect square j * j that can be subtracted from i.
- Add the result for the selected perfect square and the remaining value.
- Choose the minimum count and store it in dp[i].

Time Complexity: O(n * sqrt(n))
- The outer loop runs from 1 to n.
- For each value, the inner loop checks perfect squares up to that value, taking O(sqrt(n)) time.
- Therefore, the overall time complexity is O(n * sqrt(n)).

Space Complexity: O(n)
- The dp array requires O(n) space.
- No recursion stack is used.
*/

class Solution {
    public boolean isPerfect(int n){
           
        int sqrt = (int)(Math.sqrt(n));

        return (sqrt*sqrt == n);
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            if(isPerfect(i)) dp[i] = 1;

            else {

                int min = Integer.MAX_VALUE;

                for(int j=1; j*j<=i; j++){
                    int count = dp[j*j] + dp[i-j*j];
                    min = Math.min(min,count);
                }

                dp[i] = min;
            }
        }

        return dp[n];
    }
}
