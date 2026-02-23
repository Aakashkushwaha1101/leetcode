class Solution {
    private int find(int p,int[] par){
        if(p==par[p]){
            return p;
        }

        int temp=find(par[p],par);
        return temp;
    }

    private void union(int x,int y , int[] par){
        int px=find(x,par);
        int py=find(y,par);

        par[py]=px;


    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] par=new int[n];
        for(int i=0; i<n; i++){
            par[i]=i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, par);
                }
            }
        }

        int count=0;
        for(int i=0 ; i<n ; i++){

            if(par[i]==i){
                count++;
            }
        }
        return count;
        
    }
}