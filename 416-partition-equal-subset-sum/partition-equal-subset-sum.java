class Solution {
    private boolean helper(int[] nums,int target,int idx, Boolean dp[][]){
        if(target==0) return true;
        if(idx==nums.length ) return false;

        if(dp[idx][target] != null) return dp[idx][target];

        boolean take=false;
        boolean notake=false;
        if(nums[idx]<=target){
            take=helper(nums,target-nums[idx],idx+1,dp);
            notake=helper(nums,target,idx+1,dp);
        }else{
            notake=helper(nums,target,idx+1,dp);
        }
        return dp[idx][target]= take || notake;

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum +=num;
        }
        if(sum%2!=0) return false;
        Boolean dp[][]=new Boolean[nums.length+1][(sum/2)+1];
        return helper(nums,sum/2,0,dp);

        //apply dynamic programming
        

    }
}