package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/22 19:01
 */
public class Question1886_判断矩阵经轮转后是否一致 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (equal(mat, target)) {
                return true;
            }

            rotate(mat);
        }

        return false;
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < (n + 0.5) / 2; row++) {
            for(int column = row; column < n - row - 1; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[n - column - 1][row];
                matrix[n - column - 1][row] = matrix[n - row - 1][n - column - 1];
                matrix[n - row - 1][n - column - 1] = matrix[column][n - row - 1];
                matrix[column][n - row - 1] = temp;
            }
        }
    }

    private boolean equal(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
