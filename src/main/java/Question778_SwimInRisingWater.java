import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 778. 水位上升的泳池中游泳
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 * <p>
 * 示例 1:
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * <p>
 * 示例 2:
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 * <p>
 * 提示:
 * 2<= N <= 50.
 * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
 * 通过次数12,589提交次数22,177
 */

public class Question778_SwimInRisingWater {
	public static void main(String[] args) {
		Solution778 solution778 = new Solution778();
		int[][] grids = new int[][]{{3, 2}, {1, 3}};
		System.out.println(solution778.swimInWater(grids));
	}
}

class Solution778 {
	private static class Point {
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

	public int swimInWater(int[][] grid) {
		// grid的行列数目
		int lRow = grid.length;
		int lColumn = grid[0].length;

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
		effort[0][0] = grid[0][0];

		Point point0 = new Point(0, 0, grid[0][0]);
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
						// 最小花费
						int minEffort = Math.max(grid[row][column], effort[point.row][point.column]);

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
