//Recursion + memoization
class Solution {
    public int ways(int n,int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = ways(n-1,dp) + ways(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return ways(n,dp);
        
    }
}



//Tabulation approach
class Solution {
    public int ways(int n){
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
    public int climbStairs(int n) {
        return ways(n);
        
    }
}
