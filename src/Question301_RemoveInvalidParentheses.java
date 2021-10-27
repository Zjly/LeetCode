import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * <p>
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * <p>
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */

public class Question301_RemoveInvalidParentheses {
	public static void main(String[] args) {
		Solution301 solution301 = new Solution301();
		String s = "()())()";
		System.out.println(solution301.removeInvalidParentheses(s));
	}
}

class Solution301 {
	public List<String> removeInvalidParentheses(String s) {
		Set<String> set = new HashSet<>();
		int left = 0;
		int character = 0;
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				left++;
			} else if(c == ')') {
				if(left > 0) {
					left--;
					count++;
				}
			} else {
				character++;
			}
		}
		int maxLength = count * 2 + character;

		dfs(s, set, maxLength, 0, 0, "");
		return new ArrayList<>(set);
	}

	public void dfs(String s, Set<String> set, int maxLength, int index, int score, String p) {
		if(p.length() == maxLength) {
			if(score == 0) {
				set.add(p);
			}
		}

		if(score < 0 || index == s.length()) {
			return;
		}

		char c = s.charAt(index);
		if(c == '(') {
			dfs(s, set, maxLength, index + 1, score + 1, p + c);
			dfs(s, set, maxLength, index + 1, score, p);
		} else if(c == ')') {
			dfs(s, set, maxLength, index + 1, score - 1, p + c);
			dfs(s, set, maxLength, index + 1, score, p);
		} else {
			dfs(s, set, maxLength, index + 1, score, p + c);
		}
	}
}