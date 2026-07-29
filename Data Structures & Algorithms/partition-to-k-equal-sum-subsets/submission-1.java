class Solution {

    public boolean backtrack(int[] nums, int target, int i, int[] buckets){
        if(i == -1)return true;
        if(nums[i] > target)return false;

        for(int j = 0; j<buckets.length; j++){
            if(buckets[j]+ nums[i] > target)continue;

            buckets[j] += nums[i];
            if(!backtrack(nums,target,i-1,buckets)){
                buckets[j] -= nums[i];
                if(buckets[j] == 0)break;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int total = 0;
        for(int num:nums){
            total+=num;
        }
        if(total % k != 0)return false;
        int target = total / k;
        int[] buckets = new int[k];
        return backtrack(nums,target,nums.length-1, buckets);

    }
}

