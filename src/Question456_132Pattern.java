import java.util.Stack;

/**
 * 456. 132模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 */

public class Question456_132Pattern {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 0, 1, -4, -3};
		Solution456 solution456 = new Solution456();
		System.out.println(solution456.find132pattern(nums));
	}
}

class Solution456 {
	public boolean find132pattern(int[] nums) {
		int[] minNums = new int[nums.length];
		int minNum = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			minNums[i] = minNum;
			minNum = Math.min(minNum, nums[i]);
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(nums[nums.length - 1]);
		for(int i = nums.length - 2; i > 0; i--) {
			int num = nums[i];

			int maxNum = Integer.MIN_VALUE;
			while(!stack.empty() && stack.peek() < num) {
			    maxNum = stack.pop();
			}
			if(maxNum > minNums[i]) {
			    return true;
			}
			stack.push(num);
		}

		return false;
	}
}