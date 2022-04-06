/**
 * 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 */

public class Question796_RotateString {
	public static void main(String[] args) {

	}
}

class Solution796 {
	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}
}
