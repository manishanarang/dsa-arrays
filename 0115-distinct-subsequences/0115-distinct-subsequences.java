class Solution {
    
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        
        // Base case initialization
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Iterate over the strings in reverse so as to
        // satisfy the way we've modeled our recursive solution
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                
                // Remember, we always need this result
                dp[i][j] = dp[i - 1][j];

                // If the characters match, we add the
                // result of the next recursion call (in this
                // case, the value of a cell in the dp table
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}