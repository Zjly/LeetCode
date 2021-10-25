/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */

public class Question240_SearchA2DMatrixII {
	public static void main(String[] args) {

	}
}

class Solution240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		return search(matrix, target, 0, 0, matrix.length, matrix[0].length);
	}

	public boolean search(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
		if(x1 > x2 || y1 > y2) {
		    return false;
		}

		if(x1 < 0 || x2 < 0 || x1 >= matrix.length || x2 >= matrix.length || y1 < 0 || y2 < 0 || y1 >= matrix[0].length || y2 >= matrix[0].length) {
		    return false;
		}

		if(x1 == x2 && y1 == y2) {
			return matrix[x1][y1] == target;
		}

		int xMid = (x1 + x2) / 2;
		int yMid = (y1 + y2) / 2;

		if(matrix[xMid][yMid] > target) {
			return search(matrix, target, x1, y1, xMid - 1, yMid - 1) || search(matrix, target, x1, yMid, xMid - 1, y2) || search(matrix, target, xMid, y1, x2, yMid - 1);
		} else if(matrix[xMid][yMid] < target) {
			return search(matrix, target, xMid + 1, yMid + 1, x2, y2) || search(matrix, target, x1, yMid + 1, xMid, y2) || search(matrix, target, xMid + 1, y1, x2, yMid);
		} else {
			return true;
		}
	}
}