class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    int mod=1000000007;
    private int paths(int m,int n,int i,int j,int maxMove,int mv,int[][][] dp){
        if(i>=m || j>=n || i<0 || j<0) return 1;

        if(mv >= maxMove) return 0;
        if(dp[i][j][mv] != -1) return dp[i][j][mv];

        // String key=i+" "+j+" "+mv;
        // if(map.containsKey(key)) return map.get(key);

        int left= paths(m,n,i,j-1,maxMove,mv+1,dp) % mod;
        int right= paths(m,n,i,j+1,maxMove,mv+1,dp) %mod;
        int up= paths(m,n,i-1,j,maxMove,mv+1,dp) %mod;
        int down=paths(m,n,i+1,j,maxMove,mv+1,dp) %mod;

        int ans=((left + right)%mod + (up + down)%mod)%mod;
        // map.put(key,ans);
        return dp[i][j][mv]=ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] dp=new int[51][51][50];
        for(int[][] d : dp){
            for(int[] x: d){
                Arrays.fill(x,-1);
            }
        }
        return paths(m,n,startRow,startColumn,maxMove,0,dp);
    }
}