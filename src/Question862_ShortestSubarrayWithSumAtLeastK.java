import java.util.Deque;
import java.util.LinkedList;

/**
 * 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 */

public class Question862_ShortestSubarrayWithSumAtLeastK {
	public static void main(String[] args) {

	}
}

class Solution862 {
	public int shortestSubarray(int[] nums, int k) {
		long[] dp = new long[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			dp[i + 1] = dp[i] + nums[i];
		}
		
		int minLength = Integer.MAX_VALUE;
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < dp.length; i++) {
			long num = dp[i];
			while(!deque.isEmpty() && num - dp[deque.peekFirst()] >= k) {
				minLength = Math.min(minLength, i - deque.pollFirst());
			}
			while(!deque.isEmpty() && num <= dp[deque.peekLast()]) {
			    deque.pollLast();
			}
			deque.addLast(i);
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
}