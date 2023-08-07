/**
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * <p>
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：[100]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */

public class Question978_LongestTurbulentSubarray {
	public static void main(String[] args) {
		Solution978 solution978 = new Solution978();
		int[] arr1 = new int[]{1};
		int[] arr2 = new int[]{1, 2, 3};
		int[] arr3 = new int[]{1, 1};
		int[] arr4 = new int[]{1, 1, 1};
		int[] arr5 = new int[]{1, 2, 1, 2, 1};
		int[] arr6 = new int[]{1, 2, 2, 1, 1, 2};
		int[] arr7 = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
		System.out.println(solution978.maxTurbulenceSize(arr1));
		System.out.println(solution978.maxTurbulenceSize(arr2));
		System.out.println(solution978.maxTurbulenceSize(arr3));
		System.out.println(solution978.maxTurbulenceSize(arr4));
		System.out.println(solution978.maxTurbulenceSize(arr5));
		System.out.println(solution978.maxTurbulenceSize(arr6));
		System.out.println(solution978.maxTurbulenceSize(arr7));
	}
}

class Solution978 {
	public int maxTurbulenceSize(int[] arr) {
		if(arr.length == 1) {
			return 1;
		}
		int maxLength = 0;
		// 左边与右边界
		int left = 0;
		int right = 1;
		// 前两个数之间的关系
		boolean positive = true;

		while(right < arr.length) {
			int result = arr[right] - arr[right - 1];

			// 前后相等则进行判定并使得边界向前移动
			if(result == 0) {
				if(right - left > maxLength) {
					maxLength = right - left;
				}
				left = right;
				right++;
				continue;
			}

			// 窗口长度为2，计算首次两数关系
			if(left + 1 == right) {
				positive = result > 0;
				right++;
				continue;
			}

			// 与positive比较，进行判断
			if(result > 0 ^ positive) {
				right++;
				positive = !positive;
			} else {
				if(right - left > maxLength) {
					maxLength = right - left;
				}
				left = right - 1;
				right++;
			}
		}

		if(right - left > maxLength) {
			maxLength = right - left;
		}

		return maxLength;
	}
}