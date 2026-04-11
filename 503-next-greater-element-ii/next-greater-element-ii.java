class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            nge[i] = -1; // nhi mila nge to -1  hi rahega
            for (int j = 1; j < n; j++) {           
                int next = nums[(i + j) % n];        // circular indexing handle kar rhe h
                if (next > nums[i]) {
                    nge[i] = next;
                    break;
                }
            }
        }

        return nge;
    }
}