class Solution {

    private String reverse(StringBuilder s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return invert(sb.toString());
    }

    private String invert(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                sb.append('1');   
            } else {
                sb.append('0');   
            }
        }

        return sb.toString();
    }

    public char findKthBit(int n, int k) {

        if (n == 1) return '0';

        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for (int i = 1; i < n; i++) {
            String str = reverse(sb);
            sb.append("1");
            sb.append(str);
        }

        return sb.charAt(k - 1);
    }
}