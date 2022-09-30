/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */

public class Question01_08_ZeroMatrixLCCI {
	public static void main(String[] args) {

	}
}

class Solution01_08 {
	public void setZeroes(int[][] matrix) {
		boolean row0 = false, column0 = false;
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				row0 = true;
				break;
			}
		}

		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				column0 = true;
				break;
			}
		}

		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
				    matrix[i][0] = 0;
				    matrix[0][j] = 0;
				}
			}
		}

		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
			    for(int j = 0; j < matrix[0].length; j++) {
			    	matrix[i][j] = 0;
			    }
			}
		}

		for(int j = 1; j < matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
			    for(int i = 0; i < matrix.length; i++) {
			    	matrix[i][j] = 0;
			    }
			}
		}

		if(row0) {
		    for(int i = 0; i < matrix[0].length; i++) {
		    	matrix[0][i] = 0;
		    }
		}

		if(column0) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
