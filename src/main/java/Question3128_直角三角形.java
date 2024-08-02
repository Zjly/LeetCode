/**
 * 3128. 直角三角形
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维 boolean 矩阵 grid 。
 * <p>
 * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
 * <p>
 * 注意：
 * <p>
 * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 0	1	0
 * 0	1	1
 * 0	1	0
 * 0	1	0
 * 0	1	1
 * 0	1	0
 * 输入：grid = [[0,1,0],[0,1,1],[0,1,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 有 2 个直角三角形。
 * <p>
 * 示例 2：
 * <p>
 * 1	0	0	0
 * 0	1	0	1
 * 1	0	0	0
 * 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 没有直角三角形。
 * <p>
 * 示例 3：
 * <p>
 * 1	0	1
 * 1	0	0
 * 1	0	0
 * 1	0	1
 * 1	0	0
 * 1	0	0
 * 输入：grid = [[1,0,1],[1,0,0],[1,0,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 有两个直角三角形。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 1000
 * 1 <= grid[i].length <= 1000
 * 0 <= grid[i][j] <= 1
 */

/**
 * @author ZhangLei
 * @version 2024/08/02 21:24
 */
public class Question3128_直角三角形 {
}

class Solution3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += (long)(rows[i] - 1) * (cols[j] - 1);
                }
            }
        }

        return ans;
    }
}