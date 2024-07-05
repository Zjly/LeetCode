/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3033. 修改矩阵
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * <p>
 * 返回矩阵 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * 输出：[[1,2,9],[4,8,6],[7,8,9]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * - 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
 * - 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[3,-1],[5,2]]
 * 输出：[[3,2],[5,2]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 2 <= m, n <= 50
 * -1 <= matrix[i][j] <= 100
 * 测试用例中生成的输入满足每列至少包含一个非负整数。
 */

public class Question3033_修改矩阵 {
}

/**
 * @author Zhang Lei
 * @date 2024/7/5 下午10:52
 */
class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[] max = new int[column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                max[i] = Math.max(max[i], matrix[j][i]);
            }
        }

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = max[i];
                }
            }
        }

        return matrix;
    }
}