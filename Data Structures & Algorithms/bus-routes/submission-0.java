class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
         Map<Integer, List<Integer>> adj = new HashMap<>();
        if(source == target) return 0;
        for(int i = 0; i < routes.length;i++){
            int[]route = routes[i];
            for(int stop:route){
                adj.computeIfAbsent(stop,k -> new ArrayList<>()).add(i);
            }
        }
        int res = 1;
        Queue<Integer> q = new ArrayDeque<>();

        for(int route: adj.getOrDefault(source, new ArrayList<>())){
            q.add(route);
        }

        boolean[] seen = new boolean[routes.length];
        boolean[] visitedStops = new boolean[100001];
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i< qSize; i++){
                int curRoute = q.remove();
                if(seen[curRoute])continue;
                seen[curRoute] = true;
                for(int stop:routes[curRoute]){
                    if(stop == target)return res;
                    if(visitedStops[stop])continue;
                    visitedStops[stop] = true;
                    for(int route: adj.get(stop)){
                        if(!seen[route])q.add(route);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}