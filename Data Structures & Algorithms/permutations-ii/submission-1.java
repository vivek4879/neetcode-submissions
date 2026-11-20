class Solution {

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] inPath){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i >0 && nums[i-1]==nums[i] && !inPath[i-1])continue;
            if(inPath[i])continue;
            inPath[i] = true;
            path.add(nums[i]);
            backtrack(nums,res,path,inPath);
            inPath[i] = false;
            path.remove(path.size()-1);

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] inPath = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,res,new ArrayList<>(),inPath);
        return res;

    }
}