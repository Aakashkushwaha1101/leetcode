class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0 , das=0;
        int n=moves.length();
        for(int i=0; i<n; i++){
            if(moves.charAt(i)=='L'){
                left++;
            }else if(moves.charAt(i)=='R'){
                right++;
            }else{
                das++;
            }
        }
       
        return Math.abs(right - left) + das;
    }
}