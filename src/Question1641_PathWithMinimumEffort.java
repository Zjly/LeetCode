import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 示例 2：
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * 示例 3：
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 提示：
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */

public class Question1641_PathWithMinimumEffort {
	public static void main(String[] args) {
		Solution1641 solution1641 = new Solution1641();
		int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
		System.out.println(solution1641.minimumEffortPath(heights));
	}
}

class Solution1641 {
	class Point {
		int row;
		int column;
		int value;

		public Point(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}

		@Override
		public String toString() {
			return "(" + row + ", " + column + ")" + ": " + value;
		}
	}

	public int minimumEffortPath(int[][] heights) {
		// heights的行列数目
		int lRow = heights.length;
		int lColumn = heights[0].length;

		// 最小花费表
		int[][] effort = new int[lRow][lColumn];

		// 是否曾经以被选中
		boolean[][] arrive = new boolean[lRow][lColumn];

		// 优先队列进行从小到大的排序，每次选择其中的最小值
		Comparator<Point> comparator = Comparator.comparingInt(o -> o.value);
		PriorityQueue<Point> priorityQueue = new PriorityQueue<>(comparator);

		// 其余花费初始值为MAX
		for(int i = 0; i < lRow; i++) {
			for(int j = 0; j < lColumn; j++) {
				effort[i][j] = Integer.MAX_VALUE;
			}
		}
		effort[0][0] = 0;

		Point point0 = new Point(0, 0, 0);
		priorityQueue.offer(point0);

		// 栈不空循环
		while(!priorityQueue.isEmpty()) {
			Point point = priorityQueue.poll();

			// 到达终点，返回终点花费
			if(point.row == lRow - 1 && point.column == lColumn - 1) {
				return effort[point.row][point.column];
			}

			// 之前已遍历
			if(arrive[point.row][point.column]) {
				continue;
			}

			arrive[point.row][point.column] = true;

			class F {
				 void around(int i, int j) {
					int row = point.row + i;
					int column = point.column + j;

					// 界内并之前未选中过
					if(row >= 0 && row < lRow && column >= 0 && column < lColumn && !arrive[row][column]) {
						// 当前点到新增点的花费
						int thisEffort = Math.abs(heights[point.row][point.column] - heights[row][column]);
						// 最小花费
						int minEffort = Math.max(thisEffort, effort[point.row][point.column]);

						// 更新花费表
						if(minEffort < effort[row][column]) {
							effort[row][column] = minEffort;
							Point tPoint = new Point(row, column, minEffort);
							priorityQueue.offer(tPoint);
						}
					}
				}
			}

			F f = new F();
			f.around(-1, 0);
			f.around(1, 0);
			f.around(0, -1);
			f.around(0, 1);
		}

		return -1;
	}
}
