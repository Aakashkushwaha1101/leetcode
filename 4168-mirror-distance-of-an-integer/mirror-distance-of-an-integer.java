class Solution {
    private int reverse(int n){
        int ans=0;
        while(n>0){
            int rem= n % 10;
            ans= ans *10 + rem;

            n = n/10;
        }

        return ans;
    }
    public int mirrorDistance(int n) {
        int rev=reverse(n);

        int res=Math.abs(n-rev);

        return res;
    }
}