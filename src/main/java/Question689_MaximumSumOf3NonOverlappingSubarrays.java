import java.util.Arrays;

/**
 * 689. 三个无重叠子数组的最大和
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 */

public class Question689_MaximumSumOf3NonOverlappingSubarrays {
	public static void main(String[] args) {
		Solution689 solution689 = new Solution689();
		int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
		int k = 2;
		System.out.println(Arrays.toString(solution689.maxSumOfThreeSubarrays(nums, k)));
	}
}

class Solution689 {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] ans = new int[3];
		int sum1 = 0, maxSum1 = 0, maxSum1Index = 0;
		int sum2 = 0, maxSum12 = 0, maxSum12Index1 = 0, maxSum12Index2 = 0;
		int sum3 = 0, maxSum123 = 0;

		for(int i = 2 * k; i < nums.length; i++) {
			sum1 += nums[i - 2 * k];
			sum2 += nums[i - k];
			sum3 += nums[i];

			if(i >= 3 * k - 1) {
				if(sum1 > maxSum1) {
					maxSum1 = sum1;
					maxSum1Index = i - 3 * k + 1;
				}
				if(maxSum1 + sum2 > maxSum12) {
					maxSum12 = maxSum1 + sum2;
					maxSum12Index1 = maxSum1Index;
					maxSum12Index2 = i - 2 * k + 1;
				}
				if(maxSum12 + sum3 > maxSum123) {
					maxSum123 = maxSum12 + sum3;
					ans[0] = maxSum12Index1;
					ans[1] = maxSum12Index2;
					ans[2] = i - k + 1;
				}

				sum1 -= nums[i - 3 * k + 1];
				sum2 -= nums[i - 2 * k + 1];
				sum3 -= nums[i - k + 1];
			}
		}

		return ans;
	}
}