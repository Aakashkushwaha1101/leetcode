class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length() , m=str2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1; i<=n; i++){                 //Lcs
            for(int j=1; j<=m; j++){

                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //********************print scss  */
        StringBuilder sb=new StringBuilder();
        int i=n ,j=m;
        while(i > 0 && j>0){

            if(str1.charAt(i-1)==str2.charAt(j-1)){
               sb.append(str1.charAt(i-1));      //if element is common so we add in our ans once
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    sb.append(str1.charAt(i-1));  // here we also add when elements is not common before moving in direction of max len
                    i--;
                }
                else{ // handle == , and dp[i-1][j] < dp[i][j-1]
                
                    sb.append(str2.charAt(j-1)); // here we also add when elements is not common before moving in direction of max len
                    j--;
                }
            }
        }                
        
            /* jab hum last col , yaa row ko touch krenge to uss row num, yaa col num se phele ke saare charcter add honge because 
            isme ekk str null ho jayegi aur dusri me kucch char honge to ,ye char bhi ans kaa part honge hi scss me*/
        while( i > 0){
            sb.append(str1.charAt(i-1));   
            i--;
        }
        while( j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
}