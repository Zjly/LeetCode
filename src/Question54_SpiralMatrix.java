import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

public class Question54_SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Solution54 solution54 = new Solution54();
		System.out.println(solution54.spiralOrder(matrix));
	}
}

class Solution54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();

		int distance = 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int count = row * column;

		while(result.size() != count) {
			for(int i = distance; i <= column - 1 - distance; i++) {
				result.add(matrix[distance][i]);
			}

			if(result.size() == count) {
				break;
			}

			for(int i = 1 + distance; i <= row - 1 - distance; i++) {
				result.add(matrix[i][column - 1 - distance]);
			}

			if(result.size() == count) {
				break;
			}

			for(int i = column - 2 - distance; i >= distance; i--) {
				result.add(matrix[row - 1 - distance][i]);
			}

			if(result.size() == count) {
				break;
			}

			for(int i = row - 2 - distance; i >= 1 + distance; i--) {
				result.add(matrix[i][distance]);
			}

			distance++;
		}

		return result;
	}
}
