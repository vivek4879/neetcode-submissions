class Solution {
    List<List<Integer>> res;
    public void backTrack(int[] nums, int k, int i, List<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < nums.length; j++){
            path.add(nums[j]);
            backTrack(nums,k,j+1,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        res = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            nums[i] = i+1;
        }
        backTrack(nums,k,0,new ArrayList<>());
        return res;

    }
}

