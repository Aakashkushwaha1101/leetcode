class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxWater=0; 
                                //two pointer
        int i=0 ,j=n-1;
        while(i < j){
            int width=j-i; //right - left
            int hight=Math.min(height[i],height[j]);

            maxWater=Math.max(maxWater,width*hight);

            if(height[i] <= height[j]){
                i++;
            }else j--;
        }
    
        return maxWater;
    }
}