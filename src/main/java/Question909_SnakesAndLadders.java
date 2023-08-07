import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. 蛇梯棋
 * N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * 例如，一块 6 x 6 大小的棋盘，编号如下：
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 * <p>
 * 示例：
 * 输入：[
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * <p>
 * 输出：4
 * 解释：
 * 首先，从方格 1 [第 5 行，第 0 列] 开始。
 * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * 然后你决定移动到方格 36, 游戏结束。
 * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 */

public class Question909_SnakesAndLadders {
	public static void main(String[] args) {
		Solution909 solution909 = new Solution909();
		int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
		System.out.println(solution909.snakesAndLadders(board));
	}
}

class Solution909 {
	public int snakesAndLadders(int[][] board) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> got = new HashSet<>();
		int times = 0;
		int end = board.length * board.length;

		queue.offer(1);
		got.add(1);

		while(!queue.isEmpty()) {
			times++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int location = queue.poll();
				if(location == end) {
					return times - 1;
				}
				for(int j = 1; j <= 6; j++) {
					int tLocation = location + j;
					if(tLocation > end) {
						continue;
					}
					int nLocation = getValue(tLocation, board);
					if(nLocation != -1) {
						if(!got.contains(nLocation)) {
							queue.offer(nLocation);
							got.add(nLocation);
						}
					} else {
						if(!got.contains(tLocation)) {
							queue.offer(tLocation);
							got.add(tLocation);
						}
					}
				}
			}
		}

		return -1;
	}

	private int getValue(int location, int[][] board) {
		int N = board.length;
		int row = N - 1 - (location - 1) / N;
		int column = (location - 1) % N;
		boolean isTraverse = row % 2 == N % 2;
		if(isTraverse) {
			return board[row][N - 1 - column];
		} else {
			return board[row][column];
		}
	}
}
