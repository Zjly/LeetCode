/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * <p>
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */

public class Question8 {
	public static void main(String[] args) {
		Solution8 solution8 = new Solution8();
		int result = solution8.myAtoi("-91283472332");
		System.out.println(result);
	}

}

class Solution8 {
	public int myAtoi(String s) {
		int begin = 0;
		int end;

		// 是否有符号
		boolean haveSign = false;
		boolean sign = true;

		// 确定开始位置
		while(begin < s.length()) {
			char thisChar = s.charAt(begin);

			// 空格则继续下一个字符
			if(thisChar == ' ') {
				begin++;
			} else if(thisChar == '+') {
				haveSign = true;
				begin++;
				break;
			} else if(thisChar == '-') {
				sign = false;
				haveSign = true;
				begin++;
				break;
			} else if(thisChar >= '0' && thisChar <= '9') {
				break;
			} else {
				return 0;
			}
		}

		// 整个字符串中没有数字或者仅含有一个符号
		if(begin == s.length() || s.length() == 1 && haveSign) {
			return 0;
		}

		// 符号连续出现
		if(!(s.charAt(begin) >= '0' && s.charAt(begin) <= '9')) {
			return 0;
		}

		// 确定结束位置
		end = begin;
		while(end + 1 < s.length()) {
			char thisChar = s.charAt(end + 1);

			if(thisChar >= '0' && thisChar <= '9') {
				end++;
			} else {
				break;
			}
		}

		// 获取数字字符串
		String num = s.substring(begin, end + 1);

		// 去除字符串最前的0
		char firstChar = num.charAt(0);
		while(firstChar == '0') {
			num = num.substring(1);
			if(num.length() == 0) {
				return 0;
			}
			firstChar = num.charAt(0);
		}

		// 判断是否溢出
		if(num.length() > 10) {
			// 负数
			if(!sign) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		// 判断10位数字下的溢出情况
		else if(num.length() == 10) {
			// 获取数字串的前9个数字
			String numResult = num.substring(0, 9);
			int intNumResult = Integer.parseInt(numResult);

			// 计算最值的前9个数字
			int limit = Integer.MAX_VALUE / 10;

			// 超出最值
			if(intNumResult > limit) {
				if(!sign) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			}
			// 前9位相同
			else if(intNumResult == limit) {
				// 负数
				if(!sign) {
					if(num.charAt(9) >= '8') {
						return Integer.MIN_VALUE;
					}
				}
				// 正数
				else {
					if(num.charAt(9) >= '7') {
						return Integer.MAX_VALUE;
					}
				}
			}
		}

		// 数值转化
		int iNum = Integer.parseInt(num);

		return sign ? iNum : -iNum;
	}
}