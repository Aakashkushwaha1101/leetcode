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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();

        
    }
}