class Solution {
    int m=1000000007;
    // HashMap<String,Integer> map=new HashMap<>();
    private int knapsack(int idx,int n,int mp,int[] group,int profit,int[] profits,Integer[][][] dp){
        if(idx==profits.length) {
            return profit >= mp ? 1 :0;
        }
        if(dp[idx][n][profit]!= null) return dp[idx][n][profit];
        // String key=idx+" "+n+" "+profit;
        // if(map.containsKey(key)) return map.get(key);
        int take=0 , skip=0;
        if(n >= group[idx]){
            int newProfit=Math.min(mp,profit+profits[idx]);
            take=knapsack(idx+1,n-group[idx],mp,group,newProfit,profits,dp);
        }
        skip=knapsack(idx+1,n,mp,group,profit,profits,dp);
        int ans=(take + skip)%m;
        // map.put(key,ans);
        return dp[idx][n][profit]=ans;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int len=group.length;
        Integer[][][] dp=new Integer[101][101][101];
        return knapsack(0,n,minProfit,group,0,profit,dp);
    }
}