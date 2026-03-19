class Solution {
     private int subsetCount(int idx, int target, int[] arr, int[][] dp){
   
        
        if(idx == arr.length){
            return target == 0 ? 1 : 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        

        int take = 0;
        if(arr[idx] <= target){
            take = subsetCount(idx+1, target - arr[idx], arr, dp);
        }
        int notTake = subsetCount(idx+1, target, arr, dp);

        return dp[idx][target] = take + notTake;
   
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        if((target + totalSum) % 2 != 0) return 0;
        if (Math.abs(target) > totalSum) return 0;
        int targ = (target + totalSum) / 2;

        int[][] dp = new int[nums.length][targ+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return subsetCount(0, targ, nums, dp);
    }
    
}