package leetcode;

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int x : coins) {
                if (x>i)
                    break;
                dp[i] = Math.min(dp[i - x] + 1,dp[i]);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
