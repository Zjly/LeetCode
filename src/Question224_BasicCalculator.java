import java.util.Stack;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */

public class Question224_BasicCalculator {
	public static void main(String[] args) {
		Solution224 solution224 = new Solution224();
		String s = " 2-1 + 2 ";
		System.out.println(solution224.calculate(s));
	}
}

class Solution224 {
	Stack<Integer> numStack = new Stack<>();
	Stack<Character> signStack = new Stack<>();

	public int calculate(String s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '+') {
				while(!signStack.empty() && signStack.peek() != '(') {
					pop();
				}
				signStack.push('+');
			} else if(c == '-') {
				while(!signStack.empty() && signStack.peek() != '(') {
					pop();
				}
				signStack.push('-');
			} else if(c == '(') {
				signStack.push('(');
			} else if(c == ')') {
				while(signStack.peek() != '(') {
					pop();
				}
				signStack.pop();
			} else if(c == ' ') {

			} else {
				int num = c - '0';
				while(i != s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					i++;
					num = num * 10 + s.charAt(i) - '0';
				}
				numStack.push(num);
			}
		}

		while(!signStack.empty()) {
			pop();
		}

		return numStack.pop();
	}

	public void pop() {
		char sign = signStack.pop();
		int num1 = numStack.pop();
		if(!numStack.empty()) {
			int num2 = numStack.pop();
			if(sign == '+') {
				numStack.push(num1 + num2);
			} else {
				numStack.push(num2 - num1);
			}
		} else {
			if(sign == '+') {
				numStack.push(num1);
			} else {
				numStack.push(-num1);
			}
		}
	}
}
