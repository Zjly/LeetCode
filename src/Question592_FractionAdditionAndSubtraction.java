/**
 * 592. 分数加减运算
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 * 示例 2:
 * <p>
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * <p>
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */

public class Question592_FractionAdditionAndSubtraction {
	public static void main(String[] args) {
		Solution592 solution592 = new Solution592();
		String expression = "1/3-1/2";
		System.out.println(solution592.fractionAddition(expression));
	}
}

class Solution592 {
	public String fractionAddition(String expression) {
		int numerator = 0;
		int denominator = 0;

		int index = 0;

		while(index < expression.length()) {
			// 读取符号
			boolean positive = expression.charAt(index) != '-';

			if(index != 0 || expression.charAt(index) == '-') {
				index++;
			}

			// 读取分母和分子
			int up = 0;
			int down = 0;
			while(index < expression.length() && expression.charAt(index) >= '0' && expression.charAt(index) <= '9') {
				up *= 10;
				up += expression.charAt(index) - '0';
				index++;
			}
			index++;
			while(index < expression.length() && expression.charAt(index) >= '0' && expression.charAt(index) <= '9') {
				down *= 10;
				down += expression.charAt(index) - '0';
				index++;
			}

			// 计算
			if(denominator == 0) {
			    numerator = positive ? up : -up;
				denominator = down;
			} else {
				int leastCommonMultiple = denominator * down / gcd(denominator, down);
				int ratio1 = leastCommonMultiple / denominator;
				int ratio2 = leastCommonMultiple / down;
				denominator = leastCommonMultiple;
				numerator = numerator * ratio1;
				up = positive ? up : -up;
				numerator += up * ratio2;
			}
		}

		if(numerator == 0) {
		    return "0/1";
		}

		boolean positive = numerator > 0;

		numerator = Math.abs(numerator);
		int greatestCommonDivisor = gcd(numerator, denominator);
		numerator /= greatestCommonDivisor;
		numerator = positive ? numerator : -numerator;
		denominator /= greatestCommonDivisor;

		return numerator + "/" + denominator;
	}

	public int gcd(int num1, int num2) {
		if(num1 == 0 || num2 == 0) {
		    return 1;
		}

		if(num1 < num2) {
		    int p = num1;
			num1 = num2;
			num2 = p;
		}

		while(num1 % num2 != 0) {
		    int mod = num1 % num2;
			num1 = num2;
			num2 = mod;
		}
		return num2;
	}
}