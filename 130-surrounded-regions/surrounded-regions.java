class Solution {
    class Pair{
        int row ,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private void bfs(char[][] grid,int row,int col, boolean[][] vis){
        int[] r={0,0,-1,1};
        int[] c={1,-1,0,0};
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row,col));
        grid[row][col]='M';

        while(q.size()>0){
            Pair rem=q.poll();

            for(int i=0; i<4; i++){
                int nr=rem.row + r[i];
                int nc=rem.col + c[i];

                if(nr>=0 && nr<grid.length && nc >=0 && nc<grid[0].length && grid[nr][nc]=='O' && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    grid[nr][nc]='M';
                    q.offer(new Pair(nr,nc));
                }
            }
        }
    }
    public void solve(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        for(int i=0; i<m;i++){
            if(!vis[0][i] && grid[0][i]=='O'){
                bfs(grid,0,i,vis);
            }
        }

        for(int i=0; i<n;i++){
            if(!vis[i][0] && grid[i][0]=='O'){
                bfs(grid,i,0,vis);
            }
        }

        for(int i=0; i<m;i++){
            if(!vis[n-1][i] && grid[n-1][i]=='O'){
                bfs(grid,n-1,i,vis);
            }
        }

        for(int i=0; i<n;i++){
            if(!vis[i][m-1] && grid[i][m-1]=='O'){
                bfs(grid,i,m-1,vis);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!='M' && grid[i][j]!='X'){
                    grid[i][j]='X';
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='M'){
                    grid[i][j]='O';
                }
            }
        }
        
    }
}