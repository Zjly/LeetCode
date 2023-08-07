import java.util.ArrayList;
import java.util.HashMap;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * <p>
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * <p>
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * <p>
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * <p>
 * 提示：
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 */

public class Question166_FractionToRecurringDecimal {
	public static void main(String[] args) {
		Solution166 solution166 = new Solution166();
		int numerator = 7;
		int denominator = -12;
		System.out.println(solution166.fractionToDecimal(numerator, denominator));
	}
}

class Solution166 {
	public String fractionToDecimal(int numerator, int denominator) {
		boolean sign = true;
		if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			sign = false;
		}

		long integerPart = numerator / denominator;
		if(integerPart < 0) {
			integerPart = -integerPart;
		}
		long remainder = numerator % denominator;
		if(remainder < 0) {
			remainder = -remainder;
		}

		ArrayList<Long> arrayList = new ArrayList<>();
		HashMap<Long, Integer> remainderIndex = new HashMap<>();
		int index = 0;

		boolean findLoop = false;
		while(true) {
			if(remainder == 0) {
				break;
			}
			if(remainderIndex.containsKey(remainder)) {
			    findLoop = true;
			    break;
			}

			remainderIndex.put(remainder, index);
			index++;

			remainder = remainder * 10;
			long p = remainder / denominator;
			if(p < 0) {
			    p = -p;
			}
			arrayList.add(p);
			remainder = remainder % denominator;
		}

		StringBuilder stringBuilder = new StringBuilder();
		if(!sign) {
		    stringBuilder.append("-");
		}
		stringBuilder.append(integerPart);
		if(arrayList.size() != 0) {
			stringBuilder.append(".");
			if(findLoop) {
			    int loopIndex = remainderIndex.get(remainder);
			    for(int i = 0; i < loopIndex; i++) {
			    	stringBuilder.append(arrayList.get(i));
			    }
			    stringBuilder.append("(");
			    for(int i = loopIndex; i < arrayList.size(); i++) {
			    	stringBuilder.append(arrayList.get(i));
			    }
			    stringBuilder.append(")");
			} else {
				for(Long aLong : arrayList) {
					stringBuilder.append(aLong);
				}
			}
		}


		return stringBuilder.toString();
	}
}