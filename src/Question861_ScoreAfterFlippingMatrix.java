/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * 提示：
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */

public class Question861_ScoreAfterFlippingMatrix {
	public static void main(String[] args) {
		int[][] A = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
		Solution861 solution861 = new Solution861();

		System.out.println(solution861.matrixScore(A));
	}
}

class Solution861 {
	public int matrixScore(int[][] A) {
		int score = (int)(A.length * Math.pow(2, A[0].length - 1));

		for(int[] row : A) {
			if(row[0] == 0) {
				for(int column = 0; column < row.length; column++) {
					row[column] = row[column] ^ 1;
				}
			}
		}

		for(int column = 1; column < A[0].length; column++) {
			int zeroCount = 0;
			int oneCount = 0;
			for(int[] row : A) {
				if(row[column] == 0) {
					zeroCount += 1;
				} else {
					oneCount += 1;
				}
			}

			for(int[] row : A) {
				if(zeroCount > oneCount) {
					row[column] = row[column] ^ 1;
				}
				if(row[column] == 1) {
					score += (int)(Math.pow(2, A[0].length - column - 1));
				}
			}
		}

		return score;
	}
}
