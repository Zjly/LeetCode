/**
 * 1031. 两个非重叠子数组的最大和
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 * <p>
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * <p>
 * 子数组是数组的一个 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */

public class Question1031_两个非重叠子数组的最大和 {
	public static void main(String[] args) {
		Solution1031 solution1031 = new Solution1031();
		int[] nums = {8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12};
		int firstLen = 5;
		int secondLen = 4;
		System.out.println(solution1031.maxSumTwoNoOverlap(nums, firstLen, secondLen));
	}
}

class Solution1031 {
	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		int[] dp = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			dp[i + 1] = dp[i] + nums[i];
		}

		int maxSum = 0;
		int firstIndex = 0;
		while(firstIndex + firstLen <= nums.length) {
			int secondIndex = 0;
			int firstSum = dp[firstIndex + firstLen] - dp[firstIndex];

			while(secondIndex + secondLen <= firstIndex) {
				maxSum = Math.max(maxSum,
						firstSum + dp[secondIndex + secondLen] - dp[secondIndex]);
				secondIndex++;
			}
			secondIndex = firstIndex + firstLen;
			while(secondIndex + secondLen <= nums.length) {
				maxSum = Math.max(maxSum,
						firstSum + dp[secondIndex + secondLen] - dp[secondIndex]);
				secondIndex++;
			}
			firstIndex++;
		}

		return maxSum;
	}
}