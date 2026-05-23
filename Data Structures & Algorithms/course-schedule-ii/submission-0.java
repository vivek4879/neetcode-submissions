class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inInd = new int[numCourses];
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] pre:prerequisites){
            int src = pre[1];
            int des = pre[0];
            adj.computeIfAbsent(src, k -> new ArrayList<>()).add(des);
            inInd[des]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inInd[i] == 0)q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.remove();
            res.add(cur);
            for(int nei:adj.computeIfAbsent(cur, k -> new ArrayList<>())){
                inInd[nei]--;
                if(inInd[nei] == 0){
                    q.add(nei);
                }
            }
        }
        if(res.size() != numCourses)return new int[] {};
        int[] res1 = new int[res.size()];

        for(int i = 0; i < res.size(); i++){
            res1[i] = res.get(i);
        }
        return res1;
    }
}
