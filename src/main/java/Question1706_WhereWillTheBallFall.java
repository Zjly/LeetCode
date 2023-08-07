/**
 * 1706. 球会落何处
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * 示例 2：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * 输出：[0,1,2,3,4,-1]
 */

public class Question1706_WhereWillTheBallFall {
	public static void main(String[] args) {

	}
}

class Solution1706 {
	public int[] findBall(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;

		int[][] next = new int[row][column];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				int board = grid[i][j];
				// "\\"
				if(grid[i][j] == 1 && j != column - 1 && grid[i][j + 1] == 1) {
					next[i][j] = j + 1;
				}
				// "//"
				else if(board == -1 && j != 0 && grid[i][j - 1] == -1) {
					next[i][j] = j - 1;
				}
				// others
				else {
				    next[i][j] = -1;
				}
			}
		}

		int[] result = new int[column];
		for(int i = 0; i < column; i++) {
			int location = i;
			for(int j = 0; j < row; j++) {
				location = next[j][location];
				if(location == -1) {
				    break;
				}
			}

			result[i] = location;
		}

		return result;
	}
}