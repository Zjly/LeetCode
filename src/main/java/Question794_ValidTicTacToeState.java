/**
 * 794. 有效的井字游戏
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = ["XXX","   ","OOO"]
 * 输出：false
 * Example 4:
 * <p>
 * <p>
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 */

public class Question794_ValidTicTacToeState {
	public static void main(String[] args) {

	}
}

class Solution794 {
	public boolean validTicTacToe(String[] board) {
		int Xcount = 0;
		int Ocount = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				char c = board[i].charAt(j);
				if(c == 'X') {
					Xcount++;
				} else if(c == 'O') {
					Ocount++;
				}
			}
		}

		if(winTheGame(board, 'X')) {
			return Xcount == Ocount + 1 && !winTheGame(board, 'O');
		} else if(winTheGame(board, 'O')) {
			return Xcount == Ocount;
		} else {
			return Xcount == Ocount + 1 || Xcount == Ocount;
		}
	}

	public boolean winTheGame(String[] board, char c) {
		return board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c ||
				board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c ||
				board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c ||
				board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c ||
				board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c ||
				board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c ||
				board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c ||
				board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c;
	}
}