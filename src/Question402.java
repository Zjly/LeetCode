/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */

public class Question402 {
	public static void main(String[] args) {
		Solution402 solution402 = new Solution402();
		String result = solution402.removeKdigits2("1432219", 3);
		System.out.println(result);
	}

}

class Solution402 {
	public String removeKdigits1(String num, int k) {
		// 移除所有数字
		if(num.length() == k) {
			return "0";
		}

		StringBuilder numBuffer = new StringBuilder(num);
		// 逐个进行数字移除
		while(k != 0) {
			int i = 0;
			int j = i + 1;
			while(j < numBuffer.length()) {
				// 如果前一个字符大于后一个字符，移除前一个字符
				if(numBuffer.charAt(i) > numBuffer.charAt(j)) {
					numBuffer.deleteCharAt(i);
					break;
				} else {
					i++;
					j++;
				}

				// 如果前面数字都不满足条件，移除最后的数字
				if(j == numBuffer.length()) {
					numBuffer.deleteCharAt(i);
				}
			}
			k--;
		}

		// 移除字符前的"0"
		char firstChar = numBuffer.charAt(0);
		while(firstChar == '0' && numBuffer.length() != 1) {
			numBuffer.deleteCharAt(0);
			firstChar = numBuffer.charAt(0);
		}

		return numBuffer.toString();
	}

	public String removeKdigits2(String num, int k) {
		// 移除所有数字
		if(num.length() == k) {
			return "0";
		}

		StringBuilder numBuffer = new StringBuilder(num);

		int i = 0;
		int j = i + 1;

		// 逐个进行数字移除
		while(k != 0) {
			while(j < numBuffer.length()) {
				// 如果前一个字符大于后一个字符，移除前一个字符
				if(numBuffer.charAt(i) > numBuffer.charAt(j)) {
					numBuffer.deleteCharAt(i);

					// 首位数字移除时不需要进行该操作
					if(i != 0) {
						// index都-1，比较判定连接处两个字符的大小
						i--;
						j--;
					}

					break;
				} else {
					i++;
					j++;
				}

				// 如果前面数字都不满足条件，移除最后的数字
				if(j == numBuffer.length()) {
					numBuffer.deleteCharAt(i);
					i -= 2;
					j -= 2;
					break;
				}
			}
			k--;
		}

		// 移除字符前的"0"
		char firstChar = numBuffer.charAt(0);
		while(firstChar == '0' && numBuffer.length() != 1) {
			numBuffer.deleteCharAt(0);
			firstChar = numBuffer.charAt(0);
		}

		return numBuffer.toString();
	}
}