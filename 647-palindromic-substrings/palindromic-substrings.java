class Solution {
    private boolean isPalindrome(int i, int j,String s,int[][] dp){
        if(i>=j){
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1 ;

        if(s.charAt(i)==s.charAt(j)){
            boolean temp=isPalindrome(i+1,j-1,s,dp);
            dp[i][j]=temp ? 1 : 0;    //if temp true huaa to 1 store hoga nahi to 0 hoga store
            return temp;
        }

        dp[i][j]=0;
        return false;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d ,-1);

        int len=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(i,j,s,dp)) len++;
            }
        }

        return len;
        
    }
}