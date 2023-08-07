/**
 * 65. 有效数字
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 */

public class Question65_ValidNumber {
	public static void main(String[] args) {

	}
}

class Solution65 {
	public boolean isNumber(String s) {
		int[][] table = {
				{1, 2, 3, -1},
				{1, -1, 4, 6},
				{1, -1, 3, -1},
				{5, -1, -1, -1},
				{5, -1, -1, 6},
				{5, -1, -1, 6},
				{8, 7, -1, -1},
				{8, -1, -1, -1},
				{8, -1, -1, -1}
		};

		int state = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				state = table[state][0];
			} else if(c == '+' || c == '-') {
				state = table[state][1];
			} else if(c == '.') {
				state = table[state][2];
			} else if(c == 'e' || c == 'E') {
				state = table[state][3];
			} else {
				state = -1;
			}

			if(state == -1) {
				return false;
			}
		}

		return state == 1 || state == 4 || state == 5 || state == 8;
	}
}