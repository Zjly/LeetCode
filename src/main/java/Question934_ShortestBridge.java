import java.util.*;

/**
 * 934. 最短的桥
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 */

public class Question934_ShortestBridge {
	public static void main(String[] args) {
		Solution934 solution934 = new Solution934();
		int[][] grid = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
		System.out.println(solution934.shortestBridge(grid));
	}
}

class Solution934 {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int shortestBridge(int[][] grid) {
		boolean filled = false;
		Set<int[]> boundaries = new HashSet<>();
		for(int i = 0; i < grid.length; i++) {
			if(filled) {
				break;
			}
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					fillColor(grid, boundaries, i, j);
					filled = true;
					break;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>(boundaries);

		int minLength = 0;
		while(!queue.isEmpty()) {
			minLength++;

			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] boundary = queue.poll();
				int x = boundary[0];
				int y = boundary[1];

				for(int[] dir : dirs) {
					int nx = x + dir[0];
					int ny = y + dir[1];

					if(valid(grid, nx, ny)) {
						if(grid[nx][ny] == 1) {
							return minLength;
						} else if(grid[nx][ny] == 0) {
							grid[nx][ny] = -1;
							queue.offer(new int[]{nx, ny});
						}
					}
				}
			}
		}

		return minLength;
	}

	public void fillColor(int[][] grid, Set<int[]> boundaries, int x, int y) {
		grid[x][y] = -1;

		for(int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if(valid(grid, nx, ny)) {
				if(grid[nx][ny] == 1) {
					fillColor(grid, boundaries, nx, ny);
				} else if(grid[nx][ny] == 0) {
					boundaries.add(new int[]{nx, ny});
				}
			}
		}
	}

	public boolean valid(int[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}
}