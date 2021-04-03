/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */

public class Question1143_LongestCommonSubsequence {
	public static void main(String[] args) {
		String text1 = "abcba";
		String text2 = "abcbcba";
		Solution1143 solution1143 = new Solution1143();
		System.out.println(solution1143.longestCommonSubsequence(text1, text2));
	}
}

class Solution1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] subsequenceLength = new int[text1.length()][text2.length()];

		if(text1.charAt(0) == text2.charAt(0)) {
			subsequenceLength[0][0]++;
		}

		for(int i = 1; i < text1.length(); i++) {
			if(subsequenceLength[i - 1][0] != 1 && text1.charAt(i) == text2.charAt(0)) {
				subsequenceLength[i][0] = 1;
			} else {
				subsequenceLength[i][0] = subsequenceLength[i - 1][0];
			}
		}

		for(int j = 1; j < text2.length(); j++) {
			if(subsequenceLength[0][j - 1] != 1 && text1.charAt(0) == text2.charAt(j)) {
				subsequenceLength[0][j] = 1;
			} else {
				subsequenceLength[0][j] = subsequenceLength[0][j - 1];
			}
		}

		for(int i = 1; i < text1.length(); i++) {
			for(int j = 1; j < text2.length(); j++) {
				if(text1.charAt(i) == text2.charAt(j)) {
					subsequenceLength[i][j] = subsequenceLength[i - 1][j - 1] + 1;
				} else {
					subsequenceLength[i][j] = Math.max(subsequenceLength[i][j - 1], subsequenceLength[i - 1][j]);
				}
			}
		}

		return subsequenceLength[text1.length() - 1][text2.length() - 1];
	}
}