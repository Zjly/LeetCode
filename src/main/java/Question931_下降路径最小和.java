import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */

public class Question931_下降路径最小和 {
	Solution931 solution931 = new Solution931();

	@Test
	public void test() {
		int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
		Assertions.assertEquals(13, solution931.minFallingPathSum(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = {{-48}};
		Assertions.assertEquals(-48, solution931.minFallingPathSum(matrix));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/7/13 23:12
 */
class Solution931 {
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int fallingPathSum = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			int x = i + 1;
			for (int j = 0; j < n; j++) {
				int minNum = Integer.MAX_VALUE;
				for (int y = j - 1; y <= j + 1; y++) {
					if (valid(n, x, y)) {
						minNum = Math.min(minNum, matrix[x][y]);
					}
				}

				if (minNum != Integer.MAX_VALUE) {
					matrix[i][j] += minNum;
				}

				if (i == 0) {
					fallingPathSum = Math.min(fallingPathSum, matrix[i][j]);
				}
			}
		}

		return fallingPathSum;
	}

	private boolean valid(int n, int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}