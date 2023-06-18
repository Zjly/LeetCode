import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1254. 统计封闭岛屿的数目
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */

public class Question1254_统计封闭岛屿的数目 {
	Solution1254 solution1254 = new Solution1254();

	@Test
	public void test() {
		int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
		Assertions.assertEquals(2, solution1254.closedIsland(grid));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/6/18 12:06
 */
class Solution1254 {
	public int closedIsland(int[][] grid) {
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		for (int i = 0; i < grid.length; i++) {
			dfs(grid, dirs, i, 0);
			dfs(grid, dirs, i, grid[0].length - 1);
		}
		for (int j = 0; j < grid[0].length; j++) {
			dfs(grid, dirs, 0, j);
			dfs(grid, dirs, grid.length - 1, j);
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					count++;
					dfs(grid, dirs, i, j);
				}
			}
		}

		return count;
	}

	private void dfs(int[][] grid, int[][] dirs, int x, int y) {
		if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
			grid[x][y] = 1;
			for (int[] dir : dirs) {
				dfs(grid, dirs, x + dir[0], y + dir[1]);
			}
		}
	}
}