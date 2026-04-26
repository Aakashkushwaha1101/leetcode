class Solution {
    class Pair{
        int row,col;
        int parRow , parCol;  //track kaha se hum aa rahe hai
        Pair(int row,int col,int parRow,int parCol){
            this.row=row;
            this.col=col;
            this.parRow=parRow;
            this.parCol=parCol;
            // this.ch=ch;
        }

    }
    private boolean cycleBfs(char[][] grid,int row,int col,char ch,boolean[][] vis){
        int[] r={1,-1,0,0};
        int[] c={0,0,1,-1};
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row,col,-1,-1));
        vis[row][col]=true;

       while(!q.isEmpty()){
            Pair clss=q.poll();
            for(int i=0; i<4; i++){
                int nr= clss.row + r[i];
                int nc=clss.col + c[i];

                if(nr >=0 && nr< grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==ch){
                    
                    if(!vis[nr][nc]){
                        q.offer(new Pair(nr,nc,clss.row,clss.col));
                        vis[nr][nc]=true;
                    }else if(nr != clss.parRow || nc != clss.parCol) return true;
                    
                }
            }
       }
       return false;
         
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j]){
                    boolean res=cycleBfs(grid,i,j,grid[i][j],vis);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}