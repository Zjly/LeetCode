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

import java.util.ArrayList;
import java.util.List;

public class Question1380_LuckyNumbersInAMatrix {
	public static void main(String[] args) {
		Solution1380 solution1380 = new Solution1380();
		int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
		System.out.println(solution1380.luckyNumbers(matrix));
	}
}

class Solution1380 {
	public List<Integer> luckyNumbers(int[][] matrix) {
		ArrayList<int[]> rowValueIndexArrayList = new ArrayList<>();
		ArrayList<int[]> columnValueIndexArrayList = new ArrayList<>();

		for(int i = 0; i < matrix.length; i++) {
			int minValue = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] < minValue) {
					minValue = matrix[i][j];
					minIndex = j;
				}
			}

			rowValueIndexArrayList.add(new int[]{minValue, minIndex});
		}

		for(int i = 0; i < matrix[0].length; i++) {
			int maxValue = Integer.MIN_VALUE;
			int maxIndex = 0;
			for(int j = 0; j < matrix.length; j++) {
				if(matrix[j][i] > maxValue) {
					maxValue = matrix[j][i];
					maxIndex = j;
				}
			}

			columnValueIndexArrayList.add(new int[]{maxValue, maxIndex});
		}

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < rowValueIndexArrayList.size(); i++) {
			int[] rowValueIndex = rowValueIndexArrayList.get(i);
			int rowValue = rowValueIndex[0];
			int rowIndex = rowValueIndex[1];

			int[] columnValueIndex = columnValueIndexArrayList.get(rowIndex);
			int columnValue = columnValueIndex[0];
			int columnIndex = columnValueIndex[1];

			if(rowValue == columnValue && columnIndex == i) {
				list.add(rowValue);
			}
		}

		return list;
	}
}