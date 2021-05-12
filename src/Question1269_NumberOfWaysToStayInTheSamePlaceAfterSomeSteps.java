/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * 示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>
 * 示例 2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * <p>
 * 示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * 提示：
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 */

public class Question1269_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
	public static void main(String[] args) {
		Solution1269 solution1269 = new Solution1269();
		int steps = 6;
		int arrlen = 2;
		System.out.println(solution1269.numWays(steps, arrlen));
	}
}

class Solution1269 {
	public int numWays(int steps, int arrLen) {
		if(arrLen > steps / 2 + 2) {
			arrLen = steps / 2 + 2;
		}

		long[][] dp = new long[2][arrLen + 2];

		int location = 0;
		dp[location][1] = 1;
		dp[location][2] = 1;

		for(int i = 1; i < steps; i++) {
			for(int j = 1; j <= arrLen; j++) {
				long dpt = dp[location][j - 1] + dp[location][j] + dp[location][j + 1];
				if(dpt >= 1000000007) {
					dpt = dpt % 1000000007;
				}
				dp[location ^ 1][j] = dpt;
			}
			location = location ^ 1;
		}

		return (int)dp[location][1];
	}
}