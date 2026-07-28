class Solution {
    int result;
    public void backtrack(int[] nums, int i, int path){
        result+=path;
        for(int j = i; j < nums.length; j++){
            path ^= nums[j];
            backtrack(nums,j+1,path);
            path ^= nums[j];;
        }
    }

    public int subsetXORSum(int[] nums) {
        result = 0;
        backtrack(nums,0, 0);
        return result;
    }
}

