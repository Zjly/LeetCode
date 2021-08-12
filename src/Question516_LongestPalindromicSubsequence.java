/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */

public class Question516_LongestPalindromicSubsequence {
	public static void main(String[] args) {

	}
}

class Solution516 {
	public int longestPalindromeSubseq(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];

		for(int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}

		for(int i = 1; i < length; i++) {
			for(int j = 0; j < length - i; j++) {
				int row = j;
				int column = j + i;

				if(s.charAt(row) == s.charAt(column)) {
				    dp[row][column] = dp[row + 1][column - 1] + 2;
				} else {
				    dp[row][column] = Math.max(dp[row + 1][column], dp[row][column - 1]);
				}
			}
		}

		return dp[0][length - 1];
	}
}