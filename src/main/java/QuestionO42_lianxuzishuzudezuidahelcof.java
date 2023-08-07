import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例 1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */

public class QuestionO42_lianxuzishuzudezuidahelcof {
	public static void main(String[] args) {

	}
}

class SolutionO42 {
	public int maxSubArray(int[] nums) {
		int dp = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int max = Integer.MIN_VALUE;
		queue.add(dp);
		for(int num : nums) {
			dp += num;
			max = Math.max(max, dp - queue.peek());
			queue.add(dp);
		}
		return max;
	}
}