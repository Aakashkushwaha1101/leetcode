class Solution {
    private void reverse(char[] arr,int i,int j){

        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public String reverseStr(String s, int k) {
        int i=0;
        char[] ch=s.toCharArray();
        if(ch.length <= k){
            reverse(ch,i,ch.length-1);
            return new String(ch);
        } 
        while(i<=ch.length-1){
            int j=Math.min(i+k-1,ch.length-1);
            reverse(ch,i,j);
            i=i+2*k;
        }

        return new String(ch);
        
    }
}