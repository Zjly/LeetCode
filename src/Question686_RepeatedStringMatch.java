/**
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * <p>
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 */

public class Question686_RepeatedStringMatch {
	public static void main(String[] args) {
		Solution686 solution686 = new Solution686();
		String a = "baa";
		String b = "abaab";
		System.out.println(solution686.repeatedStringMatch(a, b));
	}
}

class Solution686 {
	public int repeatedStringMatch(String a, String b) {
		if(a.contains(b)) {
			return 1;
		}

		String aa = a + a;
		String subB;
		if(a.length() > b.length()) {
			subB = b;
		} else {
			subB = b.substring(0, a.length());
		}

		if(!aa.contains(subB)) {
			return -1;
		}

		int index = aa.indexOf(subB);
		int count = 1;
		for(int i = 0; i < b.length(); i++) {
			if(index == a.length()) {
				count++;
				index = 0;
			}
			if(b.charAt(i) == a.charAt(index)) {
			    index++;
			} else {
			    return -1;
			}
		}

		return count;
	}
}