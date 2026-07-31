class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int curFuel = 0;
        int res = 0;

        for(int i =0; i<gas.length; i++){
            curFuel += gas[i] -cost[i];
            totalFuel+= gas[i] -cost[i];

            if(curFuel < 0){
                res = i+1;
                curFuel = 0;
            }
        }

        return totalFuel<0?-1:res;
    }
}
