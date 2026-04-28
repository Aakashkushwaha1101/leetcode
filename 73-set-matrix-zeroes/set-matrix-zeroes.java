class Solution {
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> temp=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    temp.add(new Pair(i,j));
                }
            }
        }

        int size=temp.size();
        for(int j=0; j<size; j++){
            Pair p=temp.get(j);
            int r=p.row;
            int c=p.col;
            for(int i=0; i<m; i++){
                matrix[r][i]=0;
            }
            for(int i=0; i<n; i++){
                matrix[i][c]=0;
            }
        } 
    }
}