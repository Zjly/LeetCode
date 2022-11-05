import java.util.Stack;

/**
 * 1106. 解析布尔表达式
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 */

public class Question1106_ParsingABooleanExpression {
	public static void main(String[] args) {
		Solution1106 solution1106 = new Solution1106();
		String expression = "|(&(t,f,t),!(t))";
		System.out.println(solution1106.parseBoolExpr(expression));
	}
}

class Solution1106 {
	public boolean parseBoolExpr(String expression) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if(c == ')') {
				Stack<Character> p = new Stack<>();
				while(stack.peek() == 't' || stack.peek() == 'f') {
					p.push(stack.pop());
				}
				char sign = stack.pop();
				boolean b = p.pop() == 't';
				if(sign == '&') {
					while(!p.empty()) {
						char x = p.pop();
						b = b && (x == 't');
					}
				} else if(sign == '|') {
					while(!p.empty()) {
						char x = p.pop();
						b = b || (x == 't');
					}
				} else if(sign == '!') {
					b = !b;
				}
				stack.push(b ? 't' : 'f');
			} else if(c != '(' && c != ',') {
				stack.push(c);
			}
		}

		return stack.peek() == 't';
	}
}
