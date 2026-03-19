package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/19 23:35
 */
public class Question3212_统计X和Y频数相等的子矩阵数量 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpx = new int[m + 1][n + 1];
        int[][] dpy = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                dpx[i + 1][j + 1] = dpx[i][j + 1] + dpx[i + 1][j] - dpx[i][j] + (c == 'X' ? 1 : 0);
                dpy[i + 1][j + 1] = dpy[i][j + 1] + dpy[i + 1][j] - dpy[i][j] + (c == 'Y' ? 1 : 0);
                if (dpx[i + 1][j + 1] == dpy[i + 1][j + 1] && dpx[i + 1][j + 1] != 0) {
                    res++;
                }
            }
        }

        return res;
    }

    @Test
    public void test1() {
        char[][] grid = new char[][]{{'X', 'Y', '.'}, {'Y', '.', '.'}};
        Assertions.assertEquals(3, numberOfSubmatrices(grid));
    }
}
