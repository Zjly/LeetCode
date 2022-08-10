/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 */

public class Question640_SolveTheEquation {
	public static void main(String[] args) {
		Solution640 solution640 = new Solution640();
		String equation = "0x=0";
		System.out.println(solution640.solveEquation(equation));
	}
}

class Solution640 {
	public String solveEquation(String equation) {
		String[] s = equation.split("=");
		int[] s1 = solve(s[0]);
		int[] s2 = solve(s[1]);

		int k = s1[0] - s2[0];
		int b = s2[1] - s1[1];

		if(k == 0 && b != 0) {
			return "No solution";
		} else if(k == 0) {
			return "Infinite solutions";
		} else {

			return "x=" + b / k;
		}
	}

	public int[] solve(String equation) {
		int k = 0;
		int b = 0;

		int positive = 1;
		int temp = 0;

		for(int i = 0; i < equation.length(); i++) {
			char c = equation.charAt(i);

			if(c >= '0' && c <= '9') {
				temp *= 10;
				temp += c - '0';
			} else if(c == '+') {
				b += positive * temp;
				temp = 0;
				positive = 1;
			} else if(c == '-') {
				b += positive * temp;
				temp = 0;
				positive = -1;
			} else if(c == 'x') {
				if(temp == 0) {
					if(i != 0 && equation.charAt(i - 1) == '0') {
						k += 0;
					} else {
						k += positive;
					}
				} else {
					k += positive * temp;
					temp = 0;
				}
			}
		}

		b += positive * temp;

		return new int[]{k, b};
	}
}