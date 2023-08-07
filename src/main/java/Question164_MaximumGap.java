import java.util.Arrays;

/**
 * 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * <p>
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */

public class Question164_MaximumGap {
	public static void main(String[] args) {
		Solution164 solution164 = new Solution164();
		int[] nums = new int[]{3, 6, 9, 1};

		System.out.println(solution164.maximumGap(nums));
	}
}

class Solution164 {
	public int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);

		int gap = 0;

		for(int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;

			if(Math.abs(nums[i] - nums[j]) > gap) {
				gap = Math.abs(nums[i] - nums[j]);
			}
		}

		return gap;
	}
}