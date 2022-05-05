/**
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */

public class Question713_SubarrayProductLessThanK {
	public static void main(String[] args) {
		Solution713 solution713 = new Solution713();
		int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
		int k = 19;
		System.out.println(solution713.numSubarrayProductLessThanK(nums, k));
	}
}

class Solution713 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int product = nums[0];
		int count = 0;
		while(left < nums.length) {
			while(right + 1 < nums.length && product * nums[right + 1] < k) {
				right++;
				product *= nums[right];
			}

			if(left == right) {
				if(nums[left] < k) {
					count++;
				}
			} else {
				count += right - left + 1;
			}

			product /= nums[left];
			left++;

			if(left < nums.length && left > right) {
				right = left;
				product = nums[left];
			}
		}

		return count;
	}
}