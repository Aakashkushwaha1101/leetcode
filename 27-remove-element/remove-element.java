class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int count = 0;

        while (i <= j) {
            if (nums[i] != val) {
                i++;
                count++;
            } else if (nums[j] == val) {
                j--;
            } else {
                
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                count++;
            }
        }

        return count;
    }
}