class Solution {
    private int subsequence(List<Integer> nums,int target,int idx,Integer[][] dp){
        if(target==0) return 0;
        if(idx >= nums.size()){
            return Integer.MIN_VALUE; // yhaa 0 return nahi kara rhe kyuki 0 ekk valid answer ho jayega
            //iskaa matlab ki 0 len kaa subsequence hai to usko count krega
        }
        if(dp[idx][target]!=null) return dp[idx][target];

        int take=Integer.MIN_VALUE,skip=0;
        if(nums.get(idx)<=target){
            take=subsequence(nums,target-nums.get(idx),idx+1,dp);
            if(take!=Integer.MIN_VALUE){
                take =1+take;
            }
            // skip=subsequence(nums,target,idx+1);
        }
        skip=subsequence(nums,target,idx+1,dp);
        
        return dp[idx][target]=Math.max(take,skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer[][] dp=new Integer[1001][1001];
        int longestS=subsequence(nums,target,0,dp);
        if(longestS<0) return -1;
        return longestS;

    }
}