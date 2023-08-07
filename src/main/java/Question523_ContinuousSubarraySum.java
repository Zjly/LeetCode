/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * <p>
 * 示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 */

public class Question523_ContinuousSubarraySum {
	public static void main(String[] args) {

	}
}

class Solution523 {
	public boolean checkSubarraySum(int[] nums, int k) {
		int[] preSum = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
			if(i != 0 && preSum[i + 1] == preSum[i - 1]) {
			    return true;
			}
		}

		for(int i = 1; i < nums.length; i++) {
			if(preSum[i + 1] < k) {
				continue;
			}
			for(int j = 0; j < i; j++) {
				if((preSum[i + 1] - preSum[j]) % k == 0) {
					return true;
				}
			}
		}

		return false;
	}
}