/**
664. 奇怪的打印机
有台奇怪的打印机有以下两个特殊要求：
打印机每次只能打印由 同一个字符 组成的序列。
每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。

示例 1：
输入：s = "aaabbb"
输出：2
解释：首先打印 "aaa" 然后打印 "bbb"。

示例 2：
输入：s = "aba"
输出：2
解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。

提示：
1 <= s.length <= 100
s 由小写英文字母组成
 */

public class Question664_StrangePrinter {
	public static void main(String[] args) {
		Solution664 solution664 = new Solution664();
		String s = "ababa";
		System.out.println(solution664.strangePrinter(s));
	}
}

class Solution664 {
	public int strangePrinter(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for(int j = 0; j < s.length(); j++) {
			dp[j][j] = 1;
			for(int i = j - 1; i >= 0; i--) {
				if(s.charAt(i) == s.charAt(j)) {
				    dp[i][j] = dp[i][j - 1];
				} else {
				    int min = Integer.MAX_VALUE;
					for(int k = i; k < j; k++) {
						min = Math.min(min, dp[i][k] + dp[k + 1][j]);
					}
					dp[i][j] = min;
				}
			}
		}

		return dp[0][s.length() - 1];
	}
}
