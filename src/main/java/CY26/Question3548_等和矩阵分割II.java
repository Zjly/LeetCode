package CY26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Claude Code
 * @version 2026/03/26 23:39
 */
public class Question3548_等和矩阵分割II {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSum = new long[m];
        long[] columnSum = new long[n];
        long sum = 0;

        // 预处理：记录每个值出现的位置
        Map<Integer, List<int[]>> valuePositions = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                columnSum[j] += grid[i][j];
                sum += grid[i][j];
                valuePositions.computeIfAbsent(grid[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // 检查水平分割
        long topSum = 0;
        for (int i = 0; i < m - 1; i++) {
            topSum += rowSum[i];
            long bottomSum = sum - topSum;
            if (canEqualByRemoving(topSum, bottomSum, grid, 0, 0, i, n - 1, i + 1, 0, m - 1, n - 1, valuePositions)) {
                return true;
            }
        }

        // 检查垂直分割
        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) {
            leftSum += columnSum[j];
            long rightSum = sum - leftSum;
            if (canEqualByRemoving(leftSum, rightSum, grid, 0, 0, m - 1, j, 0, j + 1, m - 1, n - 1, valuePositions)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断是否可以通过移除一个单元格使两部分和相等（移除后保持连通）
     */
    private boolean canEqualByRemoving(long sum1, long sum2, int[][] grid,
                                       int r1, int c1, int r2, int c2,
                                       int r3, int c3, int r4, int c4,
                                       Map<Integer, List<int[]>> valuePositions) {
        // 直接相等
        if (sum1 == sum2) {
            return true;
        }

        // 需要从第一部分移除
        if (sum1 > sum2) {
            long diff = sum1 - sum2;
            return canRemoveAndStayConnected(grid, r1, c1, r2, c2, diff, valuePositions);
        }

        // 需要从第二部分移除
        long diff = sum2 - sum1;
        return canRemoveAndStayConnected(grid, r3, c3, r4, c4, diff, valuePositions);
    }

    /**
     * 判断在矩形区域(r1,c1)到(r2,c2)中能否移除一个值为diff的单元格，使剩余部分连通
     */
    private boolean canRemoveAndStayConnected(int[][] grid, int r1, int c1, int r2, int c2, long diff,
                                              Map<Integer, List<int[]>> valuePositions) {
        if (diff > Integer.MAX_VALUE) {
            return false;
        }
        int target = (int)diff;

        List<int[]> positions = valuePositions.get(target);
        if (positions == null) {
            return false;
        }

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // 查找区域内的目标值位置
        for (int[] pos : positions) {
            int pr = pos[0], pc = pos[1];
            if (pr < r1 || pr > r2 || pc < c1 || pc > c2) {
                continue; // 不在区域内
            }

            // 单行区域：只能移除最左或最右
            if (rows == 1) {
                if (pc == c1 || pc == c2) {
                    return true;
                }
                continue;
            }

            // 单列区域：只能移除最上或最下
            if (cols == 1) {
                if (pr == r1 || pr == r2) {
                    return true;
                }
                continue;
            }

            // 多行多列区域：任意位置都可以移除（剩余部分可通过绕行保持连通）
            return true;
        }

        return false;
    }
}
