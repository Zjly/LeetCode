/**
 * 1043. 分隔数组以得到最大和
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * 示例 3：
 * <p>
 * 输入：arr = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */

public class Question1043_分隔数组以得到最大和 {
	public static void main(String[] args) {
		Solution1043 solution1043 = new Solution1043();
		int[] arr = {1, 15, 7, 9, 2, 5, 10};
		int k = 3;
		System.out.println(solution1043.maxSumAfterPartitioning(arr, k));
	}
}

class Solution1043 {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length];
		int max = 0;
		for(int i = 0; i < k; i++) {
			max = Math.max(max, arr[i]);
			dp[i] = max * (i + 1);
		}

		for(int i = k; i < arr.length; i++) {
			int pMax = 0;
			for(int j = 0; j < k; j++) {
				pMax = Math.max(pMax, arr[i - j]);
				dp[i] = Math.max(dp[i], dp[i - j - 1] + pMax * (j + 1));
			}
		}

		return dp[arr.length - 1];
	}
}