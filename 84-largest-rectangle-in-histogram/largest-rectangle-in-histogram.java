class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> st=new Stack<>();


        for(int i=0; i<=n; i++){
            int currHeight=0;
            if(i!=n) currHeight=heights[i];
            else currHeight=0;
            
            while(!st.isEmpty() && currHeight  < heights[st.peek()] ){
                int h=heights[st.pop()];

                int right=i;
                int left=-1;
                if(st.isEmpty()) left=-1;  //wrong index
                else left=st.peek();

                int width=right - left -1;
                maxArea=Math.max(maxArea,h*width);
            }
            st.push(i);

        }

        return maxArea;
    }
}