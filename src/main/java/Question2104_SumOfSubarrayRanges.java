import java.util.Arrays;

/**
 * 2104. 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * 示例 3：
 * <p>
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 */

public class Question2104_SumOfSubarrayRanges {
	public static void main(String[] args) {

	}
}

class Solution2104 {
	public long subArrayRanges(int[] nums) {
		long sum = 0;

		int[][] dpMax = new int[nums.length][nums.length];
		int[][] dpMin = new int[nums.length][nums.length];

		for(int i = 0; i < nums.length; i++) {
			dpMax[i][i] = nums[i];
			dpMin[i][i] = nums[i];
		}

		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				dpMax[i][j] = Math.max(dpMax[i][j - 1], nums[j]);
				dpMin[i][j] = Math.min(dpMin[i][j - 1], nums[j]);
				sum += dpMax[i][j] - dpMin[i][j];
			}
		}

		return sum;
	}
}