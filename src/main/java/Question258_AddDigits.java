/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 * <p>
 * 输入: num = 0
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 231 - 1
 * <p>
 * <p>
 * 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 */

public class Question258_AddDigits {
	public static void main(String[] args) {

	}
}

class Solution258 {
	public int addDigits(int num) {
		while(num >= 10) {
		    num = num / 10 + num % 10;
		}

		return num;
	}
}