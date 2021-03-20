/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 示例 2:
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */

public class Question73_SetMatrixZeroes {
	public static void main(String[] args) {

	}
}

class Solution73 {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		boolean colZero = false;
		boolean rowZero = false;

		for(int i = 0; i < row; i++) {
			if(matrix[i][0] == 0) {
				colZero = true;
				break;
			}
		}

		for(int j = 0; j < column; j++) {
			if(matrix[0][j] == 0) {
				rowZero = true;
				break;
			}
		}

		for(int i = 1; i < row; i++) {
			for(int j = 1; j < column; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}

		for(int i = 1; i < row; i++) {
			for(int j = 1; j < column; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if(colZero) {
			for(int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
		if(rowZero) {
			for(int j = 0; j < column; j++) {
				matrix[0][j] = 0;
			}
		}
	}
}