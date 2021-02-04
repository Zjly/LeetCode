/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */

public class Question643_MaximumAverageSubarrayI {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 12, -5, -6, 50, 3};
		int k = 4;
		Solution643 solution643 = new Solution643();
		System.out.println(solution643.findMaxAverage(nums, k));
	}
}

class Solution643 {
	public double findMaxAverage(int[] nums, int k) {
		if(k > nums.length) {
			k = nums.length;
		}

		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += nums[i];
		}
		int maxSum = sum;

		for(int i = k; i < nums.length; i++) {
			sum -= nums[i - k];
			sum += nums[i];
			if(sum > maxSum) {
				maxSum = sum;
			}
		}

		return (double)maxSum / k;
	}
}