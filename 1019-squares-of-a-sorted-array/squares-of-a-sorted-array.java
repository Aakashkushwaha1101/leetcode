class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        
        int k=n-1;
        int i=0, j=n-1;

        while(i<=j){
            int sqri=nums[i]*nums[i];
            int sqrj=nums[j]*nums[j];

            if(sqri <= sqrj){
                ans[k--]=sqrj;
                j--;
            }else{
                ans[k--]=sqri;
                i++;
            }
        }
        return ans;
    }
}