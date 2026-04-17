class Solution {
    private int reverse(int n){
       int revNum = 0;
        while (n > 0) {
            revNum = revNum * 10 + n % 10;    //logn
            n = n / 10;
        }
        return revNum;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer , Integer> map=new HashMap<>();
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int rev=reverse(nums[i]);
            if(map.containsKey(nums[i])){
                res=Math.min(res, Math.abs(i-map.get(nums[i])));

            }
            map.put(rev,i);
            
        }
       
        if(res==Integer.MAX_VALUE) return -1;
        return res;

    }

}