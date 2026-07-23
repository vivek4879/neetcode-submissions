class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            int curDist =(point[0]*point[0]+ point[1]*point[1]);
            pq.offer(new int[] {curDist,i});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];

        int i = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            res[i] = points[cur[1]];
            i++;
        }
        return res;
    }
}