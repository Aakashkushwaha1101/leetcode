class Solution {
    public int longestValidParentheses(String s) {

        int n = s.length();
        int maxLen = 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1); // matlab hai ki stack khali h jab hum yhaa pahuchange

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i); // agar valid mil gyaa hoga iske phele to stack khali ho jayega to push kar denge ) isko bhi
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}