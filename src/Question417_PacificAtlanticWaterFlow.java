import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */

public class Question417_PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		Solution417 solution417 = new Solution417();
//		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] heights = {{2, 1}, {1, 2}};
		System.out.println(solution417.pacificAtlantic(heights));
	}
}

class Solution417 {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;

		boolean[][] flowToPacific = new boolean[m][n];
		Queue<int[]> queuePacific = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			queuePacific.add(new int[]{i, 0});
			flowToPacific[i][0] = true;
		}
		for(int i = 1; i < n; i++) {
			queuePacific.add(new int[]{0, i});
			flowToPacific[0][i] = true;
		}

		boolean[][] flowToAtlantic = new boolean[m][n];
		Queue<int[]> queueAtlantic = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			queueAtlantic.add(new int[]{i, n - 1});
			flowToAtlantic[i][n - 1] = true;
		}
		for(int i = 0; i < n - 1; i++) {
			queueAtlantic.add(new int[]{m - 1, i});
			flowToAtlantic[m - 1][i] = true;
		}

		getFlow(queuePacific, flowToPacific, heights);
		getFlow(queueAtlantic, flowToAtlantic, heights);

		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(flowToPacific[i][j] && flowToAtlantic[i][j]) {
					List<Integer> p = new ArrayList<>();
					p.add(i);
					p.add(j);
					result.add(p);
				}
			}
		}

		return result;
	}

	public void getFlow(Queue<int[]> queue, boolean[][] flow, int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int i = 0; i < queueSize; i++) {
				int[] position = queue.poll();
				for(int[] d : direct) {
					int x = position[0] + d[0];
					int y = position[1] + d[1];
					if(x >= 0 && x < m && y >= 0 && y < n && !flow[x][y] && heights[x][y] >= heights[position[0]][position[1]]) {
						queue.add(new int[]{x, y});
						flow[x][y] = true;
					}
				}
			}
		}
	}
}