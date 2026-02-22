class Solution {
    public int binaryGap(int n) {
        int count = Integer.bitCount(n);
        if (count <= 1) return 0;

        String binary = Integer.toBinaryString(n);
        int len = binary.length();

        int prevIdx = -1;
        int maxGap = 0;

        for (int i = 0; i < len; i++) {
            if (binary.charAt(i) == '1') {
                if (prevIdx != -1) {
                    maxGap = Math.max(maxGap, i - prevIdx);
                }
                prevIdx = i;
            }
        }

        return maxGap;
    }
}