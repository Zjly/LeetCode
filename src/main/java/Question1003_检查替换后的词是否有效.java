import java.util.Stack;

/**
 * 1003. 检查替换后的词是否有效
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * <p>
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcbc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcababcc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 * 示例 3：
 * <p>
 * 输入：s = "abccba"
 * 输出：false
 * 解释：执行操作无法得到 "abccba" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 104
 * s 由字母 'a'、'b' 和 'c' 组成
 */

public class Question1003_检查替换后的词是否有效 {
	public static void main(String[] args) {

	}
}

class Solution1003 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == 'c') {
			    try {
					char b = stack.pop();
					char a = stack.pop();
					if(b != 'b' || a != 'a') {
					    return false;
					}
			    } catch(Exception e) {
					return false;
			    }
			} else {
			    stack.push(c);
			}
		}

		return stack.empty();
	}
}