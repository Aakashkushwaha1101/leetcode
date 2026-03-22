class Solution {
    private int lcs(String s1, String s2,int idx1,int idx2,int[][] dp){
        if(idx1==s1.length() || idx2==s2.length()) return 0;

        if(dp[idx1][idx2]!=Integer.MIN_VALUE) return dp[idx1][idx2];

        int text1Remove=0;
        int text2Remove=0;
        if(s1.charAt(idx1)==s2.charAt(idx2))  //if equal hai last ke dono char to lcs kaa len 1 se badh jayega
            return 1 + lcs(s1,s2,idx1+1,idx2+1,dp);
        else{
            text1Remove=lcs(s1,s2,idx1+1,idx2,dp);//if s2 ka last char s1 ke length -1 char ke equal ho to
            text2Remove=lcs(s1,s2,idx1,idx2+1,dp);//if s1 ka last char s2 ke length -1 char ke equal ho to
            
        }
        return dp[idx1][idx2]=Math.max(text1Remove,text2Remove);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int d[] : dp) Arrays.fill(d , Integer.MIN_VALUE);
       
        return lcs(text1,text2,0,0,dp);
    }
}