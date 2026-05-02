class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        Map<Integer, Integer> dp = new HashMap<>();
        for(int i = 0; i < n+1;i++){
            int count = 0;
            int cur = i;
            if(!dp.containsKey(i)){
                while(cur >0){
                    if(cur%2 == 1)count++;
                    cur = cur / 2;
                }
                dp.put(i,count);
            }
            res[i] = dp.get(i);
        }
        return res;
    }
}
