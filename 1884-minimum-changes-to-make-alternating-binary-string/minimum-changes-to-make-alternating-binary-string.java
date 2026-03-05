class Solution {
    public int minOperations(String s) {

        int n = s.length();
        int start0 = 0; // pattern starting with '0'
        int start1 = 0; // pattern starting with '1'

        for(int i = 0; i < n; i++){

            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0) start0++;
            if(s.charAt(i) != expected1) start1++;
        }

        return Math.min(start0, start1);
    }
}