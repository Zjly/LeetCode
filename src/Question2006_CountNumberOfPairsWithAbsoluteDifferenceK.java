import java.util.HashMap;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * <p>
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 */

public class Question2006_CountNumberOfPairsWithAbsoluteDifferenceK {
	public static void main(String[] args) {

	}
}

class Solution2006 {
	public int countKDifference(int[] nums, int k) {
		HashMap<Integer, Integer> numCountsHashMap = new HashMap<>();

		for(int num : nums) {
			numCountsHashMap.put(num, numCountsHashMap.getOrDefault(num, 0) + 1);
		}

		int count = 0;

		for(int key : numCountsHashMap.keySet()) {
			if(numCountsHashMap.containsKey(key + k)) {
			    count += numCountsHashMap.get(key) * numCountsHashMap.get(key + k);
			}

			if(numCountsHashMap.containsKey(key - k)) {
				count += numCountsHashMap.get(key) * numCountsHashMap.get(key - k);
			}
		}

		return count / 2;
	}
}