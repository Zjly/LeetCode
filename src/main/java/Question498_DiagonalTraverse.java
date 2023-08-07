/**
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */

public class Question498_DiagonalTraverse {
	public static void main(String[] args) {

	}
}

class Solution498 {
	public int[] findDiagonalOrder(int[][] mat) {
		int row = 0;
		int column = 0;
		boolean dir = true;

		int[] result = new int[mat.length * mat[0].length];
		for(int i = 0; i < result.length; i++) {
			result[i] = mat[row][column];
			
			if(dir) {
			    if(column + 1 >= mat[0].length) {
			        row = row + 1;
				    dir = false;
			    } else if(row - 1 < 0) {
			        column = column + 1;
				    dir = false;
			    } else {
				    row = row - 1;
					column = column + 1;
			    }
			} else {
				if(row + 1 >= mat.length) {
					column = column + 1;
					dir = true;
				} else if(column - 1 < 0) {
				    row = row + 1;
					dir = true;
				} else {
				    column = column - 1;
					row = row + 1;
				}
			}
		}

		return result;
	}
}