class Solution {
    private boolean isPalindrome(int i, int j,String s){
        if(i>=j){
            return true;
        }

        if(s.charAt(i)==s.charAt(j)){
            boolean temp=isPalindrome(i+1,j-1,s);
            return temp;
        }
        return false;
    }
    public int countSubstrings(String s) {

        int len=0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(i,j,s)) len++;
            }
        }

        return len;
        
    }
}