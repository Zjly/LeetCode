import java.util.Arrays;

/**
 * 1775. 通过最少操作次数使数组的和相等
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * <p>
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * <p>
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 * <p>
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */

public class Question1775_EqualSumArraysWithMinimumNumberOfOperations {
	public static void main(String[] args) {

	}
}

class Solution1775 {
	public int minOperations(int[] nums1, int[] nums2) {
		int length1 = nums1.length, length2 = nums2.length, ans = 0;

		if(length1 * 6 < length2 || length2 * 6 < length1) {
			return -1;
		}

		int target = Arrays.stream(nums1).sum() - Arrays.stream(nums2).sum();
		if(target < 0) {
			return minOperations(nums2, nums1);
		}

		int[] mp = new int[6];
		for(int x : nums1) {
			mp[x - 1]++; //对于每个数可以减少的量
		}
		for(int x : nums2) {
			mp[6 - x]++; //对于每个数可以增加的量
		}

		for(int i = 5; i >= 1 && target > 0; i--) {
			int cnt = Math.min(mp[i], (target + i - 1) / i); //最少需要的个数 +(i- 1)为了向上取整。
			ans += cnt;
			target -= cnt * i; //减去能够减少的最大值，若小于等等于0，代表已经使得两个数组相等
		}

		return ans;
	}
}