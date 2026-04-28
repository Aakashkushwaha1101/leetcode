class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        
        int[] res=new int[n+1];
        res[0]=0;
        res[1]=gain[0];

        for(int i=1; i<n; i++){
            res[i+1]=res[i]+gain[i];
        }

        int highAltitude=Integer.MIN_VALUE;
        for(int i=0; i<=n; i++){
            highAltitude=Math.max(highAltitude,res[i]);
        }

        return highAltitude;
    }
}