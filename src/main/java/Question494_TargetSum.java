/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 */

public class Question494_TargetSum {
	public static void main(String[] args) {
		Solution494 solution494 = new Solution494();
		int[] nums = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution494.findTargetSumWays(nums, target));
	}
}

class Solution494 {
	public int findTargetSumWays(int[] nums, int target) {
		int[] dp = new int[2001];
		dp[1000 + nums[0]] += 1;
		dp[1000 - nums[0]] += 1;
		for(int i = 1; i < nums.length; i++) {
			int num = nums[i];
			int[] nDp = new int[2001];
			for(int j = 0; j < dp.length; j++) {
				if(dp[j] != 0) {
					nDp[j + num] += dp[j];
					nDp[j - num] += dp[j];
				}
			}
			dp = nDp;
		}

		return dp[1000 + target];
	}
}