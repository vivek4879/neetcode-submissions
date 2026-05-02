class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        Map<Integer,Integer> shortest = new HashMap<>();
        for(int i = 0; i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(List<Integer> edge: edges){
            int sr = edge.get(0);
            int de = edge.get(1);
            int we = edge.get(2);
            adj.get(sr).add(new int[] {de,we});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {src,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w1 = curr[1];
            int node = curr[0];
            if(shortest.containsKey(node))continue;
            shortest.put(node,w1);
            for(int[] neis:adj.get(node)){
                int nei = neis[0];
                int neiW = neis[1];
                if (!shortest.containsKey(nei)) pq.offer(new int[] {nei,neiW+w1});
            }
        }
        for(int i = 0;i <n;i++){
            if(!shortest.containsKey(i))shortest.put(i,-1);
        }
        return shortest;
    }  
}
