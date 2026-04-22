class Solution {
    private int solve(int idx,int[] nums,int last,int[] dp){
        if(idx > last ) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int take=nums[idx] + solve(idx+2 , nums,last,dp);
        int skip=solve(idx+1,nums,last,dp);

        return dp[idx]= Math.max(take,skip);

    }

    public int rob(int[] nums) {
        int n=nums.length;

        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        /* yhaa hum first idx ko skip karke house robber ki trah max find karke layenge
        then firstn idx ko take karke max nikalke dekhenge aur in dono max return kar denge*/
        
        int takeIdx1=solve(0,nums,n-2,dp1);
        int skipIdx1=solve(1,nums,n-1,dp2);

        return Math.max(takeIdx1, skipIdx1);
    }
}