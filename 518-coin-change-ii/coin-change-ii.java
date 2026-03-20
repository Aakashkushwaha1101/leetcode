class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0; i<=amount; i++){
            dp[0][i]=0;
        }
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }

        for(int i=1; i<=n; i++){
            for(int am=1; am<=amount; am++){
                
                if(coins[i-1]<=am){
                    dp[i][am]=dp[i][am-coins[i-1]]  + dp[i-1][am];
                }else{
                    dp[i][am]=dp[i-1][am];
                }
            }
        }

        return dp[n][amount];
    }
}