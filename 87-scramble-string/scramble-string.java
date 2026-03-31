class Solution {
    HashMap<String,Boolean> hs=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        if(s1.length()<=1 || s2.length()<= 1) return false;

       

        String key=s1 + " "+s2;
        if(hs.containsKey(key)) return hs.get(key);

       
        int n=s1.length();
       
        for(int i=1 ; i<n ; i++){
            //swap
            if(isScramble(s1.substring(0,i),s2.substring(n-i)) && 
                                isScramble(s1.substring(i),s2.substring(0,n-i))){
                                    hs.put(key , true);
                                    return true;
                                }
            //no swap
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && 
                                isScramble(s1.substring(i),s2.substring(i))){
                                    hs.put(key,true);
                                    return true ;
                                }
        }
        hs.put(key,false);
        return false;
    }
}