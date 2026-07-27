class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int res = 0;

        int[] last = null;
        for(int[] interval:intervals){
            if(last == null){
                last = interval;
                continue;
            }
            if(interval[0] < last[1]){
                res++;
                continue;
            }
            last = interval;
        }
        return res;
    }
}


// 1,2 1,3 2,3 3,4
