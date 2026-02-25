class Solution {

    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        
        List<List<Integer>> preStor=new ArrayList<>();

        for(int i=0; i<=31; i++){            //maximum bit till 2 to the power 32 tk jata hai 
            preStor.add(new ArrayList<>());
        }
        
        // group kar rahe hai saare element ko bitcount ke hisab se
        for(int num : arr){
            int count=Integer.bitCount(num);
            preStor.get(count).add(num);        
        }

        int[] ans=new int[n];
        int j=0;

        for(int i=0 ; i<preStor.size(); i++){

            List<Integer> get=preStor.get(i);
            Collections.sort(get);

            for(int numb : get){
                ans[j++]=numb;
            }
        }
        return ans;

        
    }
}