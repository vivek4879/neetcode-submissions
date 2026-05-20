class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] costs = new int[n];

        costs[0] = cost[0];
        costs[1] = cost[1];

        for(int i = 2; i < n; i++){
            costs[i] = Math.min(costs[i-1], costs[i-2]) + cost[i];
        }
        return Math.min(costs[n-1],costs[n-2]);
    }
}

// 1,2,4,2