class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        int[][] queriesCopy = new int[m][2];

        for(int i = 0; i < m; i++){
            queriesCopy[i] = new int[] {i,queries[i]};
        }
        int[] res = new int[m];
        Arrays.sort(queriesCopy,(a,b)-> Integer.compare(a[1],b[1]));
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));
        int i = 0;
        for(int[] query:queriesCopy){
            int cur = query[1];

            while( i < n && cur >=intervals[i][0]){
                int size = intervals[i][1]-intervals[i][0]+1;
                minHeap.offer(new int[] {intervals[i][0],intervals[i][1],size});
                i++;
            }
            while(!minHeap.isEmpty() && cur > minHeap.peek()[1]){
                minHeap.poll();
            }
            if(minHeap.isEmpty())res[query[0]] = -1;
            else{
                res[query[0]] = minHeap.peek()[2];
            }
        }
        return res;
    }
}