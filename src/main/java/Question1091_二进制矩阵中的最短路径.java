import java.util.ArrayDeque;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 */

public class Question1091_二进制矩阵中的最短路径 {
}

class Solution1091 {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid[0][0] == 1) {
			return -1;
		}

		ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
		arrayDeque.offer(new int[]{0, 0});
		int step = 1;
		int[] dirs = {-1, 0, 1};

		while(!arrayDeque.isEmpty()) {
		    int size = arrayDeque.size();
			for(int i = 0; i < size; i++) {
				int[] point = arrayDeque.poll();

				// end
				if(point[0] == grid.length - 1 && point[1] == grid[0].length - 1) {
				    return step;
				}

				for(int dirX : dirs) {
					for(int dirY : dirs) {
						int x = point[0] + dirX;
						int y = point[1] + dirY;
						if(valid(grid, x, y)) {
						    arrayDeque.offer(new int[]{x, y});
							grid[x][y] = 1;
						}
					}
				}
			}

			step++;
		}

		return -1;
	}

	private boolean valid(int[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
	}
}