class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length-1;
        int i = nums.length-1;
        while(i>=0){
            if(nums[i]+i >= destination){
                destination = i;   
            }
            i--;
        }

        return destination ==0;
    }
}

