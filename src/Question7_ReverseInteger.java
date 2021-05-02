/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 */

public class Question7_ReverseInteger {
	public static void main(String[] args) {
		Solution7 solution7 = new Solution7();
		int x = -2147483412;
		System.out.println(solution7.reverse(x));
	}
}

class Solution7 {
	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) {
			return 0;
		}

		boolean positive = x >= 0;
		if(!positive) {
			x = -x;
		}

		StringBuilder sX = new StringBuilder(String.valueOf(x));
		sX.reverse();
		String max = "2147483647";
		if(sX.length() == 10 && sX.charAt(0) != '0') {
			for(int i = 0; i < 10; i++) {
				if(sX.charAt(i) > max.charAt(i)) {
					return 0;
				} else if(sX.charAt(i) < max.charAt(i)) {
				    break;
				}
			}
		}

		if(!positive) {
		    return -Integer.parseInt(sX.toString());
		}
		return Integer.parseInt(sX.toString());
	}
}