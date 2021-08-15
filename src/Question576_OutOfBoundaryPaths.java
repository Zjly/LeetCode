/**
 * 576. 出界的路径数
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 * <p>
 * 提示：
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */

public class Question576_OutOfBoundaryPaths {
	public static void main(String[] args) {

	}
}

class Solution576 {
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int count = 0;
		int[][] dp = new int[m][n];
		final int MOD = 1000000007;
		dp[startRow][startColumn] = 1;

		for(int i = 0; i < maxMove; i++) {
			int[][] ndp = new int[m][n];

			for(int row = 0; row < m; row++) {
				for(int column = 0; column < n; column++) {
					int num = dp[row][column];
					if(num != 0) {
					    if(row == 0) {
					        count = (count + num) % MOD;
					    } else {
					        ndp[row - 1][column] = (ndp[row - 1][column] + num) % MOD;
					    }

						if(row == m - 1) {
							count = (count + num) % MOD;
						} else {
							ndp[row + 1][column] = (ndp[row + 1][column] + num) % MOD;
						}

						if(column == 0) {
							count = (count + num) % MOD;
						} else {
							ndp[row][column - 1] = (ndp[row][column - 1] + num) % MOD;
						}

						if(column == n - 1) {
							count = (count + num) % MOD;
						} else {
							ndp[row][column + 1] = (ndp[row][column + 1] + num) % MOD;
						}
					}
				}
			}

			dp = ndp;
		}

		return count;
	}
}
