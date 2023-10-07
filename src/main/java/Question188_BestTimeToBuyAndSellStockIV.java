import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */

public class Question188_BestTimeToBuyAndSellStockIV {
    Solution188_2 solution188_2 = new Solution188_2();

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        Assertions.assertEquals(6, solution188_2.maxProfit(k, prices));
    }

    @Test
    public void test2() {
        int[] prices = {1};
        int k = 2;
        Assertions.assertEquals(0, solution188_2.maxProfit(k, prices));
    }
}

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }

        k = Math.min(k, prices.length / 2);

        int[][][] dp = new int[prices.length][k + 1][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int j = 1; j < k + 1; j++) {
            dp[0][j][0] = Integer.MIN_VALUE / 2;
            dp[0][j][1] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int result = 0;
        for (int j = 0; j < k + 1; j++) {
            if (dp[prices.length - 1][j][0] > result) {
                result = dp[prices.length - 1][j][0];
            }
        }

        return result;
    }
}

class Solution188_2 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length][2][k];

        for (int i = 0; i < k; i++) {
            dp[0][0][i] = -prices[0];
            dp[0][1][i] = 0;
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] + prices[i]);

            for (int j = 1; j < k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] - prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] + prices[i]);
            }
        }

        return dp[prices.length - 1][1][k - 1];
    }
}