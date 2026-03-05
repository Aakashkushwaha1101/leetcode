class Solution {
    private void uniqueSubset(int[] nums,int idx,List<Integer> temp,Set<List<Integer>> set,List<List<Integer>> ans){
        if(idx==nums.length){
            if(!set.contains(temp)){
                set.add(temp);
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[idx]);
        uniqueSubset(nums,idx+1,temp,set,ans);
        temp.remove(temp.size()-1);
        uniqueSubset(nums,idx+1,temp,set,ans);
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<Integer> temp=new ArrayList<>();
        Set<List<Integer>> unique=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();

        uniqueSubset(nums,0, temp,unique, ans);

        return ans;
    }
}