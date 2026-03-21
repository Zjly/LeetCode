package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/21 23:10
 */
public class Question3643_垂直翻转子矩阵 {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                int p = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
                grid[x + k - 1 - i][y + j] = p;
            }
        }

        return grid;
    }
}
