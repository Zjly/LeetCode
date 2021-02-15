/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * <p>
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */

public class Question485_MaxConsecutiveOnes {
	public static void main(String[] args) {

	}
}

class Solution485 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int index = 0;
		int maxLength = 0;
		int length = 0;
		while(index < nums.length) {
			if(nums[index] == 1) {
				length++;
			} else {
				if(length > maxLength) {
					maxLength = length;
				}
				length = 0;
			}

			index++;
		}

		if(length > maxLength) {
			maxLength = length;
		}

		return maxLength;
	}
}