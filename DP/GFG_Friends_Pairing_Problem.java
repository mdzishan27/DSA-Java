/*
Problem: Count Friends Pairings (GFG)
Difficulty: Medium

Intuition:
- We need to find the number of ways n friends can remain single or pair up with another friend.
- For every friend, we have two choices: either remain single or pair with exactly one of the remaining friends.

Approach: Recursion
1. Create a recursive function pair(n) that returns the number of ways to arrange pairings for n friends.
2. Define the base cases:
   - If n == 1, return 1 because the only friend remains single.
   - If n == 2, return 2 because both friends can either remain single or pair together.
3. Consider the first friend remaining single. The remaining n - 1 friends can be paired in pair(n - 1) ways.
4. Consider the first friend pairing with someone. Since there are n - 1 choices for a partner, multiply (n - 1) by pair(n - 2) because two friends are now removed from consideration.
5. Add both possibilities because the first friend can either remain single or form a pair.
6. Return pair(n - 1) + (n - 1) * pair(n - 2) as the total number of possible arrangements.

Why Recursion?
- The pairing problem for n friends can be reduced to smaller subproblems involving n - 1 or n - 2 friends.
- Each recursive call represents one of the two possible choices for the first friend.

Key Idea:
- If the first friend remains single, solve for n - 1 friends.
- If the first friend pairs with someone, multiply the number of possible partners (n - 1) by the ways to arrange the remaining n - 2 friends.
- Add both cases to get the total number of pairings.

Time Complexity: O(2^n)
- Each recursive call generates up to two further recursive calls.
- The same subproblems are calculated repeatedly because memoization is not used.

Space Complexity: O(n)
- The maximum recursion depth can grow up to n.
*/


class Solution {
    
    public int pair(int n){
        if(n <= 2) return n;
        return (pair(n-1) + (n-1)*pair(n-2));
    }
    
    public int countFriendsPairings(int n) {
      
        return pair(n); 
    }
}




/*
Problem: Friends Pairing Problem (GFG)
Difficulty: Medium

Intuition:
- In the recursive approach, we consider two possibilities for every friend: either remain single or pair with another friend.
- However, plain recursion recalculates the same subproblems multiple times.
- To avoid this, we improve the recursive approach by using Memoization to store previously calculated results.

Approach 2: Memoization (Improved Version of Recursion)
1. Create a dp array of size n + 1 and initialize it with -1 because we need to store the results for different values of n.
2. Pass the dp array to the recursive function so that previously calculated results can be stored and reused.
3. Handle the base case: if n <= 2, return n because:
   - For 1 friend, there is only 1 possibility (remain single).
   - For 2 friends, there are 2 possibilities (both remain single or pair together).
4. Before making recursive calls, check dp[n]. If it is not -1, return the stored result because that subproblem has already been solved.
5. Use the same recursive logic as the previous approach:
   - If the first friend remains single, the remaining n - 1 friends can be paired in pair(n - 1) ways.
   - If the first friend pairs with someone, there are n - 1 choices for a partner, and the remaining n - 2 friends can be paired in pair(n - 2) ways.
6. Add both possibilities and store the result in dp[n] because the same subproblem may be needed again during recursion.
7. Return the stored result for n to get the total number of possible pairing arrangements.

Why Memoization?
- In the previous recursive approach, the same subproblems were calculated repeatedly.
- Memoization stores the result of each calculated subproblem and reuses it whenever needed.
- This avoids unnecessary recursive calls and improves the overall time complexity.

Key Idea:
- Keep the same recursive logic of choosing between remaining single or forming a pair.
- Use the dp array to remember previously calculated results.
- Each subproblem is calculated only once.

Time Complexity: O(n)
- Each state from 1 to n is calculated at most once.
- Every state performs constant-time operations.

Space Complexity: O(n)
- The dp array requires O(n) space.
- The recursion call stack can also grow up to O(n).
*/

class Solution {
    
    public int pair(int n,int[] dp){
        
        if(n <= 2) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = pair(n-1,dp) + (n-1)*pair(n-2,dp);
    }
    
    public int countFriendsPairings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return pair(n,dp); 
    }
}
