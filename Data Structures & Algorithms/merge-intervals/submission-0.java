class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        Deque<int[]> stack = new ArrayDeque<>();

        for(int[] interval:intervals){
            if(stack.isEmpty()){
                stack.push(interval);
                continue;
            }
            if(stack.peek()[1]>=interval[0]){
                int[] top = stack.pop();
                top[1] = Math.max(interval[1],top[1]);
                stack.push(top);
            }
            else{
                stack.push(interval);
            }
        }

        int[][] res = new int[stack.size()][2];

        for(int i = stack.size()-1; i >=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}