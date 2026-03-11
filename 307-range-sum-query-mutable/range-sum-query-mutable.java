class NumArray {
    static long segT[];
    static int n;
    private void build(int idx,int l,int r,int[] nums){
        if(l==r){
            segT[idx]=nums[l];
            return;
        }
        int mid=l+ (r - l)/2;
        build(2*idx+1,l,mid,nums);
        build(2*idx+2,mid+1,r,nums);

        segT[idx]=segT[2*idx+1] + segT[2*idx+2];
    }

    private void updatE(int i,int val, int l,int r,int idx){
        if(l==r){
            segT[idx]=val;
            return;
        }

        int mid=l+ (r - l)/2;
        if(i<=mid){
            updatE(i,val,l,mid,2*idx+1);
        }else{
            updatE(i,val,mid+1,r,2*idx+2);
        }

        segT[idx] = segT[2*idx+1] + segT[2*idx+2];

    }
    private int query(int ql,int qr, int l,int r,int idx){
        if(qr < l || r < ql) return 0;
        if(ql <=l && r <=qr) return (int)segT[idx];

        int mid=l+ (r - l)/2;
        int left=query(ql,qr,l,mid,2*idx+1);
        int right=query(ql,qr,mid+1,r,2*idx+2);

        return left + right;
    }

    public NumArray(int[] nums) {
        n=nums.length;
        segT=new long[4*n];

        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updatE(index,val,0,n-1,0);
    }
    
    public int sumRange(int left, int right) {
        return query(left,right,0,n-1,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */