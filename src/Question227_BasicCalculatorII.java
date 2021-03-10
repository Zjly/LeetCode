import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */

public class Question227_BasicCalculatorII {
	public static void main(String[] args) {

	}
}

class Solution227 {
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
			} else if(c == '*') {
				while(!signStack.empty() && (signStack.peek() != '(' && signStack.peek() != '+' && signStack.peek() != '-')) {
					pop();
				}
				signStack.push('*');
			} else if(c == '/') {
				while(!signStack.empty() && (signStack.peek() != '(' && signStack.peek() != '+' && signStack.peek() != '-')) {
					pop();
				}
				signStack.push('/');
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
			} else if(sign == '-') {
				numStack.push(num2 - num1);
			} else if(sign == '*') {
				numStack.push(num1 * num2);
			} else if(sign == '/') {
				numStack.push(num2 / num1);
			}
		} else {
			if(sign == '-') {
				numStack.push(-num1);
			}
		}
	}
}
