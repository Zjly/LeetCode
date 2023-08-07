/**
 * 1138. 字母板上的路径
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * <p>
 * <p>
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * （注意，字母板上只存在有字母的位置。）
 * <p>
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 */

public class Question1138_AlphabetBoardPath {
	public static void main(String[] args) {
		Solution1138 solution1138 = new Solution1138();
		String target = "zb";
		System.out.println(solution1138.alphabetBoardPath(target));
	}
}

class Solution1138 {
	public String alphabetBoardPath(String target) {
		int[][] search = new int[26][2];
		for(int i = 0; i < 26; i++) {
			search[i][0] = i / 5;
			search[i][1] = i % 5;
		}

		StringBuilder stringBuilder = new StringBuilder();
		char last = 'a';
		for(int i = 0; i < target.length(); i++) {
			char current = target.charAt(i);

			if(last == current) {
				stringBuilder.append('!');
				continue;
			} else if(last == 'z') {
				stringBuilder.append('U');
				last = 'u';
			}

			int row = search[last - 'a'][1] - search[current - 'a'][1];
			if(row < 0) {
				for(int j = 0; j < -row; j++) {
					stringBuilder.append('R');
				}
			} else if(row > 0) {
				for(int j = 0; j < row; j++) {
					stringBuilder.append('L');
				}
			}

			int column = search[last - 'a'][0] - search[current - 'a'][0];
			if(column < 0) {
				for(int j = 0; j < -column; j++) {
					stringBuilder.append('D');
				}
			} else if(column > 0) {
				for(int j = 0; j < column; j++) {
					stringBuilder.append('U');
				}
			}

			stringBuilder.append('!');
			last = current;
		}

		return stringBuilder.toString();
	}
}