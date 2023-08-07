/**
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * 示例 4：
 * <p>
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 */

public class Question859_BuddyStrings {
	public static void main(String[] args) {

	}
}

class Solution859 {
	public boolean buddyStrings(String s, String goal) {
		if(s.length() != goal.length()) {
			return false;
		}

		int firstIndex = -1;
		int secondIndex = -1;

		boolean repeat = false;
		int count = 0;

		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = goal.charAt(i);

			if(!repeat) {
				if((count & (1 << (c1 - 'a'))) != 0) {
				    repeat = true;
				}
			    count = count | (1 << (c1 - 'a'));
			}

			if(c1 != c2) {
				if(firstIndex == -1) {
					firstIndex = i;
				} else if(secondIndex == -1) {
					secondIndex = i;
				} else {
					return false;
				}
			}
		}

		if(firstIndex == -1 || secondIndex == -1) {
			return firstIndex == -1 && repeat;
		}

		return s.charAt(firstIndex) == goal.charAt(secondIndex) && s.charAt(secondIndex) == goal.charAt(firstIndex);
	}
}