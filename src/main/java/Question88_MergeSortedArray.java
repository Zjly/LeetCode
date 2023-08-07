/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */

public class Question88_MergeSortedArray {
	public static void main(String[] args) {

	}
}

class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = m + n - 1;
		int i1 = m - 1;
		int i2 = n - 1;

		while(i1 >= 0 && i2 >= 0) {
			if(nums1[i1] > nums2[i2]) {
			    nums1[p] = nums1[i1];
			    i1--;
			} else {
			    nums1[p] = nums2[i2];
			    i2--;
			}
			p--;
		}

		while(i2 >= 0) {
			nums1[p] = nums2[i2];
			i2--;
			p--;
		}
	}
}