class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();

        for(char ch : s.toCharArray()){

            if(!st.isEmpty()){
                char chr=st.peek();
                if((chr=='(' && ch==')') || (chr=='[' && ch==']')|| (chr=='{' && ch=='}')){
                    st.pop();
                }
                else{
                    st.push(ch);
                }


            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}