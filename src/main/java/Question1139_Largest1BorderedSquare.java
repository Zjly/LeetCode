/**
 * 1139. 最大的以 1 为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */

public class Question1139_Largest1BorderedSquare {
	public static void main(String[] args) {

	}
}

class Solution1139 {
	public int largest1BorderedSquare(int[][] grid) {
		// 左 右 上 下
		int[][][] wasd = new int[grid.length][grid[0].length][4];
		int[][][] dp = new int[grid.length][grid[0].length][2];

		// 左右
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				// 当前为0
				if(grid[i][j] == 0) {
				    continue;
				}

				// 当前为1 左右
				if(j == 0 || grid[i][j - 1] == 0) {
					int index = j + 1;
					while(index < grid[0].length && grid[i][index] == 1) {
						wasd[i][j][1]++;
						index++;
					}
				} else {
					wasd[i][j][0] = wasd[i][j - 1][0] + 1;
					wasd[i][j][1] = wasd[i][j - 1][1] - 1;
				}

				// 上下
				if(i == 0 || grid[i - 1][j] == 0) {
					int index = i + 1;
					while(index < grid.length && grid[index][j] == 1) {
					    wasd[i][j][3]++;
						index++;
					}
				} else {
				    wasd[i][j][2] = wasd[i - 1][j][2] + 1;
				    wasd[i][j][3] = wasd[i - 1][j][3] - 1;
				}

				dp[i][j][0] = Math.min(wasd[i][j][0], wasd[i][j][2]);
				dp[i][j][1] = Math.min(wasd[i][j][1], wasd[i][j][3]);
			}
		}

		int maxLength = 0;
		for(int i = 0; i < grid.length; i++) {
			maxLength = Math.max(maxLength, a(grid, dp, i, 0));
		}

		for(int j = 1; j < grid[0].length; j++) {
			maxLength = Math.max(maxLength, a(grid, dp, 0, j));
		}

		return maxLength;
	}

	public int a(int[][] grid, int[][][] dp, int i, int j) {
		int maxDistance = 0;
		int distance = 0;
		int row = i;
		int column = j;
		while(row < grid.length && column < grid[0].length) {
			if(grid[row][column] == 1) {
				maxDistance = Math.max(1, maxDistance);
			}

			for(int d = 0; d < distance; d++) {
				if(distance - d <= Math.min(dp[row][column][0], dp[i + d][j + d][1])) {
				    maxDistance = Math.max(distance - d + 1, maxDistance);
				}
			}
			distance++;
			row++;
			column++;
		}

		return maxDistance * maxDistance;
	}
}