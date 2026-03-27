package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/27 23:21
 */
public class Question2946_循环移位后的矩阵相似检查 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;

        for (int i = 0; i < m; i++) {
            int beginIndex = i % 2 != 0 ? k : n - k;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + beginIndex) % n]) {
                    return false;
                }
            }
        }

        return true;
    }
}
