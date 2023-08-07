import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 827. 最大人工岛
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 */

public class Question827_MakingALargeIsland {
	public static void main(String[] args) {
		Solution827 solution827 = new Solution827();
		int[][] grid = {{1, 1}, {1, 0}};
		System.out.println(solution827.largestIsland(grid));
	}
}

class Solution827 {
	HashMap<Integer, Integer> colorCount = new HashMap<>();

	public int largestIsland(int[][] grid) {
		int color = 2;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j, color);
					color++;
				}
			}
		}

		int maxArea = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				// 转变0的格子
				if(grid[i][j] == 0) {
					// 遍历四个方向
					int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
					Set<Integer> colorArea = new HashSet<>();
					for(int[] dir : dirs) {
						int x = i + dir[0];
						int y = j + dir[1];
						if(valid(grid, x, y)) {
							colorArea.add(grid[x][y]);
						}
					}

					int area = 0;
					for(int c : colorArea) {
						area += colorCount.getOrDefault(c, 0);
					}
					maxArea = Math.max(area + 1, maxArea);
				} else {
					maxArea = Math.max(maxArea, colorCount.getOrDefault(grid[i][j], 0));
				}
			}
		}

		return maxArea;
	}

	public void dfs(int[][] grid, int row, int column, int color) {
		if(!valid(grid, row, column) || grid[row][column] != 1) {
			return;
		}

		grid[row][column] = color;
		colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
		dfs(grid, row + 1, column, color);
		dfs(grid, row - 1, column, color);
		dfs(grid, row, column + 1, color);
		dfs(grid, row, column - 1, color);
	}

	public boolean valid(int[][] grid, int row, int column) {
		return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
	}
}