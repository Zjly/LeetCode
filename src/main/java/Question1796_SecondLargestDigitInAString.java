/**
 * 1796. 字符串中第二大的数字
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 */

public class Question1796_SecondLargestDigitInAString {
	public static void main(String[] args) {

	}
}

class Solution1796 {
	public int secondHighest(String s) {
		int first = -1;
		int second = -1;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= '0' && c <= '9') {
			    int n = c - '0';
				if(n > first) {
				    second = first;
					first = n;
				} else if(n < first && n > second) {
				    second = n;
				}
			}
		}

		return second;
	}
}