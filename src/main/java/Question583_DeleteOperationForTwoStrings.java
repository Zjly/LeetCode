/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * <p>
 * 提示：
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 */

public class Question583_DeleteOperationForTwoStrings {
	public static void main(String[] args) {

	}
}

class Solution583 {
	public int minDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		for(int i = 0; i < length1; i++) {
			for(int j = 0; j < length2; j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		return length1 + length2 - 2 * dp[length1][length2];
	}
}