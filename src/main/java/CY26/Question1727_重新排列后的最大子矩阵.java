package CY26;

import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2026/03/17 22:01
 */
public class Question1727_重新排列后的最大子矩阵 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] heights = new int[m][n];
        for (int column = 0; column < n; column++) {
            for (int row = 0; row < m; row++) {
                if (row == 0) {
                    heights[row][column] = matrix[row][column];
                } else {
                    heights[row][column] = matrix[row][column] == 0 ? 0 : heights[row - 1][column] + 1;
                }
            }
        }

        int res = 0;
        for (int row = 0; row < m; row++) {
            int[] rows = heights[row];
            Arrays.sort(rows);
            int count = 0;
            int min = 100000;
            for (int column = n - 1; column >= 0; column--) {
                if (heights[row][column] != 0) {
                    count++;
                    min = Math.min(min, heights[row][column]);
                    res = Math.max(res, count * min);
                }
            }
        }

        return res;
    }
}
