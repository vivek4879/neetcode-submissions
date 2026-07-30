class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int prev = 0;
        for(int i = 0; i<nums.length;i++){
            if(i == 0){
                prev = nums[i];
            }
            else if(prev < 0){
                prev = nums[i];
            }
            else{
                prev+=nums[i];
            }
            res = Math.max(res,prev);
        }
        return res;
    }
}