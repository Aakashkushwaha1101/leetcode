class Solution {
    // HashMap<String,Integer> map=new HashMap<>();
    private int maxScore(int[][] grid, int k,int row,int col,int cost,int[][][] dp){
        if(row>=grid.length || col>=grid[0].length ){//invalid
            return Integer.MIN_VALUE;
        }
        int newcost=cost;
        if(grid[row][col]!=0){
            newcost++;
        }
        if(newcost > k) return Integer.MIN_VALUE;//invalid

        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(dp[row][col][newcost]!=-1){
            return dp[row][col][newcost];
        }
        // String key=row+" "+col+" "+cost;
        // if(map.containsKey(key)) return map.get(key);

        int right= maxScore(grid,k,row,col+1,newcost,dp);
        int down=maxScore(grid,k,row+1,col,newcost,dp);
        //if both recursive call return int min,so
        if(right==Integer.MIN_VALUE && down==Integer.MIN_VALUE) return dp[row][col][newcost]=Integer.MIN_VALUE;

        return dp[row][col][newcost]=Math.max(right,down) + grid[row][col];
        
    }
    public int maxPathScore(int[][] grid, int k) {
        
        int[][][] dp=new int[grid.length+1][grid[0].length+1][k+1];
        for(int[][] d : dp){
            for(int[] x: d){
                Arrays.fill(x,-1);
            }
        }
        int res=maxScore(grid,k,0,0,0,dp);
        if(res==Integer.MIN_VALUE) return -1;
        return res;
    }
}