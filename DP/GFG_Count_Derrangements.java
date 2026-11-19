/*
Problem: Derangement Count
Difficulty: Medium

Intuition:
A derangement is an arrangement in which no element stays at its original position.

To count the possible arrangements, we fix the position of one element and consider the remaining elements. Since the selected element cannot stay at its original position, it has (n-1) possible positions.

Approach:
1. Select a Position:
   - Consider the first element. It can be placed in any of the remaining (n-1) positions because it cannot stay at its original position.

2. Consider Two Cases:
   - Case 1: The element occupying the selected position comes back to the original position of the first element. Both elements exchange their positions, leaving (n-2) elements to form a derangement. Ways = D(n-2).
   - Case 2: The element occupying the selected position does not come back to the original position. This reduces the problem to a derangement of (n-1) elements. Ways = D(n-1).

3. Combine Both Cases:
   - For each of the (n-1) possible positions, both cases are possible.
   - Therefore, multiply the sum of both cases by (n-1).

Why and How:
   - We multiply by (n-1) because the first element has (n-1) possible positions.
   - We add D(n-1) and D(n-2) because these represent two mutually exclusive cases after selecting a position.
   - Combining them gives the total number of valid arrangements.

Recurrence Relation:
   D(n) = (n-1) * (D(n-1) + D(n-2))

Base Cases:
   D(1) = 0  // Only one element, so it cannot change its position.
   D(2) = 1  // Both elements exchange their positions.

Time Complexity: O(2^n)
   - Each recursive call generates two smaller recursive calls, resulting in exponential time complexity due to overlapping subproblems.

Space Complexity: O(n)
   - Maximum recursion depth is n, so the recursion stack requires O(n) space.
*/



class Solution {
    public int derangeCount(int n) {
       
       if(n == 1) return 0;
       if(n == 2) return 1;
       return (n-1)*(derangeCount(n-1) + derangeCount(n-2));
       
       
        
    }
}


/*
Problem: Derangement Count
Difficulty: Medium
Approach: Memoization (Top-Down DP)

Intuition:
A derangement is an arrangement in which no element stays at its original position.

Instead of calculating the same subproblems repeatedly using recursion, we use memoization to store previously calculated results and reuse them whenever needed.

Approach:
1. Base Cases:
   - If n == 1, return 0 because the only element cannot change its position.
   - If n == 2, return 1 because both elements must exchange their positions.

2. Create a DP Array:
   - Create an array of size n + 1 and initialize it with -1.
   - Each index stores the number of derangements for that particular value of n.
   - -1 indicates that the subproblem has not been calculated yet.

3. Check Previously Calculated Results:
   - Before calculating the answer, check whether dp[n] is already calculated.
   - If dp[n] != -1, directly return the stored result to avoid repeated recursive calls.

4. Recursive Calculation:
   - Select a position for the first element. It has (n-1) possible choices.
   - Consider two cases:
     a) The element occupying the selected position comes back to the original position of the first element, leaving a derangement problem of size n-2.
     b) The element does not come back to the original position, reducing the problem to a derangement of size n-1.
   - Combine both cases using the recurrence relation.

5. Store the Result:
   - Store the calculated answer in dp[n] so that it can be reused whenever the same subproblem occurs again.

Recurrence Relation:
   D(n) = (n-1) * (D(n-1) + D(n-2))

Why and How:
   - Memoization avoids recalculating overlapping subproblems.
   - The DP array remembers the result of each subproblem.
   - Each value is calculated only once, improving the efficiency of recursion.

Base Cases:
   D(1) = 0
   D(2) = 1

Time Complexity: O(n)
   - Each subproblem from 1 to n is calculated only once.

Space Complexity: O(n)
   - O(n) for the DP array and O(n) for the recursive call stack.
*/

class Solution {
    public int count(int n,int[] dp){
       if(n == 1) return 0;
       if(n == 2) return 1;
       
       if(dp[n] != -1) return dp[n];
       
       return dp[n] = (n-1)*(count(n-1,dp)+count(n-2,dp));
    }
    public int derangeCount(int n) {
       
       int[] dp = new int[n+1];
       
       Arrays.fill(dp,-1);
       
       return count(n,dp);
       

    }
}

/*
Problem: Derangement Count
Difficulty: Medium
Approach: Tabulation (Bottom-Up DP)

Intuition:
A derangement is an arrangement in which no element stays at its original position.

Instead of using recursion, we use a DP array to store the results of smaller subproblems and build the answer iteratively from the base cases up to n.

Approach:
1. Base Cases:
   - dp[1] = 0 because the only element cannot change its position.
   - dp[2] = 1 because both elements must exchange their positions.

2. Create a DP Array:
   - Create an array of size n + 1.
   - Each index dp[i] stores the number of derangements possible for i elements.

3. Build the DP Array:
   - Start the loop from i = 3 because the first two results are already initialized.
   - For every i, consider two cases:
     a) The element occupying the selected position comes back to the original position of the first element, leaving a derangement problem of size i-2.
     b) The element does not come back to the original position, reducing the problem to a derangement of size i-1.
   - Since the first element has (i-1) possible positions, multiply the sum of both cases by (i-1).

4. Calculate and Store:
   - Use the previously calculated values dp[i-1] and dp[i-2] to calculate dp[i].
   - Store the result directly in the DP array.

Recurrence Relation:
   D(i) = (i-1) * (D(i-1) + D(i-2))

Why and How:
   - Tabulation eliminates recursive calls by solving smaller subproblems first.
   - Each result is stored in the DP array and reused to calculate the next result.
   - We build the solution iteratively from the base cases up to n.

Time Complexity: O(n)
   - We iterate from 3 to n, calculating each DP state exactly once.

Space Complexity: O(n)
   - The DP array of size n + 1 stores the results of all subproblems.
*/

class Solution {

    public int derangeCount(int n) {
       
       int[] dp = new int[n+1];
       
       dp[1] = 0;
       if(n > 1) dp[2] = 1;
       
       for(int i=3; i<=n; i++){
           dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
       }
       
       return dp[n];
       

    }
}
