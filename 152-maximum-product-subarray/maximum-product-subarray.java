class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int pro = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            pro *= nums[i];
            max = Math.max(max,pro);
            if(pro == 0) pro = 1;
        }
        
        int max2 = Integer.MIN_VALUE;
        int pr=1;
        for(int i = n-1 ; i >=0; i--){
            pr *= nums[i];
            max2 = Math.max(max2,pr);
            if(pr == 0) pr = 1;
        }
        return Math.max(max,max2);
        
    }
}