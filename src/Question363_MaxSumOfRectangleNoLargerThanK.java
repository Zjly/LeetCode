/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * <p>
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 */

public class Question363_MaxSumOfRectangleNoLargerThanK {
	public static void main(String[] args) {

	}
}

class Solution363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		int column = matrix[0].length;

		int[][] sum = new int[row + 1][column + 1];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				sum[i + 1][j + 1] = matrix[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
			}
		}

		int maxResult = Integer.MIN_VALUE;

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				for(int m = i; m < row; m++) {
					for(int n = j; n < column; n++) {
						int p = sum[m + 1][n + 1] - sum[m + 1][j] - sum[i][n + 1] + sum[i][j];
						if(p <= k) {
							maxResult = Math.max(maxResult, p);
						}
					}
				}
			}
		}

		return maxResult;
	}
}
