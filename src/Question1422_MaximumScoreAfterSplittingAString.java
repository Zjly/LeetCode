/**
 * 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：5
 * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 500
 * 字符串 s 仅由字符 '0' 和 '1' 组成。
 */

public class Question1422_MaximumScoreAfterSplittingAString {
	public static void main(String[] args) {
		Solution1422 solution1422 = new Solution1422();
		String s = "011101";
		System.out.println(solution1422.maxScore(s));
	}
}

class Solution1422 {
	public int maxScore(String s) {
		int sum1 = 0;
		for(int i = 1; i < s.length(); i++) {
			sum1 += s.charAt(i) - '0';
		}

		int sum0 = 0;
		if(s.charAt(0) == '0') {
		    sum0++;
		}

		int maxCount = sum0 + sum1;
		for(int i = 1; i < s.length() - 1; i++) {
			if(s.charAt(i) == '1') {
			    sum1--;
			} else {
			    sum0++;
			}
			maxCount = Math.max(maxCount, sum0 + sum1);
		}

		return maxCount;
	}
}