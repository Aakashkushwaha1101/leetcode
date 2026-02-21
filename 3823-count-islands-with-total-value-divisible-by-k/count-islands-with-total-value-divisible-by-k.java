class Solution {
    static class Pair{
        int row , col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private boolean bfs(int[][] grid,boolean[][] visited,int row,int col,int k){
        
        int[] dir_r={1,-1,0,0};
        int[] dir_c={0,0,1,-1};

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row,col));
        visited[row][col]=true;

        long sum=0;
        while(q.size()>0){

            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;

            sum += grid[r][c];

            for(int i=0; i<4; i++){

                int nr= r + dir_r[i];
                int nc= c + dir_c[i];

                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && visited[nr][nc]!=true && grid[nr][nc]!=0){

                    q.offer(new Pair(nr,nc));
                    visited[nr][nc]=true;
                }
            }
        }

        if(sum%k==0){
            return true;
        }

        return false;


    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length , m=grid[0].length;
        boolean[][] visited=new boolean[n][m];

        int count=0;
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j]!=0 && visited[i][j]!=true){

                    boolean ans=bfs(grid,visited,i,j, k);
                    if(ans){
                        count++;
                    }
                }
            }
        }
        return count;
        
    }
}