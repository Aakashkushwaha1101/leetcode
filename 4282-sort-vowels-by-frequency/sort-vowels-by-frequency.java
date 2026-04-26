class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        String vowel="aeiou";
        int[] hash=new int[5];
        int[] first=new int[5];

        Arrays.fill(first,-1);
        for(int i=0; i<n; i++ ){
            char ch=s.charAt(i);
            int id=vowel.indexOf(ch);

            if(id != -1){
                hash[id]++;  
                if(first[id]==-1) first[id]=i;
            }
        }

        Integer[] order={0,1,2,3,4};
        Arrays.sort(order , (a,b) -> {
            if(hash[b] != hash[a]) return hash[b] - hash[a];
            return first[a] - first[b];
        });

        StringBuilder sortVowel=new StringBuilder();
        for(int idx : order ){
            for(int i=0; i<hash[idx]; i++){
                sortVowel.append(vowel.charAt(idx));
            }
        }

        StringBuilder sb=new StringBuilder(s);
        if(n==1) return s;
        int j=0;
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(vowel.indexOf(ch)!=-1){
                sb.setCharAt(i,sortVowel.charAt(j++));
            }
        }
        return sb.toString();
    }
    
}