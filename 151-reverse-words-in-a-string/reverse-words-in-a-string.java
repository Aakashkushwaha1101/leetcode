class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim().replaceAll("\\s+"," ");
        Stack<String> st=new Stack<>();

        int i=0,j=0;
        while(i < s.length()){
           
            while(s.charAt(j)!=' ' && j <s.length()-1){
                j++;
            }
            st.add(s.substring(i,j));
            i=j+1;
            j++;
        }
        String newstr=st.pop();
        newstr=newstr+s.charAt(s.length()-1);
        st.add(newstr);

        while(st.size()>1){
            sb.append(st.pop() +" ");
        }
        sb.append(st.pop());
        return sb.toString();//remove extra white space and make one white space btw string
    }

}