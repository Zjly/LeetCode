/**
 * 1155. 掷骰子等于目标和的方法数
 * 提示
 * 1654
 * 252
 * 第 149 场周赛
 * Q2
 * 相关企业
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * 示例 3：
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 109 + 7 取模。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */

public class Question1155_掷骰子等于目标和的方法数 {
}

/**
 * @author Zhang Lei
 * @date 2023/10/24 22:47
 */
class Solution1155 {
    public int numRollsToTarget(int n, int k, int target) {
        long MOD = 1000000007;
        long[] dp = new long[target + 1];

        k = Math.min(k, target);
        for (int i = 1; i <= k; i++) {
            dp[i] = 1;
        }

        for (int index = 1; index < n; index++) {
            long[] dp2 = new long[target + 1];
            for (int num = 1; num <= k; num++) {
                for (int currentTarget = num + 1; currentTarget <= target; currentTarget++) {
                    dp2[currentTarget] = (dp2[currentTarget] + dp[currentTarget - num]) % MOD;
                }
            }

            dp = dp2;
        }

        return (int)(dp[target] % MOD);
    }
}