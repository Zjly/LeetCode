package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/02 00:10
 */
public class Question1536_排布二进制网格的最少交换次数 {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeros[i]++;
                } else {
                    break;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] < n - i - 1) {
                int p = zeros[i];

                for (int j = i + 1; j < n; j++) {
                    int q = p;
                    p = zeros[j];
                    zeros[j] = q;
                    res++;

                    if (p >= n - i - 1) {
                        zeros[i] = p;
                        break;
                    }
                }
            }
            if (zeros[i] < n - i - 1) {
                return -1;
            }
        }

        return res;
    }

    @Test
    public void test1() {
        int[][] grid = new int[][]{{1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 1}};

        Assertions.assertEquals(4, minSwaps(grid));
    }
}
