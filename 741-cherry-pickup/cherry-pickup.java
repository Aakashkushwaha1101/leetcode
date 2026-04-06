class Solution {
    // private int backward(int r,int c,int[][] grid){
    //     if(r<0 || c<0 || grid[r][c]==-1 ) return Integer.MIN_VALUE;

    //     if(r==0 && c==0){
    //         int val=grid[r][c];
    //         grid[r][c]=0;
    //         return val;
    //     }

    //     int left=grid[r][c] + backward(r-1,c,grid);
    //     int up=grid[r][c] + backward(r,c-1,grid);

    //     int best=Math.max(left,up);
    //     if(best<0) return Integer.MIN_VALUE;
    //     grid[r][c]=0;
    //     return best;
    // }
    // private int forward(int r,int c,int n ,int[][] grid){
    //     if(r>=n || c>=n || grid[r][c]==-1 ) return Integer.MIN_VALUE;

    //     if(r==n-1 && c==n-1){
    //         int val=grid[r][c];
    //         grid[r][c]=0;
    //         return val;
    //     }

    //     int down=grid[r][c] + forward(r+1,c,n,grid);
    //     int right=grid[r][c] + forward(r,c+1,n,grid);
        
    //     int best=Math.max(down,right);
    //     if(best < 0) return Integer.MIN_VALUE;
    //     grid[r][c]=0;

    //     return best;
        
    // }
    HashMap<String,Integer> hm=new HashMap<>();
    private int solve(int r1,int c1,int r2,int c2,int[][] grid,Integer[][][][] dp){
        if(r1<0 || r2<0 || c1 < 0 || c2<0 || grid[r1][c1]==-1 || grid[r2][c2]==-1)  return Integer.MIN_VALUE;

        if(r1==0 && c1==0 && r2==0 && c2==0) return grid[r1][c1];

        if (r1 + c1 != r2 + c2)
            return Integer.MIN_VALUE;

        // String key=r1+" "+c1+" "+r2+" "+c2;
        // if(hm.containsKey(key)) return hm.get(key);

        if(dp[r1][c1][r2][c2]!=null) return dp[r1][c1][r2][c2];

        int t1=solve(r1-1,c1,r2-1,c2,grid,dp);
        int t2=solve(r1,c1-1 , r2 ,c2-1,grid,dp);
        int t3=solve(r1-1,c1,r2,c2-1,grid,dp);
        int t4=solve(r1,c1-1,r2-1,c2,grid,dp);

        int best=Math.max(Math.max(t1,t2),Math.max(t4,t3));
        //bug tha what if minimum aa jaye best hi matlab Integer.MIN_VALUE;
        if(best==Integer.MIN_VALUE) {
            // hm.put(key,best);
            return dp[r1][c1][r2][c2]=best;
        }
        int cherry=0;
        if(r1==r2 && c1==c2) cherry=grid[r1][c1];
        else cherry=grid[r1][c1] + grid[r2][c2];
        // hm.put(key,best + cherry);
        return dp[r1][c1][r2][c2]=best + cherry;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        // int forward=forward(0,0,n,grid);
        // System.out.println(forward);
            
        // int backward=backward(n-1,n-1,grid);

        //  System.out.println(backward);

        // return forward + backward;

        Integer[][][][] dp=new Integer[n+1][n+1][n+1][n+1];

        int ans=solve(n-1,n-1,n-1,n-1,grid,dp);
        if(ans==Integer.MIN_VALUE) return 0;

        return ans;
    }
}