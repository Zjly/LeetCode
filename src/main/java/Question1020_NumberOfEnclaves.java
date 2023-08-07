/**
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 */

public class Question1020_NumberOfEnclaves {
	public static void main(String[] args) {

	}
}

class Solution1020 {
	public int numEnclaves(int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			paint(grid, i, 0);
			paint(grid, i, grid[0].length - 1);
		}

		for(int i = 0; i < grid[0].length; i++) {
			paint(grid, 0, i);
			paint(grid, grid.length - 1, i);
		}

		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
				    count++;
				}
			}
		}

		return count;
	}

	public void paint(int[][] grid, int x, int y) {
		if(x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && grid[x][y] == 1) {
			grid[x][y] = 2;
			paint(grid, x - 1, y);
			paint(grid, x + 1, y);
			paint(grid, x, y - 1);
			paint(grid, x, y + 1);
		}
	}
}