import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LCP 41. 黑白翻转棋
 * 在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
 * <p>
 * 1.gif2.gif3.gif
 * <p>
 * 「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
 * <p>
 * 注意：
 * <p>
 * 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
 * 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
 * 示例 1：
 * <p>
 * 输入：chessboard = ["....X.","....X.","XOOO..","......","......"]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 可以选择下在 [2,4] 处，能够翻转白方三枚棋子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：chessboard = [".X.",".O.","XO."]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 可以选择下在 [2,2] 处，能够翻转白方两枚棋子。
 * 2126c1d21b1b9a9924c639d449cc6e65.gif
 * <p>
 * 示例 3：
 * <p>
 * 输入：chessboard = [".......",".......",".......","X......",".O.....","..O....","....OOX"]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 可以选择下在 [6,3] 处，能够翻转白方四枚棋子。
 * 803f2f04098b6174397d6c696f54d709.gif
 * <p>
 * 提示：
 * <p>
 * 1 <= chessboard.length, chessboard[i].length <= 8
 * chessboard[i] 仅包含 "."、"O" 和 "X"
 */

public class QuestionLCP41_黑白翻转棋 {
	SolutionLCP41 solutionLCP41 = new SolutionLCP41();

	@Test
	public void test1() {
		String[] chessboard = {".X.", ".O.", "XO."};
		Assertions.assertEquals(2, solutionLCP41.flipChess(chessboard));
	}

	@Test
	public void test2() {
		String[] chessboard = {".O.....", ".O.....", "XOO.OOX", ".OO.OO.", ".XO.OX.", "..X.X.."};
		Assertions.assertEquals(10, solutionLCP41.flipChess(chessboard));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/6/21 22:29
 */
class SolutionLCP41 {
	private int maxCount = 0;
	private int count = 0;

	public int flipChess(String[] chessboard) {
		int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};

		char[][] board = new char[chessboard.length][chessboard[0].length()];
		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard[0].length(); j++) {
				board[i][j] = chessboard[i].charAt(j);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					char[][] newBoard = new char[chessboard.length][chessboard[0].length()];
					for (int k = 0; k < chessboard.length; k++) {
						for (int l = 0; l < chessboard[0].length(); l++) {
							newBoard[k][l] = board[k][l];
						}
					}
					newBoard[i][j] = 'X';
					check(newBoard, dirs, i, j);
					maxCount = Math.max(maxCount, count);
					count = 0;
				}
			}
		}

		return maxCount;
	}

	private void check(char[][] board, int[][] dirs, int x, int y) {
		for (int[] dir : dirs) {
			int xx = x;
			int yy = y;

			int lastBlackX = x;
			int lastBlackY = y;

			while (valid(board, xx, yy)) {
				if (board[xx][yy] == 'X') {
					lastBlackX = xx;
					lastBlackY = yy;
				}

				xx += dir[0];
				yy += dir[1];
			}

			while (lastBlackX != x || lastBlackY != y) {
				if (board[lastBlackX][lastBlackY] == 'O') {
					count++;
					board[lastBlackX][lastBlackY] = 'X';
					check(board, dirs, lastBlackX, lastBlackY);
				}
				lastBlackX -= dir[0];
				lastBlackY -= dir[1];
			}
		}
	}

	private boolean valid(char[][] board, int x, int y) {
		return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '.';
	}
}