/**
 * 537. 复数乘法
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 * <p>
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * <p>
 * <p>
 * 提示：
 * <p>
 * num1 和 num2 都是有效的复数表示。
 */

public class Question537_ComplexNumberMultiplication {
	public static void main(String[] args) {
		Solution537 solution537 = new Solution537();
		String num1 = "1+-1i";
		String num2 = "0+0i";
		System.out.println(solution537.complexNumberMultiply(num1, num2));
	}
}

class Solution537 {
	public String complexNumberMultiply(String num1, String num2) {
		int real1 = Integer.parseInt(num1.split("\\+")[0]);
		int imaginary1 = Integer.parseInt(num1.split("\\+")[1].substring(0, num1.split("\\+")[1].length() - 1));

		int real2 = Integer.parseInt(num2.split("\\+")[0]);
		int imaginary2 = Integer.parseInt(num2.split("\\+")[1].substring(0, num2.split("\\+")[1].length() - 1));

		int real = real1 * real2 - imaginary1 * imaginary2;
		int imaginary = real1 * imaginary2 + real2 * imaginary1;

		return real + "+" + imaginary + "i";
	}
}