import java.util.Arrays;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */

public class Question48_RotateImage {
	public static void main(String[] args) {
		Solution48 solution48 = new Solution48();
		int[][] matrix1 = new int[][]{{1, 2}, {3, 4}};
		int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix3 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int[][] matrix4 = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

		System.out.println(Arrays.deepToString(matrix4));
		solution48.rotate(matrix4);
		System.out.println(Arrays.deepToString(matrix4));
	}
}

class Solution48 {
	public void rotate(int[][] matrix) {
		for(int row = 0; row < (matrix.length + 0.5) / 2; row++) {
			for(int column = row; column < matrix.length - row - 1; column++) {
				int temp = matrix[row][column];
				matrix[row][column] = matrix[matrix.length - column - 1][row];
				matrix[matrix.length - column - 1][row] = matrix[matrix.length - row - 1][matrix.length - column - 1];
				matrix[matrix.length - row - 1][matrix.length - column - 1] = matrix[column][matrix.length - row - 1];
				matrix[column][matrix.length - row - 1] = temp;
			}
		}
	}
}
