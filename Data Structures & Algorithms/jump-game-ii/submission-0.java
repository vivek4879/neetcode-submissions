class Solution {
    public int backtrack(int[] nums, int i, int[] memo){
        if(i >= nums.length-1){
            
            return 0;
        }
        if(memo[i]!=-1){
            
            return memo[i];
        }

        int cur = Integer.MAX_VALUE;
        for(int j = 1; j<nums[i]+1; j++){
            int curResult = backtrack(nums,i+j,memo);
            if(curResult != Integer.MAX_VALUE){
                cur = Math.min(cur, 1 + curResult);
            }
        }
        memo[i] = cur;
        return memo[i];
    }
    public int jump(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return backtrack(nums,0,memo);
    }
}

// memo -> -1 -1 -1 -1 -1
// index-> 0.  1  2. 3. 4
// nums -> 2   3  1. 1. 4


    // BT(i = 0)
    // cur = mv
    // j = 1 2
    // curRe = BT(1)
    // cur = mv
    // j = 1 2 3
    // curRe = BT(2);
    // cur = mv
    // j = 1
    // curRe = BT(3)
    // cur = mv
    // j = 1 2 3
    // curRe = BT(4) returns 0






