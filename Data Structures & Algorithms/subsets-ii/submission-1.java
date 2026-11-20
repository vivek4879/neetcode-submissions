class Solution {

    public void backTrack(int[] nums,List<List<Integer>> res, int i, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int j = i; j < nums.length; j++){
            if(j != i && nums[j] == nums[j-1])continue;
            path.add(nums[j]);
            backTrack(nums, res,j+1,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,res,0, new ArrayList<>());
        return res;
    }
}