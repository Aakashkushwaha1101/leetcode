class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        pq.add(a);
        pq.offer(b);
        pq.offer(c);

        int res=0;
        while(pq.peek()!=0){
            int maxA=pq.poll();
            int maxB=pq.poll();
            if(maxA==0 || maxB==0){
                break;
            }
            else{
                res++;
            }
            pq.offer(maxA-1);
            pq.offer(maxB-1);

        }

        return res;
    }
}