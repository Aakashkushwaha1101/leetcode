class Solution {
    private int grammer(int n,int k,int mid){
        if(n==1) return 0;
        
        if(k<=mid) return grammer(n-1,k,mid/2);
        
        int ans=grammer(n-1,k-mid,mid/2);
        
        return 1-ans; //complement
         
    }
    public int kthGrammar(int n, int k) {
        int mid=(int) Math.pow(2,n-1)/2;

        return grammer(n,k,mid);
    }
   
}