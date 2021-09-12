import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 * <p>
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 * 注意:
 * 字符串大小将在 [1，100] 范围内。
 */

public class Question678_ValidParenthesisString {
	public static void main(String[] args) {
		Solution678 solution678 = new Solution678();
		String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
		System.out.println(solution678.checkValidString(s));
	}
}

class Solution678 {
	public boolean checkValidString(String s) {
		Stack<Integer> left = new Stack<>();
		Stack<Integer> star = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
			   left.push(i);
			} else if(s.charAt(i) == ')') {
			    if(!left.empty()) {
			        left.pop();
			    } else if(!star.isEmpty()) {
			        star.pop();
			    } else {
			        return false;
			    }
			} else {
			    star.push(i);
			}
		}

		if(left.size() > star.size()) {
		    return false;
		}

		int size = left.size();
		for(int i = 0; i < size; i++) {
			if(left.pop() > star.pop()) {
			    return false;
			}
		}

		return true;
	}
}
