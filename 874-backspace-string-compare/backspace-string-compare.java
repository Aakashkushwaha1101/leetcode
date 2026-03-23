class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n=s.length();
        int m=t.length();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();

        for(int i=0; i<n; i++){
            if(s.charAt(i)!='#'){
                sb.append(s.charAt(i));
                
            }else if (sb.length() > 0){
                sb.deleteCharAt(sb.length()-1);
            }
        }

        for(int i=0; i<m; i++){
            if(t.charAt(i)!='#'){
                sb1.append(t.charAt(i));
                
            }else if (sb1.length() > 0){
                 sb1.deleteCharAt(sb1.length()-1);
            }
        }

        
        return sb.toString().equals(sb1.toString());
    }
}