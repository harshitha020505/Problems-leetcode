import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        
        for (int[][] row : dp)
            for (int[] r : row)
                Arrays.fill(r, Integer.MIN_VALUE);

        return helper(coins, dp, m - 1, n - 1, 0);
    }

    public int helper(int[][] coins, int[][][] dp, int i, int j, int used) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;

        if (i == 0 && j == 0) {
            if (coins[0][0] < 0 && used < 2) return 0;
            return coins[0][0];
        }

        if (dp[i][j][used] != Integer.MIN_VALUE)
            return dp[i][j][used];

        int take = Math.max(
            helper(coins, dp, i - 1, j, used),
            helper(coins, dp, i, j - 1, used)
        );

        if (take != Integer.MIN_VALUE)
            take += coins[i][j];

        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && used < 2) {
            skip = Math.max(
                helper(coins, dp, i - 1, j, used + 1),
                helper(coins, dp, i, j - 1, used + 1)
            );
        }

        return dp[i][j][used] = Math.max(take, skip);
    }
}