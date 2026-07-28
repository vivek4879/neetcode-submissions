class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<long[]> availableRooms = new PriorityQueue<>((a,b)->a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1]));
        PriorityQueue<long[]> roomsInUse = new PriorityQueue<>((a,b) ->a[1]!=b[1]?Long.compare( a[1],b[1]):Long.compare(a[0],b[0]));

        //roomInUse has room number and time till room occupied
        //availableRooms has room number and time from when room will be available

        Map<Integer,Integer> counts = new HashMap<>();
        for(int i = 0; i< n; i++){
            counts.put(i,0);
            availableRooms.offer(new long[] {i,0});
        }

        for(int[] meet:meetings){
            while(!roomsInUse.isEmpty() && roomsInUse.peek()[1] <= meet[0]){
                long[] freedRoom = roomsInUse.poll();
                availableRooms.offer(freedRoom);
            }
            if(availableRooms.isEmpty()){
                long[] freedRoom = roomsInUse.poll();
                availableRooms.offer(freedRoom);
            }
            long[] topRoom = availableRooms.poll();
            counts.put((int)topRoom[0], counts.getOrDefault((int)topRoom[0],0)+1);
            long duration = (long) meet[1] - meet[0];
            roomsInUse.offer(new long[] {topRoom[0],Math.max(topRoom[1],meet[0]) + duration});
        }

        int res = 0;
        int maxCount = 0;

        for(int i = 0; i < n; i++){
            if(counts.get(i) > maxCount){
                maxCount = counts.get(i);
                res = i;
            }
        }
        return res;
    }
}