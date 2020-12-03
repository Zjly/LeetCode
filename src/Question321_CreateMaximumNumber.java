import java.util.Arrays;

/**
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */

public class Question321_CreateMaximumNumber {
	public static void main(String[] args) {
		Solution321 solution321 = new Solution321();
		int[] nums1 = new int[]{5, 6, 4};
		int[] nums2 = new int[]{5, 4, 8, 3};

		int[] result = solution321.maxNumber(nums1, nums2, 3);
		System.out.println(Arrays.toString(result));
	}
}

class Solution321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		int[] maxSubsequence = new int[k];

		// 寻找起点终点 start为从第一个数组中最少需要抽取几个字符 end为从第一个数组中最多需要抽取几个字符
		int start = Math.max(0, k - n), end = Math.min(k, m);

		// 对其进行循环，寻找每一个搭配
		for(int i = start; i <= end; i++) {
			// 分别寻找两个数组中指定长度的最大字符串
			int[] subsequence1 = maxSubsequence(nums1, i);
			int[] subsequence2 = maxSubsequence(nums2, k - i);
			int[] curMaxSubsequence = merge(subsequence1, subsequence2);
			if(compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
				System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
			}
		}
		return maxSubsequence;
	}

	public int[] maxSubsequence(int[] nums, int k) {
		int length = nums.length;
		int[] stack = new int[k];
		// 最左侧为栈底，使用栈底到栈顶单调递减的单调栈
		int top = -1;
		// 剩余的数的个数，即最多能移出栈的元素的个数
		int remain = length - k;
		for(int num : nums) {
			// 不符合单调栈，则对顺序不对的元素出栈
			while(top >= 0 && stack[top] < num && remain > 0) {
				top--;
				remain--;
			}
			// 元素入栈
			if(top < k - 1) {
				stack[++top] = num;
			} else {
				remain--;
			}
		}
		return stack;
	}

	public int[] merge(int[] subsequence1, int[] subsequence2) {
		int x = subsequence1.length, y = subsequence2.length;
		if(x == 0) {
			return subsequence2;
		}
		if(y == 0) {
			return subsequence1;
		}
		int mergeLength = x + y;
		int[] merged = new int[mergeLength];
		int index1 = 0, index2 = 0;

		// 进行合并
		for(int i = 0; i < mergeLength; i++) {
			// 1较大
			if(compare(subsequence1, index1, subsequence2, index2) > 0) {
				merged[i] = subsequence1[index1++];
			}
			// 2较大
			else {
				merged[i] = subsequence2[index2++];
			}
		}
		return merged;
	}

	public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
		int x = subsequence1.length, y = subsequence2.length;
		while(index1 < x && index2 < y) {
			int difference = subsequence1[index1] - subsequence2[index2];
			// 两者不同
			if(difference != 0) {
				return difference;
			}
			// 相同则继续比较
			index1++;
			index2++;
		}
		return (x - index1) - (y - index2);
	}
}
