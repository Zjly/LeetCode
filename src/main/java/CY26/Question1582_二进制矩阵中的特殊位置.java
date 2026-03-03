package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/04 00:06
 */
public class Question1582_二进制矩阵中的特殊位置 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] locationM = new int[m];
        int[] locationN = new int[n];
        for (int i = 0; i < m; i++) {
            int location = -1;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (location == -1) {
                        location = j;
                    } else {
                        location = -1;
                        break;
                    }
                }
            }
            locationM[i] = location;
        }

        for (int i = 0; i < n; i++) {
            int location = -1;
            for (int j = 0; j < m; j++) {
                if (mat[j][i] == 1) {
                    if (location == -1) {
                        location = j;
                    } else {
                        location = -1;
                        break;
                    }
                }
            }
            locationN[i] = location;
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            if (locationM[i] != -1 && locationN[locationM[i]] != -1) {
                res++;
            }
        }

        return res;
    }

    @Test
    public void test1() {
        int[][] mat = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        Assertions.assertEquals(1, numSpecial(mat));
    }
}
