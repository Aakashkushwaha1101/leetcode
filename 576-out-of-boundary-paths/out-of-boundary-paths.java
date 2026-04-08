class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    int mod=1000000007;
    private int paths(int m,int n,int i,int j,int maxMove,int mv){
        if(i>=m || j>=n || i<0 || j<0) return 1;

        if(mv >= maxMove) return 0;

        String key=i+" "+j+" "+mv;
        if(map.containsKey(key)) return map.get(key);

        int left= paths(m,n,i,j-1,maxMove,mv+1) % mod;
        int right= paths(m,n,i,j+1,maxMove,mv+1) %mod;
        int up= paths(m,n,i-1,j,maxMove,mv+1) %mod;
        int down=paths(m,n,i+1,j,maxMove,mv+1) %mod;

        int ans=((left + right)%mod + (up + down)%mod)%mod;
        map.put(key,ans);
        return ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        return paths(m,n,startRow,startColumn,maxMove,0);
    }
}