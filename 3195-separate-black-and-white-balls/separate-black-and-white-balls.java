class Solution {
    
    public long minimumSteps(String s) {
        int n=s.length();

        long one=0;
        long count=0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                one++;
            }else{
                count +=one;
            }
        }

        return count;
    }
}