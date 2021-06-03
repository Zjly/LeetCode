import java.util.HashMap;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */

public class Question525_ContiguousArray {
	public static void main(String[] args) {
		Solution525 solution525 = new Solution525();
		int[] nums = {0, 0, 1, 0, 0, 0, 1, 1};
		System.out.println(solution525.findMaxLength(nums));
	}
}

class Solution525 {
	public int findMaxLength(int[] nums) {
		int[] countOne = new int[nums.length + 1];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int length = 0;
		for(int i = 0; i < nums.length; i++) {
			countOne[i + 1] += nums[i] + countOne[i];

			int key = i - 2 * countOne[i];
			if(!hashMap.containsKey(key)) {
				hashMap.put(key, i);
			}

			key = i - 2 * countOne[i + 1] + 1;
			if(hashMap.containsKey(key)) {
				length = Math.max(length, i - hashMap.get(key) + 1);
			}
		}

		return length;
	}
}