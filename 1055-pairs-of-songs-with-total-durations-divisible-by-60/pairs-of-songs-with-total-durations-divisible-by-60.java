class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n=time.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int pair=0;

        for(int i=0; i<n; i++){
            int mod=time[i]%60;
            int need=60-mod;
            if(mod==0) need=0;
            
            if(map.containsKey(need)){
                pair +=map.get(need);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
        } 

        return pair;
    }
}