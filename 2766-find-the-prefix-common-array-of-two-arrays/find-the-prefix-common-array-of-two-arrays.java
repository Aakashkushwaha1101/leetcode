class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int ans[]=new int[n];

        int k=0;
        for(int i=0; i<n; i++){
            int count=0;
            Set<Integer> set=new HashSet<>();
            for(int j=i; j>=0; j--){
                set.add(B[j]);
            }
            for(int j=i; j>=0; j--){
                if(set.contains(A[j])) count++;
            }
            ans[k++]=count;
        }

        return ans;
    }
}