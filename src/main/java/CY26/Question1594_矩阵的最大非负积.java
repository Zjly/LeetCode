package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/23 22:46
 */
public class Question1594_矩阵的最大非负积 {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        long[][] dpp = new long[m][n];
        long[][] dpn = new long[m][n];
        dpp[0][0] = grid[0][0] >= 0 ? grid[0][0] : -1;
        dpn[0][0] = grid[0][0] < 0 ? grid[0][0] : 1;

        for (int i = 1; i < m; i++) {
            int num = grid[i][0];
            if (num >= 0) {
                dpp[i][0] = dpp[i - 1][0] * num;
                dpn[i][0] = dpn[i - 1][0] * num;
            } else {
                dpp[i][0] = dpn[i - 1][0] * num;
                dpn[i][0] = dpp[i - 1][0] * num;
            }
        }
        for (int i = 1; i < n; i++) {
            int num = grid[0][i];
            if (num >= 0) {
                dpp[0][i] = dpp[0][i - 1] * num;
                dpn[0][i] = dpn[0][i - 1] * num;
            } else {
                dpp[0][i] = dpn[0][i - 1] * num;
                dpn[0][i] = dpp[0][i - 1] * num;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int num = grid[i][j];
                if (num >= 0) {
                    dpp[i][j] = Math.max(dpp[i - 1][j] * num, dpp[i][j - 1] * num);
                    dpn[i][j] = Math.min(dpn[i - 1][j] * num, dpn[i][j - 1] * num);
                } else {
                    dpp[i][j] = Math.max(dpn[i - 1][j] * num, dpn[i][j - 1] * num);
                    dpn[i][j] = Math.min(dpp[i - 1][j] * num, dpp[i][j - 1] * num);
                }
            }
        }

        return dpp[m - 1][n - 1] < 0 ? -1 : Math.toIntExact(dpp[m - 1][n - 1] % MOD);
    }
}
