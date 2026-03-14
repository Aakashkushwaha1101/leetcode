class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int n=fruits.length;
        int place=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(fruits[i] <= baskets[j] ){
                    place +=1;
                    baskets[j] =0;
                    break;
                }
            }
        }

        return n-place;
    }
}