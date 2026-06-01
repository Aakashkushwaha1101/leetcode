class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        
       if(n==1) return cost[0];
       if(n==2) return cost[0]+cost[1];

       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       for(int num : cost) pq.offer(num);

       int minCost=0;
        while(!pq.isEmpty()){
            if(!pq.isEmpty())
            minCost +=pq.poll();
            if(!pq.isEmpty()) 
            minCost +=pq.poll();

            pq.poll();
        }
        

        return minCost;
    }
}