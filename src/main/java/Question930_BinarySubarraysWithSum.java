import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 */

public class Question930_BinarySubarraysWithSum {
	public static void main(String[] args) {
		Solution930 solution930 = new Solution930();
		int[] nums = {1, 0, 1, 0, 1};
		int goal = 2;
		System.out.println(solution930.numSubarraysWithSum(nums, goal));
	}
}

class Solution930 {
	public int numSubarraysWithSum(int[] nums, int goal) {
		int result = 0;
		int dp = 0;
		HashMap<Integer, Integer> sumNumsCountHashMap = new HashMap<>();
		sumNumsCountHashMap.put(dp, 1);
		for(int num : nums) {
			dp += num;
			result += sumNumsCountHashMap.getOrDefault(dp - goal, 0);
			sumNumsCountHashMap.put(dp, sumNumsCountHashMap.getOrDefault(dp, 0) + 1);
		}

		return result;
	}
}