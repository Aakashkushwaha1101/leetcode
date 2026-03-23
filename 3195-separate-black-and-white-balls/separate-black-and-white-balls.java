class Solution {
    public long minimumSteps(String s) {

        char[] ch = s.toCharArray();
        int ones = 0;   // number of 1s seen so far
        long count = 0;

        for (char c : ch) {
            if (c == '1') {
                ones++;      // 1 needs to be jumped over by future 0
            } else {
                count += ones; // 0 has to swap past all previous 1s
            }
        }

        return count;
    }
}
    