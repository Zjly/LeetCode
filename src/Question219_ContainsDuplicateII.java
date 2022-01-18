import java.util.HashMap;
import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */

public class Question219_ContainsDuplicateII {
	public static void main(String[] args) {
		Solution219 solution219 = new Solution219();
		int[] nums = {1, 2, 3, 1};
		int k = 3;
		System.out.println(solution219.containsNearbyDuplicate(nums, k));
	}
}

class Solution219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> numHashSet = new HashSet<>();

		for(int i = 0; i < nums.length; i++) {
			if(i > k) {
				numHashSet.remove(nums[i - k - 1]);
			}
			if(numHashSet.contains(nums[i])) {
				return true;
			}
			numHashSet.add(nums[i]);
		}

		return false;
	}
}