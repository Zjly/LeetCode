import java.util.Arrays;

/**
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * <p>
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * <p>
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 */

public class Question1034_ColoringABorder {
	public static void main(String[] args) {
		Solution1034 solution1034 = new Solution1034();
		int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int row = 1;
		int col = 1;
		int color = 2;
		System.out.println(Arrays.deepToString(solution1034.colorBorder(grid, row, col, color)));
	}
}

class Solution1034 {
	final int BORDER = -1;
	final int ARRIVED = 0;
	int NEED;

	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
		NEED = grid[row][col];
		dfs(grid, row, col);

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == -1) {
					grid[i][j] = color;
				}
				if(grid[i][j] == 0) {
					grid[i][j] = NEED;
				}
			}
		}

		return grid;
	}

	public void dfs(int[][] grid, int row, int col) {
		grid[row][col] = ARRIVED;

		int count = 0;
		if(inBorder(grid, row - 1, col) && (grid[row - 1][col] == NEED || grid[row - 1][col] == ARRIVED || grid[row - 1][col] == BORDER)) {
			count++;
			if(grid[row - 1][col] == NEED) {
				dfs(grid, row - 1, col);
			}
		}

		if(inBorder(grid, row + 1, col) && (grid[row + 1][col] == NEED || grid[row + 1][col] == ARRIVED || grid[row + 1][col] == BORDER)) {
			count++;

			if(grid[row + 1][col] == NEED) {
				dfs(grid, row + 1, col);
			}
		}

		if(inBorder(grid, row, col - 1) && (grid[row][col - 1] == NEED || grid[row][col - 1] == ARRIVED || grid[row][col - 1] == BORDER)) {
			count++;

			if(grid[row][col - 1] == NEED) {
				dfs(grid, row, col - 1);
			}
		}

		if(inBorder(grid, row, col + 1) && (grid[row][col + 1] == NEED || grid[row][col + 1] == ARRIVED || grid[row][col + 1] == BORDER)) {
			count++;

			if(grid[row][col + 1] == NEED) {
				dfs(grid, row, col + 1);
			}
		}

		if(count != 4) {
			grid[row][col] = BORDER;
		}
	}

	public boolean inBorder(int[][] grid, int row, int col) {
		if(row < 0 || row >= grid.length) {
			return false;
		}
		if(col < 0 || col >= grid[0].length) {
			return false;
		}

		return true;
	}
}
