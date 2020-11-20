/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * 提示 1：
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * <p>
 * 示例 4：
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * <p>
 * 示例 5：
 * 输入：nums = [0,0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 */

public class Question1493_LongestSubarrayOf1sAfterDeletingOneElement {
	public static void main(String[] args) {
		Solution1493 solution1493 = new Solution1493();
		int[] nums = {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0};
//		int[] nums = {1, 0, 0};
		System.out.println(solution1493.longestSubarray(nums));

	}
}

class Solution1493 {
	public int longestSubarray(int[] nums) {
		// 第一部分1的数量
		int first = 0;

		// 当前部分1的数量
		int current = 0;

		// 当前索引
		int index = 0;

		// 最大个数
		int max = 0;

		while(index < nums.length) {
			// 当前为1时数量+1
			if(nums[index] == 1) {
				current++;
			} else {
				// 中间仅含有1个0出现
				if(index != 0 && nums[index - 1] != 0) {
					// 结算是否超过最大值
					if(first + current > max) {
						max = first + current;
					}
					// 将当前部分视作第一部分
					first = current;
				} else {
					// 中间多个0出现重置第一部分
					first = 0;
				}
				// 重置当前部分
				current = 0;
			}
			index++;
		}

		// 遍历结束计算是否有大于最大值出现
		if(first + current > max) {
			max = first + current;
		}

		// 数组全为1需移除一个数字
		if(max == nums.length) {
			max--;
		}

		return max;
	}
}
