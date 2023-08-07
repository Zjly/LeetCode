import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 * <p>
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */

public class Question628_MaximumProductOfThreeNumbers {
	public static void main(String[] args) {

	}
}

class Solution628 {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		int max1 = nums[length - 3] * nums[length - 2] * nums[length - 1];
		int max2 = nums[0] * nums[1] * nums[length - 1];
		return Math.max(max1, max2);
	}
}