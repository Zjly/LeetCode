/**
 * 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * <p>
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 */

public class Question115_DistinctSubsequences {
	public static void main(String[] args) {
		Solution115 solution115 = new Solution115();
		String s = "babgbag";
		String t = "bax";
		System.out.println(solution115.numDistinct(s, t));
	}
}

class Solution115 {
	public int numDistinct(String s, String t) {
		// s = babgbag, t = bag
		//	babgbag
		//	1 1 1
		//	 1   3
		//	   1  4
		int sLength = s.length();
		int tLength = t.length();

		// 特定字母组合出现的次数
		int[][] countLetter = new int[tLength][sLength];

		int nextBegin = 0;
		boolean first = true;

		// 初始化第一行 结果为t中首字母的位置个数
		for(int j = 0; j < sLength; j++) {
			if(s.charAt(j) == t.charAt(0)) {
				if(first) {
					nextBegin = j + 1;
					first = false;
				}
				countLetter[0][j] = 1;
			}
		}

		// 根据上一行的结果更新下一行
		for(int i = 1; i < tLength; i++) {
			char c = t.charAt(i);
			int count = countLetter[i - 1][nextBegin - 1];
			first = true;

			for(int j = nextBegin; j < sLength; j++) {
				if(s.charAt(j) == c) {
					if(first) {
						nextBegin = j + 1;
						first = false;
					}
					countLetter[i][j] = count;
				}
				count += countLetter[i - 1][j];
			}
		}

		int result = 0;
		for(int i = 0; i < sLength; i++) {
			result += countLetter[tLength - 1][i];
		}

		return result;
	}
}
