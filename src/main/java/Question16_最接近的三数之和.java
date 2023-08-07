import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */

public class Question16_最接近的三数之和 {
	Solution16 solution16 = new Solution16();

	@Test
	public void test() {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		Assertions.assertEquals(2, solution16.threeSumClosest(nums, target));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/7/10 22:31
 */
class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int result = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int left = i + 1; left < nums.length; left++) {
				int right = nums.length - 1;

				while (left < right) {
					while (left < right && nums[i] + nums[left] + nums[right] > target) {
						if (Math.abs(nums[i] + nums[left] + nums[right] - target) < diff) {
							result = nums[i] + nums[left] + nums[right];
							diff = Math.abs(result - target);
							if (diff == 0) {
								return target;
							}
						}

						right--;
					}

					if (left < right && nums[i] + nums[left] + nums[right] == target) {
						return target;
					}

					if (left < right && Math.abs(nums[i] + nums[left] + nums[right] - target) < diff) {
						result = nums[i] + nums[left] + nums[right];
						diff = Math.abs(result - target);
						if (diff == 0) {
							return target;
						}
					}

					left++;
				}
			}
		}

		return result;
	}
}