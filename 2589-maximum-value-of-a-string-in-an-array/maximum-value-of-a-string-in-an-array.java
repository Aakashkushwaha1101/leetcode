class Solution {
    public int maximumValue(String[] strs) {
        int n=strs.length;
        int maxLen=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            String temp=strs[i];
            int len=temp.length();
            int num=0;
            boolean isNumeric=true;
            for(int j=0; j<len; j++){
                char ch=temp.charAt(j);
                if(ch >= 'a' && ch <= 'z'){
                    isNumeric=false;
                    break;
                }
                else{
                   num = num*10 + (ch-'0');
                }
            }
            if(isNumeric)
            maxLen=Math.max(maxLen,num);
            else  maxLen=Math.max(maxLen,temp.length());
        }

        return maxLen;
    }
}