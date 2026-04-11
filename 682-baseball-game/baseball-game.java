class Solution {
    public int calPoints(String[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(String s : arr){
            if(s.equals("C")) st.pop();

            else if(s.equals("D")) st.push(2*st.peek());
            else if(s.equals("+")){
                int first=st.pop();
                int second=st.peek();
                st.push(first);
                st.push(first + second);
            }
            else st.push(Integer.parseInt(s));
        }
        int ans=0;
        while(!st.isEmpty()){
            ans =ans + st.pop();
        }
        return ans;
    }
}