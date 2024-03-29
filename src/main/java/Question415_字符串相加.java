/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */

public class Question415_字符串相加 {
}

class Solution415 {
	public String addStrings(String num1, String num2) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean up = false;
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;

		while (index1 >= 0 && index2 >= 0) {
			int n = up ? 1 : 0;
			n += num1.charAt(index1) - '0';
			n += num2.charAt(index2) - '0';
			if (n >= 10) {
			    n -= 10;
				up = true;
			} else {
			    up = false;
			}
			stringBuilder.append(n);

			index1--;
			index2--;
		}

		while (index1 >= 0) {
			int n = up ? 1 : 0;
			n += num1.charAt(index1) - '0';
			if (n >= 10) {
				n -= 10;
				up = true;
			} else {
				up = false;
			}
			stringBuilder.append(n);

			index1--;
		}

		while (index2 >= 0) {
			int n = up ? 1 : 0;
			n += num2.charAt(index2) - '0';
			if (n >= 10) {
				n -= 10;
				up = true;
			} else {
				up = false;
			}
			stringBuilder.append(n);

			index2--;
		}

		if (up) {
		    stringBuilder.append(1);
		}

		return stringBuilder.reverse().toString();
	}
}