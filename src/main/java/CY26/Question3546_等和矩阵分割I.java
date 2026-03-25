package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/25 23:45
 */
public class Question3546_等和矩阵分割I {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSum = new long[m];
        long[] columnSum = new long[n];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                columnSum[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        if (sum % 2 != 0) {
            return false;
        }

        long r = 0;
        for (int i = 0; i < m; i++) {
            r += rowSum[i];
            if (r == sum / 2) {
                return true;
            }
        }

        long c = 0;
        for (int i = 0; i < n; i++) {
            c += columnSum[i];
            if (c == sum / 2) {
                return true;
            }
        }

        return false;
    }
}
