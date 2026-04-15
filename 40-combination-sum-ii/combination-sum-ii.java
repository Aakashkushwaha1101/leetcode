class Solution {
    
    private void solve(int idx, int[] nums, int target, 
                       List<Integer> temp, List<List<Integer>> ans){
        
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            
            // 🔥 skip duplicates
            if(i > idx && nums[i] == nums[i-1]) continue;
            
            // pruning
            if(nums[i] > target) break;
            
            temp.add(nums[i]);
            
            // move forward (i+1)
            solve(i + 1, nums, target - nums[i], temp, ans);
            
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 🔥 must
        
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        
        return ans;
    }
}