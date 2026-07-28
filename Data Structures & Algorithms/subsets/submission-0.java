class Solution {
    List<List<Integer>> res;
    public void backTrack(int[] nums, int i, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int j = i; j < nums.length; j++){
            path.add(nums[j]);
            backTrack(nums,j+1,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>());
        return res;
    }
}