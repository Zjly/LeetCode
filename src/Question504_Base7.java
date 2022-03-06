/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -107 <= num <= 107
 */

public class Question504_Base7 {
	public static void main(String[] args) {

	}
}

class Solution504 {
	public String convertToBase7(int num) {
		if(num == 0) {
		    return "0";
		}

		StringBuilder stringBuilder = new StringBuilder();

		boolean b = false;
		if(num < 0) {
			num = -num;
			b = true;
		}

		while(num != 0) {
			stringBuilder.append(num % 7);
			num /= 7;
		}

		if(b) {
			stringBuilder.append("-");
		}

		return stringBuilder.reverse().toString();
	}
}