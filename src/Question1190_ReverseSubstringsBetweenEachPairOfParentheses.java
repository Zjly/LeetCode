import java.util.ArrayList;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * <p>
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * <p>
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 */

public class Question1190_ReverseSubstringsBetweenEachPairOfParentheses {
	public static void main(String[] args) {

	}
}

class Solution1190 {
	public String reverseParentheses(String s) {
		Stack<String> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			switch(c) {
				case '(':
					stack.push("(");
					break;
				case ')':
					StringBuilder stringBuilder = new StringBuilder();
					while(!stack.peek().equals("(")) {
						StringBuilder s1 = new StringBuilder(stack.pop());
						s1.reverse();
						stringBuilder.append(s1);
					}
					stack.pop();
					stack.push(stringBuilder.toString());
					break;
				default:
					stack.push(String.valueOf(c));
			}
		}

		Stack<String> stackReverse = new Stack<>();
		while(!stack.isEmpty()) {
			stackReverse.push(stack.pop());
		}

		StringBuilder stringBuilder = new StringBuilder();
		while(!stackReverse.isEmpty()) {
			stringBuilder.append(stackReverse.pop());
		}

		return stringBuilder.toString();
	}
}