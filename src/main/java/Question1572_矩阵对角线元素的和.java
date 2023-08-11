/**
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */


public class Question1572_矩阵对角线元素的和 {
}

/**
 * @author Zhang Lei
 * @date 2023/8/11 23:03
 */
class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int length = mat.length;
        for (int i = 0; i < length; i++) {
        	int j = length - i - 1;
            sum += mat[i][i];
            if (i != j) {
                sum += mat[i][j];
            }
        }

        return sum;
    }
}