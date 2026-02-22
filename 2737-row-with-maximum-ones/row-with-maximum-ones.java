class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int count=Integer.MIN_VALUE, maxCount=0;
        int idx=0;

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(mat[i][j]==1){
                    maxCount++;
                }
            }
            if(maxCount>0 && maxCount>count) idx=i;
            count=Math.max(count,maxCount);
            maxCount=0;
            


        }

        return new int[]{idx,count};

        
    }
}