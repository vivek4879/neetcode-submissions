class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int l = 0;
        int r = 0;
        int res = 0;
        while( l<= r && r <nums.length){
            minPq.add(new int[] {nums[r],r});
            maxPq.add(new int[] {nums[r],r});
            int curDiff = Math.abs(minPq.peek()[0] - maxPq.peek()[0]);
            while(curDiff > limit){
                if(minPq.peek()[1] < maxPq.peek()[1]){
                    int[] cur = minPq.remove();
                    l = cur[1] + 1;
                }
                else if(minPq.peek()[1] >= maxPq.peek()[1]){
                    int[] cur = maxPq.remove();
                    l = cur[1]+1;
                }
                while (!minPq.isEmpty() && minPq.peek()[1] < l) minPq.poll();
                while (!maxPq.isEmpty() && maxPq.peek()[1] < l) maxPq.poll();
                curDiff = Math.abs(maxPq.peek()[0] - minPq.peek()[0]);
            }
            res = Math.max(res,r-l+1);
            r++;

        }
        return res;
    }
}