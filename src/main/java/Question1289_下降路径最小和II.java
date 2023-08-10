/**
 * 1289. 下降路径最小和 II
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */

public class Question1289_下降路径最小和II {
}

/**
 * @author Zhang Lei
 * @date 2023/8/10 22:24
 */
class Solution1289 {
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;

        int minValue = 0;
        int minValueIndex = -1;
        int nextMinValue = 0;

        for (int i = 0; i < grid.length; i++) {
            int currentMinValue = Integer.MAX_VALUE;
            int currentMinValueIndex = -1;
            int currentNextMinValue = Integer.MAX_VALUE;

            for (int j = 0; j < grid[0].length; j++) {
                if (j != minValueIndex) {
                    grid[i][j] += minValue;
                } else {
                    grid[i][j] += nextMinValue;
                }

                int value = grid[i][j];
                if (value <= currentMinValue) {
                    currentNextMinValue = currentMinValue;
                    currentMinValue = value;
                    currentMinValueIndex = j;
                } else if (value <= currentNextMinValue) {
                    currentNextMinValue = value;
                }

                if (i == grid.length - 1) {
                    minSum = Math.min(minSum, value);
                }
            }

            minValue = currentMinValue;
            minValueIndex = currentMinValueIndex;
            nextMinValue = currentNextMinValue;
        }

        return minSum;
    }
}