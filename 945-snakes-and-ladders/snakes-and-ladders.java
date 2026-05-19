class Solution {
    private int[] getCoordinate(int num,int n){
        int row=(num-1)/n;
        //ulta numbering hai so hm bottom se dekhenge
        int brow=(n-1)-row;

        //calculate col
        int col=(num-1)%n; //left to right me simple col nikalne kaa trika hi chal jayega
        if((n%2==1 && brow%2==1) || (n%2==0 && brow%2==0))  //right to left
            col=(n-1) - col;  

        return new int[]{brow,col};

    }
    public int snakesAndLadders(int[][] board) {
        int n=board.length;

        Queue<Integer> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        q.offer(1);
        vis[n-1][0]=true;

        int steps=0;
        while(q.size()>0){   //level wise traversal
            int size=q.size();
            steps++;
            for(int i=0; i<size; i++){

                int rem=q.poll();
                if(rem==n*n) return steps-1;   // when we reached to the last block

                for(int j=1; j<=6; j++ ){
                    int val=rem + j;    //new val where we move  dice 6 tkk move krega matalab hum current rem se + 6 tk jaaa skte hai worst case me
                    if(val > n*n) break;

                    int[] p=getCoordinate(val,n);
                    int r=p[0];
                    int c=p[1];

                    if(vis[r][c]==true) continue;  //already visited ho to vha jana hi kyu 
                    vis[r][c]=true;   //mark visited

                    if(board[r][c]==-1){
                        q.offer(val);
                    }else{
                        q.offer(board[r][c]);
                    }


                } 

            }
        }
        return -1;
    }
}