class Solution {
    private void generateBinary(int n,String s, List<String> list){
        
        if(n==s.length()){
            list.add(s);
            return;
        }

        generateBinary(n, s+0,  list);
        generateBinary(n,s+1,  list);

    }
    public String findDifferentBinaryString(String[] nums) {
        List<String> list=new ArrayList<>();
        generateBinary( nums.length,"",  list);

        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i]))
            {
                list.remove(nums[i]);
            }
        }

        return list.get(0);

        
    }
}