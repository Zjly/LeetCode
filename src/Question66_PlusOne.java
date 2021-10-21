/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */

public class Question66_PlusOne {
	public static void main(String[] args) {

	}
}

class Solution66 {
	public int[] plusOne(int[] digits) {
		digits[digits.length - 1] += 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] == 10 && i != 0) {
				digits[i] = 0;
				digits[i - 1] += 1;
			}
		}

		if(digits[0] == 10) {
		    int[] result = new int[digits.length + 1];
		    result[0] = 1;
		    result[1] = 0;
			System.arraycopy(digits, 1, result, 2, digits.length - 1);
		    return result;
		}

		return digits;
	}
}