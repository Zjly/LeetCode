/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 示例 1：
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * <p>
 * 示例 2：
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 */

public class Question405_ConvertANumberToHexadecimal {
	public static void main(String[] args) {

	}
}

class Solution405 {
	public String toHex(int num) {
		if(num == 0) {
		    return "0";
		}

		char[] chars = new char[8];
		int p = 1;
		for(int i = 0; i < 8; i++) {
			int numP = 0;
			for(int j = 0; j < 4; j++) {
				if((p & num) == p) {
					numP += 1 << j;
				}
				p = p << 1;
			}
			chars[7 - i] = getHex(numP);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			if(!(stringBuilder.length() == 0 && chars[i] == '0')) {
			    stringBuilder.append(chars[i]);
			}
		}

		return stringBuilder.toString();
	}

	private char getHex(int num) {
		switch(num) {
			case 10:
				return 'a';
			case 11:
				return 'b';
			case 12:
				return 'c';
			case 13:
				return 'd';
			case 14:
				return 'e';
			case 15:
				return 'f';
			default:
				return (char)(num + '0');
		}
	}
}