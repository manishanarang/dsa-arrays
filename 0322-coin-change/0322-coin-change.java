class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;

        for(int j = 0; j<n;j++){
            for(int i = 1; i<=amount;i++){
                if(coins[j]<=i){
                    dp[i] = Math.min(1 + dp[i-coins[j]], dp[i]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}