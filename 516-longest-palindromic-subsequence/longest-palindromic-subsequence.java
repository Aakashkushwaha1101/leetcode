class Solution {
    private int lcs(String s1, String s2){
        int n=s1.length() , m=s2.length();
        int[][] dp=new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    private String reverse(String s,int i){
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            sb.append(s.charAt(i));
            i--;
        }
        return sb.toString();

    }
    public int longestPalindromeSubseq(String s) {
        
        String revers=reverse(s,s.length()-1);

        return lcs(s,revers);
    }
}