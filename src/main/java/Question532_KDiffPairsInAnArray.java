import java.util.HashSet;

/**
 * 532. 数组中的 k-diff 数对
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3：
 * <p>
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */

public class Question532_KDiffPairsInAnArray {
	public static void main(String[] args) {
		Solution532 solution532 = new Solution532();
		int[] nums = {3, 1, 4, 1, 5};
		int k = 2;
		System.out.println(solution532.findPairs(nums, k));
	}
}

class Solution532 {
	public int findPairs(int[] nums, int k) {
		if(k == 0) {
			HashSet<Integer> hashSet = new HashSet<>();
			HashSet<Integer> got = new HashSet<>();
			int count = 0;
			for(int num : nums) {
				if(hashSet.contains(num) && !got.contains(num)) {
					count++;
					got.add(num);
				} else {
					hashSet.add(num);
				}
			}
			return count;
		}

		HashSet<Integer> hashSet = new HashSet<>();
		for(int num : nums) {
			hashSet.add(num);
		}

		int count = 0;
		for(int num : hashSet) {
			if(hashSet.contains(num + k)) {
				count++;
			}
		}

		return count;
	}
}