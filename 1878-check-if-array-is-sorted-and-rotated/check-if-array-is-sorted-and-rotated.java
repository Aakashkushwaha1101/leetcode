class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int i=0;
        int count=0;
        while(i<n){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
            if(count > 1) return false;
            i++;
        }
        return true;
    }
}