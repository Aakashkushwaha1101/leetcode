class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        
        int totalSum=0;
        for(int num : nums){
            totalSum +=num;
        }

        int leftSum=0;
        int resIdx=-1;
        for(int i=0; i<n; i++){
            int rightSum=totalSum - leftSum - nums[i];   //formula to find right sum if you have left sum from an element

            if(leftSum==rightSum){
                resIdx = i;
                break;
            }


            leftSum += nums[i];

        }

        return resIdx;
    }
}