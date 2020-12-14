import java.util.Arrays;
import java.util.HashMap;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */

public class Question738_MonotoneIncreasingDigits {
	public static void main(String[] args) {
		Solution738 solution738 = new Solution738();
		int N = 332;
		System.out.println(solution738.monotoneIncreasingDigits(N));
	}
}

class Solution738 {
	public int monotoneIncreasingDigits(int N) {
		if(N < 10) {
		    return N;
		}

		char[] strN = Integer.toString(N).toCharArray();

		// 计算最后一个提升点的位置
		boolean isIncreasing = true;
		int upPointIndex = 0;
		for(int i = 0; i < strN.length - 1; i++) {
			if(strN[i] < strN[i + 1]) {
				upPointIndex = i + 1;
			}
			if(strN[i] > strN[i + 1]) {
				isIncreasing = false;
				break;
			}
		}

		// 一直为提升则返回原数
		if(isIncreasing) {
			return N;
		}

		// 得到提升点后的两个数字
		char firstNum = strN[upPointIndex];
		char secondNum = strN[upPointIndex + 1];

		// 对提升点进行修改
		if(firstNum >= secondNum) {
			strN[upPointIndex] = (char)(firstNum - 1);
			strN[upPointIndex + 1] = '9';
		} else {
			strN[upPointIndex + 1] = (char)(secondNum - 1);
		}

		// 将之后数字替换为9
		for(int i = upPointIndex + 2; i < strN.length; i++) {
			strN[i] = '9';
		}

		return Integer.parseInt(new String(strN));
	}
}