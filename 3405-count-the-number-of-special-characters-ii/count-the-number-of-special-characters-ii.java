class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> mapLower=new HashMap<>();
        HashMap<Character,Integer> mapUp=new HashMap<>();

        int n=word.length();
        for(int i=0; i<n; i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z') mapLower.put(ch,i);
            if(ch>='A' && ch<='Z'){
                if(mapUp.containsKey(ch)) continue;
                mapUp.put(ch,i);
            }
        }
        
        int special=0;
        for(char ch : mapLower.keySet()){
            char upper=(char)(ch-32);
            
            if(mapUp.containsKey(upper)){
                int getidx=mapUp.get(upper);
                if(mapLower.get(ch)<getidx) special++;
            }
        
            
        }
        return special;

    }
}