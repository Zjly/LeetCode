/**
 * 688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 * <p>
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 * <p>
 * <p>
 * <p>
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 * <p>
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 * <p>
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 * <p>
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 */

public class Question688_KnightProbabilityInChessboard {
	public static void main(String[] args) {
		Solution688 solution688 = new Solution688();
		System.out.println(solution688.knightProbability(3, 100, 0, 0));
	}
}

class Solution688 {
	public double knightProbability(int n, int k, int row, int column) {
		return knightGo(n, k, row, column) / Math.pow(8, k);
	}

	public int knightGo(int n, int k, int row, int column) {
		if(row < 0 || column < 0 || row >= n || column >= n) {
			return 0;
		}

		if(k == 0) {
			return 1;
		}

		int count = 0;
		int[][] steps = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}, {1, -2}, {2, -1}};
		for(int[] step : steps) {
			count += knightGo(n, k - 1, row + step[0], column + step[1]);
		}

		return count;
	}
}