class Solution {
    
    // private boolean allCodes(String s, int len,String original){
    //     if(s.length()==len){
    //        if(original.contains(s)){
    //             return true;
    //        } 
    //        return false;
    //     }
    //     boolean zero=allCodes(s+0,len,original);
    //     boolean one=allCodes(s+1,len,original);

    //     return zero && one;
    // }
    public boolean hasAllCodes(String s, int k) {
        // return allCodes(st,"",k,s);
        
        Set<String> st=new HashSet<>();

        for(int i=0; i+k<=s.length(); i++){
            st.add(s.substring(i,i+k));
        }

        if(st.size()==Math.pow(2,k)){
            return true;
        }

        return false;

    }
}