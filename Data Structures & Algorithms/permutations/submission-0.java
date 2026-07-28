class Solution {

    public void backTrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] inPath){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int j = 0; j < nums.length; j++){
            if(inPath[j])continue;
            inPath[j] = true;;
            path.add(nums[j]);
            backTrack(nums,res,path, inPath);
            path.remove(path.size()-1);
            inPath[j] = false;
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] inPath = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, res ,new ArrayList<>(), inPath);
        return res;
    }
}