class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int stone:stones){
            pq.offer(stone);
        }

        while(!pq.isEmpty()){
            int first = pq.poll();
            if(pq.isEmpty())return first;
            int second = pq.poll();
            if(first < second){
                pq.offer(second-first);
            }
            else if(first> second){
                pq.offer(first-second);
            }
        }
        if(!pq.isEmpty())return pq.peek();
        return 0;

    }
}