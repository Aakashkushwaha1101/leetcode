class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
       int num=map.firstKey();
       int count=1;
       int lcs=Integer.MIN_VALUE;
       for(Integer key : map.keySet()){
            int num2=key;
            if(num2==num+1){
                count++;
                num=num2;
            }
            else if(num2==num) continue;
            else{
                lcs=Math.max(lcs,count);
                num=num2;
                count=1;
            }
        }
        lcs=Math.max(lcs,count);
        return lcs;
    }
}