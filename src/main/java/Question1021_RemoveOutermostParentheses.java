/**
 * 1021. 删除最外层的括号
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * <p>
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 */

public class Question1021_RemoveOutermostParentheses {
	public static void main(String[] args) {

	}
}

class Solution1021 {
	public String removeOuterParentheses(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean b = false;
		int left = 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(c == '(') {
			    if(!b) {
			        b = true;
			    } else {
			        left++;
					stringBuilder.append('(');
			    }
			} else {
			    if(left == 0) {
			        b = false;
			    } else {
			        left--;
					stringBuilder.append(')');
			    }
			}
		}

		return stringBuilder.toString();
	}
}