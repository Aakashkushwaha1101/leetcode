class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len=Math.max(nums1.length,nums2.length);
        List<Integer> list=new ArrayList<>();

        for(int num : nums1){
            list.add(num);

        }

       List<Integer> result=new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(list.contains(nums2[i])){
                list.remove(Integer.valueOf(nums2[i]));
                result.add(nums2[i]);
            }
        }
        int[] ans=new int[result.size()];
        for(int i=0; i<result.size(); i++) ans[i]=result.get(i);

        return ans;
    }
}