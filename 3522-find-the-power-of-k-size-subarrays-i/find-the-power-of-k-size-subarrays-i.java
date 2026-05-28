class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        int l=0;

        for(int i=0; i<n-k+1; i++){

            boolean flag=true;
            for(int j=i+1; j<i+k; j++){
                if (nums[j] != nums[j - 1] + 1) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res[l++] = nums[i + k - 1];

            }else{
                res[l++]=-1;
            }
        }
        return res;
    }
}