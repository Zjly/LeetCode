/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */

public class QuestionO19_II {
	public static void main(String[] args) {

	}
}

class SolutionO19_II {
	public boolean validPalindrome(String s) {
		int begin = 0;
		int end = s.length() - 1;

		while(begin < end) {
			if(s.charAt(begin) != s.charAt(end)) {
				return isHW(s, begin + 1, end) || isHW(s, begin, end - 1);
			}
			begin++;
			end--;
		}

		return true;
	}

	public boolean isHW(String s, int begin, int end) {
		while(begin < end) {
		    if(s.charAt(begin) != s.charAt(end)) {
				return false;
		    }
			begin++;
			end--;
		}

		return true;
	}
}
