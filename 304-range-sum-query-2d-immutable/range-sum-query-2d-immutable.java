class NumMatrix {
    int[][]  sumQuer;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        sumQuer=new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                sumQuer[i][j]=sumQuer[i][j-1] + sumQuer[i-1][j] + matrix[i-1][j-1] - sumQuer[i-1][j-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        if(row1 ==0 && col1==0) return sumQuer[row2+1][col2+1];
        return sumQuer[row2+1][col2+1] - sumQuer[row1][col2+1] - sumQuer[row2+1][col1] + sumQuer[row1][col1];
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */