package CY26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhangLei
 * @version 2026/03/16 23:39
 */
public class Question1878_矩阵中最大的三个菱形和 {
    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;
        int r = Math.min(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < r; k++) {
                    int left = j - k;
                    int right = j + k;
                    int up = i - k;
                    int down = i + k;
                    if (!valid(left, right, up, down, m, n)) {
                        break;
                    }

                    // 计算菱形边界和
                    int sum;
                    if (k == 0) {
                        sum = grid[i][j];
                    } else {
                        sum = 0;
                        // 遍历菱形的四条边
                        for (int d = 0; d <= k; d++) {
                            // 上顶点 -> 左顶点
                            sum += grid[i - k + d][j - d];
                            // 上顶点 -> 右顶点
                            sum += grid[i - k + d][j + d];
                            // 左顶点 -> 下顶点
                            sum += grid[i + k - d][j - d];
                            // 右顶点 -> 下顶点
                            sum += grid[i + k - d][j + d];
                        }
                        // 四个顶点被重复计算了一次，需要减去
                        sum -= grid[i - k][j];     // 上顶点
                        sum -= grid[i + k][j];     // 下顶点
                        sum -= grid[i][j - k];     // 左顶点
                        sum -= grid[i][j + k];     // 右顶点
                    }
                    set.add(sum);
                }
            }
        }

        // 取前三大
        List<Integer> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        int size = Math.min(3, list.size());
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean valid(int left, int right, int up, int down, int m, int n) {
        return left >= 0 && right < n && up >= 0 && down < m;
    }
}
