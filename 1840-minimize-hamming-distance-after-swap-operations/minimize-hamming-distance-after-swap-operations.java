class Solution {
    private int misMatched(int[] src, int[] target ,List<Integer> Index){
        Map<Integer,Integer> srcMap=new HashMap<>();
        Map<Integer,Integer> targetMap=new HashMap<>();

        for(int idx : Index){
            srcMap.put(src[idx],srcMap.getOrDefault(src[idx],0)+1);
            targetMap.put(target[idx],targetMap.getOrDefault(target[idx],0)+1);
        }

        int matches=0;
        for(int val : srcMap.keySet()){
            if(targetMap.containsKey(val)){
                //to hm min isiliye le rahe kyuki freq of same element jo min hogi vhi common hogi dono me
                /* 
                    Component indices: {0, 1, 2}

                    source = [5, 5, 3]  (at these indices)
                    target = [5, 3, 3]  (at these indices)

                    Frequency count:
                    sourceFreq: {5: 2, 3: 1}
                    targetFreq: {5: 1, 3: 2}
                */
                matches += Math.min(srcMap.get(val), targetMap.get(val));
            }
        }

        return Index.size()-matches;

    }
    private List<Integer> dfs(int src,List<List<Integer>> adjList,boolean[] visited,List<Integer> connectedIndex){
        visited[src]=true;
        connectedIndex.add(src);

        for(int neigh : adjList.get(src)){
            if(!visited[neigh]){
                dfs(neigh,adjList,visited,connectedIndex);
            }
        }
        return connectedIndex;

    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // graph --> relationship or connections  between indices by swaping
        int n=source.length;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<allowedSwaps.length; i++){
            int u=allowedSwaps[i][0];
            int v=allowedSwaps[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] vis=new boolean[n];
        int hammingDist=0;
        for(int i=0; i<n; i++){
            List<Integer> connectedIndex=new ArrayList<>();
            if(!vis[i]){
                dfs(i,adjList,vis, connectedIndex);

                hammingDist += misMatched(source,target,connectedIndex);
            }

            


        }

        return hammingDist;
    }
}