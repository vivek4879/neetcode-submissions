class Solution {
    public boolean backtrack(int i, int[] sides,int[] matchsticks,int target){
        if(i == -1)return true;
        if(matchsticks[i] >target){
            return false;
        }
        for(int j = 0; j < 4;j++){
            if(sides[j] + matchsticks[i] > target){
                continue;
            }
            sides[j] = sides[j] + matchsticks[i];
            if(!backtrack(i-1,sides,matchsticks,target)){
                sides[j] = sides[j] - matchsticks[i];
            }
            else{
                return true;
            }
        }
        return false;

    }
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        int target = 0;

        int total = 0;

        for(int stick:matchsticks){
            total+=stick;
        }

        if(total%4 != 0)return false;
        target = total/4;

        return backtrack(matchsticks.length-1, sides,matchsticks,target);
    }
}
