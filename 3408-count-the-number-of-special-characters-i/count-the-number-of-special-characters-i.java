class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set=new HashSet<>();
        Set<Character> set2=new HashSet<>();

        int n=word.length();
        for(int i=0; i<n; i++){
            char ch=word.charAt(i);
            if(ch>='A' && ch<='Z') set.add(ch);
            if(ch>='a' && ch<='z') set2.add(ch);

        }
        
        int special=0;
        for(char ch : set2){
            char capital= Character.toUpperCase(ch);
            if(!set.contains(capital)) continue;
            special++;
        }

        return special;
    }
}