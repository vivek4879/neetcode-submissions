class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));

        Map<Character,Integer> counts = new HashMap<>();

        for(char c:tasks){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        for(Map.Entry entry:counts.entrySet()){
            pq.offer(new int[] {(char)entry.getKey() - 'A',(int)entry.getValue()});
        }

        Queue<int[]> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            int idx = res.size();
            while(!q.isEmpty() && q.peek()[1] <= idx){
                int[] top = q.remove();
                pq.offer(new int[] {top[0],top[2]});
            }
            if(!pq.isEmpty()){
                int[] cur = pq.remove();
                res.add(cur[0]);
                cur[1] = cur[1] - 1;
                if(cur[1] > 0){
                    q.add(new int[] {cur[0], idx+n+1, cur[1]});
                }
            }
            else{
                res.add(-1);
            }
        }
        return res.size();

    }
}