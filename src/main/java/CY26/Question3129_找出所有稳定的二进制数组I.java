package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/09 22:31
 */
public class Question3129_找出所有稳定的二进制数组I {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final long MOD = 1000000007;

        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (i >= limit + 1) {
                    dp[i][j][0] = dp[i][j][0] - dp[i - limit - 1][j][1] + MOD;
                }
                dp[i][j][0] = dp[i][j][0] % MOD;

                dp[i][j][1] = dp[i][j - 1][0] + dp[i][j - 1][1];
                if (j >= limit + 1) {
                    dp[i][j][1] = dp[i][j][1] - dp[i][j - limit - 1][0] + MOD;
                }
                dp[i][j][1] = dp[i][j][1] % MOD;
            }
        }

        long res = (dp[zero][one][0] + dp[zero][one][1]) % MOD;
        return Math.toIntExact(res);
    }

    @Test
    public void test1() {
        Assertions.assertEquals(2, numberOfStableArrays(1, 1, 2));
    }
}
