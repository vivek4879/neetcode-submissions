class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        int curCapacity = capacity;

        for(int[] trip:trips){
            int curStart = trip[1];
            while(!pq.isEmpty() && pq.peek()[2]<= curStart){
                int[] topTrip = pq.poll();
                curCapacity += topTrip[0];
            }
            if(trip[0] > curCapacity)return false;
            curCapacity-= trip[0];
            pq.offer(trip);
        }

        return true;
    }
}