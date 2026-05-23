class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inIndex = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] pre:prerequisites){
            int src = pre[1];
            int des = pre[0];
            map.computeIfAbsent(src,k -> new ArrayList<>()).add(des);
            inIndex[des]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(inIndex[i] == 0){
                q.add(i);
            }
        }

        Set<Integer> seen = new HashSet<>();
        while(!q.isEmpty()){
            int cur = q.remove();
            seen.add(cur);
            for(int nei:map.computeIfAbsent(cur, k-> new ArrayList<>())){
                inIndex[nei]--;
                if(inIndex[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return seen.size() == numCourses;
    }
}
