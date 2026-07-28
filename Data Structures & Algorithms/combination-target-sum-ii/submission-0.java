class Solution {
    List<List<Integer>> res;
    int curSum;
    public void backTrack(int[] candidates, int target, int i, List<Integer> path){
        if(curSum > target)return;
        if(curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if( j > i && candidates[j] == candidates[j-1])continue;
            if(curSum + candidates[j] >target)break;
            path.add(candidates[j]);
            curSum+= candidates[j];
            backTrack(candidates,target, j+1, path);
            curSum -= candidates[j];
            path.remove(path.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        curSum = 0;
        res = new ArrayList<>();
        backTrack(candidates,target, 0, new ArrayList<>());
        return res;
    }
}