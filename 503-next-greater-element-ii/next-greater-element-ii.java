class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st=new Stack<>();

        // int  maxElem=Integer.MIN_VALUE;
        // int idx=-1;
        // for(int i=0; i<n; i++){
        //    if( maxElem < nums[i]){
        //          maxElem=nums[i];
        //          idx=i;
        //    }
        // }

        // st.push(maxElem);

        for(int i=n-1; i>=0; i--){
            st.push(nums[i]);;
        }
        int[] nge=new int[n];
        // nge[idx]=-1;

        for(int i=n-1; i>=0; i--){    //last se chalenge
            if(!st.isEmpty()){

                if(st.peek() > nums[i]){
                    nge[i]=st.peek();
                    st.push(nums[i]);
                }
                else{

                    while((!st.isEmpty()) && nums[i] >= st.peek()){
                        st.pop();
                    }

                    if(!st.isEmpty()){
                        nge[i]=st.peek();
                        st.push(nums[i]);
                    }else{
                        nge[i]=-1;
                        st.push(nums[i]);
                    }
                }
                
            }
            // else{
            //     st.push(nums[i]);
            // }
        }
        return nge;
    }
}