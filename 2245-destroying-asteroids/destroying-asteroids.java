class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);

        //bug ye tha ki sum krne pr int overflow jaa rhaa hai 
        long currMass=mass;
        for(int i=0; i<n; i++){
            if(asteroids[i]<=currMass){
                currMass +=asteroids[i];
            }else{
                return false;
            }
        }

        return true;
    }
}