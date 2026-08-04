class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        dp[0] = 0;

        for(int i = 1; i< dp.length;i++){
            for(int coin:coins){
                if(coin > i)continue;
                dp[i] = Math.min(dp[i], dp[i-coin]);
            }
            dp[i]++;
        }

        return dp[dp.length-1]>amount?-1:dp[dp.length-1];
    }
}


// dp[amount] = The min number of coins we will need for amount

// dp[0] = 0;

// dp[amount] = min(dp[amount-coins[i]])+1
