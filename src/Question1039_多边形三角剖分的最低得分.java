/**
 * 1039. 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * <p>
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * <p>
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 */

public class Question1039_多边形三角剖分的最低得分 {
	public static void main(String[] args) {

	}
}

class Solution1039 {
	public int minScoreTriangulation(int[] values) {
		int[][] dp = new int[values.length][values.length];

		// 将dp数组中的值全部初始化为最大值
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp.length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		// 初始化dp数组中的对角线上的值
		for(int i = 0; i < dp.length; i++) {
			dp[i][(i + 1) % dp.length] = 0;
		}

		// 从下往上，从左往右遍历dp数组
		for(int i = dp.length - 1; i >= 0; i--) {
			for(int j = i + 2; j < dp.length; j++) {
				// 从i到j的最小值
				for(int k = i + 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
				}
			}
		}

		return dp[0][dp.length - 1];
	}
}
