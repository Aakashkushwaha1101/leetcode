class Solution {
    int m=1000000007;
    // HashMap<String,Integer> map=new HashMap<>();
    private int knapsack(int idx,int n,int mp,int[] group,int profit,int[] profits,int[][][] dp){
        if(idx==profits.length) {
            return profit >= mp ? 1 :0;
        }
        if(dp[idx][n][profit]!= -1) return dp[idx][n][profit];
        // String key=idx+" "+n+" "+profit;
        // if(map.containsKey(key)) return map.get(key);
        int take=0 , skip=0;
        if(n >= group[idx]){
            int profi=Math.min(mp,profit+profits[idx]);
            take=knapsack(idx+1,n-group[idx],mp,group,profi,profits,dp);
        }
        skip=knapsack(idx+1,n,mp,group,profit,profits,dp);
        int ans=(take + skip)%m;
        // map.put(key,ans);
        return dp[idx][n][profit]=ans;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int len=group.length;
        int[][][] dp=new int[101][101][101];
        for(int[][] d : dp){
            for(int[] x: d){
                Arrays.fill(x,-1);
            }
        }
        return knapsack(0,n,minProfit,group,0,profit,dp);
    }
}