class Solution {
    public int compress(char[] chars) {
        if(chars.length==1) return 1;
        int i=0;
        int j=0;
       StringBuilder sb=new StringBuilder();

        while(j<chars.length){
            if(chars[i]==chars[j]){
                j++;
            }else{
                int len=j-i;
                if(len!=1){
                    sb.append(chars[i]);
                    sb.append(len);
                }else{
                    sb.append(chars[i]);
                }
                i=j;
            }
        }
        int remaining=j-i;
        
        if(remaining!=1){
            sb.append(chars[i]);
            sb.append(remaining);
        }
        else{
            sb.append(chars[i]);
        }

        for(int k = 0; k < sb.length(); k++){
            chars[k] = sb.charAt(k);
        }
        return sb.length();
    }
}