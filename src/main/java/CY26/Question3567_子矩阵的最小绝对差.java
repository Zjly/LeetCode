package CY26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3567. 子矩阵的最小绝对差
 * 思路：遍历每个 k×k 子矩阵，收集元素排序后，找相邻元素的最小差值
 *
 * @author ZhangLei
 * @version 2026/03/20 23:39
 */
public class Question3567_子矩阵的最小绝对差 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int rows = m - k + 1;
        int cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = getMinDiff(grid, i, j, k);
            }
        }
        return ans;
    }

    private int getMinDiff(int[][] grid, int startRow, int startCol, int k) {
        List<Integer> list = new ArrayList<>();

        // 收集子矩阵中的所有元素
        for (int i = startRow; i < startRow + k; i++) {
            for (int j = startCol; j < startCol + k; j++) {
                list.add(grid[i][j]);
            }
        }

        // 排序
        Collections.sort(list);

        // 找相邻元素的最小差值
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i - 1))) {
                int diff = list.get(i) - list.get(i - 1);
                minDiff = Math.min(minDiff, diff);
            }
        }

        // 如果所有元素都相同，返回0
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}
