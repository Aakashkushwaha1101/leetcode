class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
        }
        if(n != max+1) return false;

        int[] hash=new int[max+1];
        for(int i=0; i<n; i++) hash[nums[i]]++;

        for(int i=1; i<=max; i++){
            if(hash[i]==0 ) return false;
        }

        if(hash[max]!=2) return false;
        
       return true;

    }
}