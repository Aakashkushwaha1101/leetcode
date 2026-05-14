class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();

        int[] ans=new int[n-k+1]; //window yhii tkk move hogi to itne hi milega ans
        int l=0;
        for(int i=0; i<n; i++){

            //yhaa hum window ko maintain kar rahe last index htaa de rahe hai if window invalid ho
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            //still hum monotonic decreasing maintain kar rahe to agar hum koi greater element paate hai current me to hme isase cchote vaale hatane honge , so that we can maintain decreasing order
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            }

            //simply push element at last matlab rear end se element ko dalenge deque me
            dq.offerLast(i);

            //dq hum maitain kar rahe decreasing order me to hmesha max element first pe milega
            if(i >= k-1){
                ans[l++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}