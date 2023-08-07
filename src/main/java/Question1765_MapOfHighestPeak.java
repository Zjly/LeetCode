import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1765. 地图中的最高点
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 * <p>
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 * <p>
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 * <p>
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 * 任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j] 要么是 0 ，要么是 1 。
 * 至少有 1 个水域格子。
 */

public class Question1765_MapOfHighestPeak {
	public static void main(String[] args) {
		Solution1765 solution1765 = new Solution1765();
		int[][] isWater = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
		System.out.println(Arrays.deepToString(solution1765.highestPeak(isWater)));
	}
}

class Solution1765 {
	public int[][] highestPeak(int[][] isWater) {
		int[][] map = new int[isWater.length][isWater[0].length];
		Queue<int[]> queue = new LinkedList<>();

		for(int i = 0; i < isWater.length; i++) {
			for(int j = 0; j < isWater[0].length; j++) {
				if(isWater[i][j] == 1) {
					queue.offer(new int[]{i, j});
				}
			}
		}

		int high = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int n = 0; n < size; n++) {
				int[] point = queue.poll();
				int i = point[0];
				int j = point[1];

				int[] rows = {i - 1, i + 1};
				int[] columns = {j - 1, j + 1};

				for(int row : rows) {
					if(row >= 0 && row <= map.length - 1 && map[row][j] == 0 && isWater[row][j] == 0) {
						map[row][j] = high;
						queue.offer(new int[]{row, j});
					}
				}

				for(int column : columns) {
					if(column >= 0 && column <= map[0].length - 1 && map[i][column] == 0 && isWater[i][column] == 0) {
						map[i][column] = high;
						queue.offer(new int[]{i, column});
					}
				}
			}

			high++;
		}

		return map;
	}
}