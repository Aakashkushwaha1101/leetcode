class Solution {
    public int maxDistance(int[] nums) {
        int n=nums.length;
        int res=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int num=nums[i];
            for(int j=i+1; j<n; j++){
                if(num != nums[j]){
                    res=Math.max(res,Math.abs(i-j));
                }
            }
        }
        return res;
    }
}