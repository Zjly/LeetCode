import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

public class Question462_MinimumMovesToEqualArrayElementsII {
	public static void main(String[] args) {
		Solution462 solution462 = new Solution462();
		int[] nums = {1, 9, 9, 9, 9, 9, 10, 100};
		System.out.println(solution462.minMoves2(nums));
	}
}

class Solution462 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);

		int mid = nums[nums.length / 2];

		int count = 0;
		for(int num : nums) {
			count += Math.abs(num - mid);
		}

		return count;
	}
}
