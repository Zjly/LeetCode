import java.util.Stack;

/**
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 */

public class Question856_ScoreOfParentheses {
	public static void main(String[] args) {
		Solution856 solution856 = new Solution856();
		String s = "(())";
		System.out.println(solution856.scoreOfParentheses(s));
	}
}

class Solution856 {
	public int scoreOfParentheses(String s) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
			    stack.push("(");
			} else {
			    if(stack.peek().equals("(")) {
					stack.pop();
				    stack.push("1");
			    } else {
				    int num = Integer.parseInt(stack.pop());
					stack.pop();
					stack.push(String.valueOf(num * 2));
			    }
			}


			while(stack.size() >= 2) {
			    if(!stack.peek().equals("(")) {
			        int num1 = Integer.parseInt(stack.pop());
					if(!stack.peek().equals("(")) {
					    int num2 = Integer.parseInt(stack.pop());
						stack.push(String.valueOf(num1 + num2));
					} else {
					    stack.push(String.valueOf(num1));
						break;
					}
			    } else {
			        break;
			    }
			}
		}

		return Integer.parseInt(stack.peek());
	}
}
