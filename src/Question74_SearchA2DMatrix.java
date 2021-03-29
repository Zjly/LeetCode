/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class Question74_SearchA2DMatrix {
	public static void main(String[] args) {

	}
}

class Solution74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int column = matrix[0].length;
		int left = 0;
		int right = row * column - 1;
		int mid;
		int num;

		while(left <= right) {
		    mid = (left + right) / 2;
		    num = matrix[mid / column][mid % column];
		    if(num == target) {
		        return true;
		    } else if(num < target) {
		        left = mid + 1;
		    } else if(num > target) {
		        right = mid - 1;
		    }
		}

		return false;
	}
}