class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] low=new boolean[26];
        boolean[] up=new boolean[26];

        for(char ch : word.toCharArray()){
            if(ch>='a' && ch<='z') low[ch-'a']=true;
            if(ch>='A' && ch<='Z') up[ch-'A']=true;
        }

        int special=0;
        for(int i=0; i<26; i++){
            if(low[i]==true && up[i]==true) special++;
        }

        return special;
    }
}