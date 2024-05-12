class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][10000];
        return solve(0, mat, target, 0, dp);
    }
    private int solve(int row, int[][] mat, int target, int sum, Integer[][] dp){
        if(row==mat.length){
            return Math.abs(target-sum);
        }
        int ans = Integer.MAX_VALUE;
        if(dp[row][sum]!=null){
            return dp[row][sum];
        }
        for(int col=0; col<mat[0].length; col++){
            ans = Math.min(ans,solve(row+1, mat, target, sum+mat[row][col], dp));
        }
        return dp[row][sum]=ans;
    }
}