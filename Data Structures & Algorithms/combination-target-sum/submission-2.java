class Solution {
    List<List<Integer>> res;
    int curSum;
    public void backTrack(int[] candidates, int i, List<Integer> path, int target){
        if(curSum > target)return;
        if(curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if (curSum + candidates[j] > target)break;
            path.add(candidates[j]);
            curSum += candidates[j];
            backTrack(candidates, j,path,target);
            curSum -= candidates[j];
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        curSum = 0;
        backTrack(candidates, 0, new ArrayList<>(), target);

        return res;

    }
}
