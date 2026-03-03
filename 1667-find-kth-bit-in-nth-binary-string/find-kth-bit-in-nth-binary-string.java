class Solution {
    private String reverse(String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=n-1; i>=0; i--){
            char ch=s.charAt(i);
            sb.append(ch);
        }
        String str=invert(sb.toString());
        return str;
    }
    private String invert(String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n ; i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                sb.append(1);
            
            }else{
                sb.append(0);
            }

        }
        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        if(n==1) return '0';

        String s="0";
        for(int i=1; i<n; i++){
            String str=reverse(s);
            s += "1";
            s +=str;
        }
        char ans=s.charAt(k-1);
        return ans;



    }
}