class Solution {
    public int bitwiseComplement(int n) {
        int m=n;
        int mask=0;
        if(n==0){
            return 1;
        }
        while(m != 0){
            mask=(mask << 1) | 1; //left shift by 1 and use or oprator
            m=m>>1; //right shift by 1;
        }
        int complement= (~n) & mask; 
        return complement;
    }
}