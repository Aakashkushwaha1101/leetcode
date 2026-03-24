class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0 , j=nums.length-1;

        int res=nums.length;
        while(i<=j){
            int mid= i +(j-i)/2;

            if(nums[mid] >= target){
                res=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return res;
    }
}