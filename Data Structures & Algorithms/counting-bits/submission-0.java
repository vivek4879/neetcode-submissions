class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];

        for(int i = 0; i < n+1;i++){
            int count = 0;
            int cur = i;
            while(cur >0){
                if(cur%2 == 1)count++;
                cur = cur / 2;
            }
            res[i] = count;
        }
        return res;
    }
}
