class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int dp(int n){
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(!map.containsKey(n)){
            map.put(n, dp(n/2) + n % 2);
        }
        return map.get(n);
    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i<=n;i++){
            res[i] = dp(i);
        }
        return res;
    }
}
