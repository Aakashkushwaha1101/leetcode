class Solution {
    private static int partition(String s,int i,int j,int[][] dp){
        if(i >= j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            
            // 🔥 IMPORTANT FIX: sirf tab cut karo jab left palindrome ho
            if(isPalindrome(s, i, k)){
                
                int right;
                
                if(dp[k+1][j] != -1){
                    right = dp[k+1][j];
                } else {
                    right = partition(s, k+1, j, dp);
                    dp[k+1][j] = right;
                }
                
                int temp = 1 + right;
                ans = Math.min(ans, temp);
            }
        }
        
        return dp[i][j] = ans;
    }

    private static boolean isPalindrome(String s,int i,int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        
        return partition(s, 0, n-1, dp);
    }
}