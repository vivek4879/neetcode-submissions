class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]!= b[2]?Integer.compare(a[2],b[2]):Integer.compare(a[0],b[0]));

        int[][] copy = new int[tasks.length][3];
        for(int i = 0; i < tasks.length;i++){
            copy[i] = (new int[] {i,tasks[i][0], tasks[i][1]}); //index,startTime,totalTime
        }
        Arrays.sort(copy,(a,b) -> a[1]!= b[1]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));

        int curIndex = 0;
        int[] res = new int[tasks.length];
        long curTime = 1;
        int index = 0;
        while(curIndex<copy.length || !pq.isEmpty()){
            while(curIndex<copy.length && copy[curIndex][1]<=curTime){
                pq.offer(copy[curIndex]);
                curIndex++;
            }
            if(!pq.isEmpty() && pq.peek()[1] <=curTime){
                int[] cur = pq.poll();
                res[index] = cur[0];
                index++;
                curTime+= cur[2];
            }else if(curIndex<copy.length){
                curTime = copy[curIndex][1];
                continue;
            }
        }
        return res;
    }
}

