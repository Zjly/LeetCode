/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * <p>
 * 示例 1：
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * <p>
 * 示例 3：
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 * <p>
 * 提示：
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */

public class Question1074_NumberOfSubmatricesThatSumToTarget {
	public static void main(String[] args) {
		Solution1074 solution1074 = new Solution1074();
		int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
		int target = 3;
		System.out.println(solution1074.numSubmatrixSumTarget(matrix, target));
	}
}

class Solution1074 {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int count = 0;

		// 计算原矩阵的前缀和
		int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				sumMatrix[i + 1][j + 1] = matrix[i][j] + sumMatrix[i][j + 1];
			}
		}

		// 固定横坐标，对纵坐标进行遍历
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix.length; j++) {
				int[] sumColumn = new int[matrix[0].length];
				for(int k = 0; k < matrix[0].length; k++) {
					sumColumn[k] = sumMatrix[j + 1][k + 1] - sumMatrix[i][k + 1];
				}

				int[] sumSumColumn = new int[matrix[0].length + 1];
				// 遍历数组sumColumn，和为target时即为答案
				for(int k = 0; k < matrix[0].length; k++) {
					sumSumColumn[k + 1] = sumSumColumn[k] + sumColumn[k];
				}

				for(int k = 0; k < matrix[0].length; k++) {
					for(int l = k; l < matrix[0].length; l++) {
						if(sumSumColumn[l + 1] - sumSumColumn[k] == target) {
							count++;
						}
					}
				}
			}
		}

		return count;
	}
}