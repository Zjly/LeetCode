import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */

public class Question18_四数之和 {
	Solution18 solution18 = new Solution18();

	@Test
	public void test() {
		int[] nums = {2, 2, 2, 2, 2};
		int target = 8;
		System.out.println(solution18.fourSum(nums, target));
	}

	@Test
	public void test2() {
		int[] nums = {-2, -1, -1, 1, 1, 2, 2};
		int target = 0;
		System.out.println(solution18.fourSum(nums, target));
	}

	@Test
	public void test3() {
		int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
		int target = -294967296;
		System.out.println(solution18.fourSum(nums, target));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/7/15 0:43
 */
class Solution18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = length - 1;
				while (left < right) {
					if (left != j + 1 && nums[left] == nums[left - 1]) {
						left++;
						continue;
					}

					while (left < right && (long)nums[i] + nums[j] + nums[left] + nums[right] > target) {
						right--;
					}

					if (left < right && (long)nums[i] + nums[j] + nums[left] + nums[right] == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
					}

					left++;
				}
			}
		}

		return result;
	}
}