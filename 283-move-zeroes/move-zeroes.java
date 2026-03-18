class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0 , j=1;

        while(i<=j && j<n){
            if(nums[i]!=0){
                i++;
                j++;
            }
            else if(nums[i]==0 && nums[i]!=nums[j]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }else if(nums[i]==0 && nums[i]==nums[j]){
                j++;
            }
        }
    }
}