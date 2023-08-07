/**
 * 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 */

public class Question1582_SpecialPositionsInABinaryMatrix {
	public static void main(String[] args) {
		Solution1582 solution1582 = new Solution1582();
		int[][] mat = {{0, 0, 0, 0, 0, 1, 0, 0}
				, {0, 0, 0, 0, 1, 0, 0, 1}
				, {0, 0, 0, 0, 1, 0, 0, 0}
				, {1, 0, 0, 0, 1, 0, 0, 0}
				, {0, 0, 1, 1, 0, 0, 0, 0}};
		System.out.println(solution1582.numSpecial(mat));
	}
}

class Solution1582 {
	public int numSpecial(int[][] mat) {
		int row = mat.length;
		int column = mat[0].length;
		int[] rowSum = new int[row];
		int[] colSum = new int[column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				rowSum[i] += mat[i][j];
				colSum[j] += mat[i][j];
			}
		}

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
					count++;
				}
			}
		}

		return count;
	}
}