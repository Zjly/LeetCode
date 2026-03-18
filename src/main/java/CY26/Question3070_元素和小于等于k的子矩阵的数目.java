package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/18 23:31
 */
public class Question3070_元素和小于等于k的子矩阵的数目 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + grid[i][j];
                dp[i + 1][j + 1] = value;
                if (value <= k) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
