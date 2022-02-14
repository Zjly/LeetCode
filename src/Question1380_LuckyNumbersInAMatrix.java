/**
 * 1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 */

import java.util.HashMap;
import java.util.List;

public class Question1380_LuckyNumbersInAMatrix {
	public static void main(String[] args) {

	}
}

class Solution1380 {
	public List<Integer> luckyNumbers(int[][] matrix) {
		HashMap<Integer, Integer> rowValueIndexHashMap = new HashMap<>();
		HashMap<Integer, Integer> columnValueIndexHashMap = new HashMap<>();

		for(int i = 0; i < matrix.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] < min) {
					min = matrix[i][j];
					minIndex = j;
				}
			}

			rowValueIndexHashMap.put(min, minIndex);
		}

		for(int i = 0; i < matrix[0].length; i++) {
			int maxValue = Integer.MIN_VALUE;
			int maxIndex = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] < maxValue) {
					maxValue = matrix[i][j];
					maxIndex = j;
				}
			}
		}
	}
}