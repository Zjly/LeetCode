package CY26;

import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2026/04/02 23:23
 */
public class Question3418_机器人可以获得的最大金币数 {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int counts = 3;

        int[][][] dp = new int[m + 1][n + 1][counts];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < counts; j++) {
                dp[i][0][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < counts; j++) {
                dp[0][i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < counts; i++) {
            dp[0][1][i] = 0;
            dp[1][0][i] = 0;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int coin = coins[i][j];
                for (int k = 0; k < counts; k++) {
                    dp[i + 1][j + 1][k] = Math.max(dp[i + 1][j][k], dp[i][j + 1][k]) + coin;
                }
                if (coin < 0) {
                    for (int k = 0; k < counts - 1; k++) {
                        dp[i + 1][j + 1][k + 1] = Math.max(Math.max(dp[i + 1][j][k], dp[i][j + 1][k]),
                                dp[i + 1][j + 1][k + 1]);
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < counts; i++) {
            res = Math.max(dp[m][n][i], res);
        }

        return res;
    }
}
