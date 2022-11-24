/**
 * 795. 区间子数组个数
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= left <= right <= 109
 */

public class Question795_NumberOfSubarraysWithBoundedMaximum {
	public static void main(String[] args) {
		Solution795 solution795 = new Solution795();
		int[] nums = {1, 2, 0, 0};
		int left = 1;
		int right = 3;
		System.out.println(solution795.numSubarrayBoundedMax(nums, left, right));
	}
}

class Solution795 {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		long count = 0;
		long lastRight = -1;
		long lastLeft = -1;
		long dnCount = 0;
		boolean b = false;

		for(int i = 0; i < nums.length; i++) {
			long num = nums[i];
			if(num > right) {
				if(lastLeft != -1) {
					dnCount += (i - lastLeft + 1) * (i - lastLeft) / 2;
				}

				long allCount = (i - lastRight - 1 + 1) * (i - lastRight - 1) / 2;
				count += allCount - dnCount;
				lastRight = i;
				dnCount = 0;
				lastLeft = -1;
			} else if(num < left) {
				if(lastLeft == -1) {
					lastLeft = i;
				}
			} else {
				b = true;
				if(lastLeft != -1) {
					dnCount += (i - lastLeft + 1) * (i - lastLeft) / 2;
					lastLeft = -1;
				}
			}
		}

		if(lastLeft != -1) {
			dnCount += (nums.length - lastLeft + 1) * (nums.length - lastLeft) / 2;
		}

		if(b) {
			count += (nums.length - lastRight - 1 + 1) * (nums.length - lastRight - 1) / 2 - dnCount;
		}

		return (int)count;
	}
}