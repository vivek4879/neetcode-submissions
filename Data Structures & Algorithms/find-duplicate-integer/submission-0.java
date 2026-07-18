class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums[0];
        int r = nums[0];
        int n = nums.length;
        do{
            l = nums[l];
            r = nums[nums[r]];
        }while(l != r);
        
        l = nums[0];
        while(l!= r){
            l = nums[l];
            r = nums[r];
        }
        return r;
    }
}


