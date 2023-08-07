import java.util.HashMap;

/**
 * 1814. 统计一个数组中好对子的数目
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */

public class Question1814_CountNicePairsInAnArray {
	public static void main(String[] args) {
		Solution1814 solution1814 = new Solution1814();
		System.out.println(solution1814.countNicePairs(new int[]{42,11,1,97}));
	}
}

class Solution1814 {
	public int countNicePairs(int[] nums) {
		HashMap<Integer, Integer> countHahMap = new HashMap<>();
		for(int num : nums) {
			int score = num - rev(num);
			countHahMap.put(score, countHahMap.getOrDefault(score, 0) + 1);
		}

		int count = 0;
		int MOD = 1000000007;
		for(int key : countHahMap.keySet()) {
			int value = countHahMap.get(key);
			count += ((long)value * (value - 1) / 2) % MOD;
			count = count % MOD;
		}

		return count;
	}

	public int rev(int num) {
		return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
	}
}
