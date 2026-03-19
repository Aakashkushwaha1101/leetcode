class Solution {
    //  private int subsetCount(int idx, int target, int[] arr, int[][] dp){
   
        
    //     if(idx == arr.length){
    //         return target == 0 ? 1 : 0;
    //     }

    //     if(dp[idx][target] != -1) return dp[idx][target];

        

    //     int take = 0;
    //     if(arr[idx] <= target){
    //         take = subsetCount(idx+1, target - arr[idx], arr, dp);
    //     }
    //     int notTake = subsetCount(idx+1, target, arr, dp);

    //     return dp[idx][target] = take + notTake;
   
    // }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        if((target + totalSum) % 2 != 0) return 0;  //if target and totalSum odd huaa to iskaa milega hi nhii koi aisa subset jinke sum kaa difference target ke equal ho
        if (Math.abs(target) > totalSum) return 0; // if target is negative and it is greater than the totalSum
        int targ = (target + totalSum) / 2;

        int[][] dp = new int[nums.length+1][targ+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        //base case when we have 0 element and target >0  so 0 count
        for(int i=0; i<=targ; i++){
            dp[0][i]=0;
        }
        //base case when we have element and target is 0 so 1 count
        for(int i=0; i<=nums.length; i++){
            dp[i][0]=1;
        }
       
        //subsetSum for targ , ki how many we have targ in our array
        for(int i=1; i<=nums.length; i++){
            for(int s=0; s<=targ; s++){
                
                if(nums[i-1] == 0){
                    dp[i][s] = 2 * dp[i-1][s]; // 🔥 important fix✅✅
                }
               else if(nums[i-1] <= s){
                    dp[i][s]=dp[i-1][s-nums[i-1]] + dp[i-1][s];
                }else{
                    dp[i][s]=dp[i-1][s];
                }
            }
        }
        return dp[nums.length][targ];
    }
    
}