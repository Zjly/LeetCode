/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * <p>
 * 注意:
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 */

public class Question493_ReversePairs {
	public static void main(String[] args) {

	}
}

class Solution493 {
	public int reversePairs(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		return reversePairsRecursive(nums, 0, nums.length - 1);
	}

	public int reversePairsRecursive(int[] nums, int left, int right) {
		if(left == right) {
			return 0;
		} else {
			int mid = (left + right) / 2;
			int n1 = reversePairsRecursive(nums, left, mid);
			int n2 = reversePairsRecursive(nums, mid + 1, right);
			int ret = n1 + n2;

			// 首先统计下标对的数量
			int i = left;
			int j = mid + 1;
			while(i <= mid) {
				while(j <= right && (long)nums[i] > 2 * (long)nums[j]) {
					j++;
				}
				ret += j - mid - 1;
				i++;
			}

			// 随后合并两个排序数组
			int[] sorted = new int[right - left + 1];
			int p1 = left, p2 = mid + 1;
			int p = 0;
			while(p1 <= mid || p2 <= right) {
				if(p1 > mid) {
					sorted[p++] = nums[p2++];
				} else if(p2 > right) {
					sorted[p++] = nums[p1++];
				} else {
					if(nums[p1] < nums[p2]) {
						sorted[p++] = nums[p1++];
					} else {
						sorted[p++] = nums[p2++];
					}
				}
			}
			for(int k = 0; k < sorted.length; k++) {
				nums[left + k] = sorted[k];
			}
			return ret;
		}
	}
}