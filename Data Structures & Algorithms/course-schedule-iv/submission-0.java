class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Map<Integer,Set<Integer>> preReqs = new HashMap<>();

        int[] inEdges = new int[numCourses];

        for(int[] preReq:prerequisites){
            adj.computeIfAbsent(preReq[0], k -> new ArrayList<>()).add(preReq[1]);
            inEdges[preReq[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inEdges[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nei:adj.getOrDefault(cur, new ArrayList<>())){
                preReqs.computeIfAbsent(nei, h -> new HashSet<>()).add(cur);
                for(int curPreReq:preReqs.getOrDefault(cur, new HashSet<>())){
                    preReqs.get(nei).add(curPreReq);
                }
                inEdges[nei]--;
                if(inEdges[nei] == 0){
                    q.add(nei);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] query: queries){
            res.add(preReqs.getOrDefault(query[1],new HashSet<>()).contains(query[0]));
        }
        return res;

    }
}