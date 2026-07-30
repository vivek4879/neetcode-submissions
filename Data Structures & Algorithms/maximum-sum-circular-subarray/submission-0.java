class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int prev = 0;
        int prevMin = 0;
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int total = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            total+=nums[i];
            if(prev>=0){
                prev+=nums[i];
            }
            else{
                prev = nums[i];
            }
            globalMax = Math.max(globalMax,prev);
            if(prevMin>=0){
                prevMin = nums[i];
            }
            else{
                prevMin += nums[i];
            }
            globalMin =Math.min(globalMin,prevMin);
        }
        if(globalMax<=0)return globalMax;
        return Math.max(globalMax,total - globalMin);
    }
}