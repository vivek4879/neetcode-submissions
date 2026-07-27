class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> maxProfits = new PriorityQueue<>((a,b) -> Integer.compare(b[2],a[2]));
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));

        int curProjects = 0;

        for(int i = 0; i < capital.length; i++){
            minCapital.add(new int[] {i,capital[i],profits[i]});
        }
        while(curProjects< k){
            while(!minCapital.isEmpty() && minCapital.peek()[1] <= w){
                maxProfits.offer(minCapital.poll());
            }
            if(maxProfits.isEmpty())break;
            int[] topProfit = maxProfits.poll();
            w += topProfit[2];
            curProjects++;
        }
        return w;
    }
}
