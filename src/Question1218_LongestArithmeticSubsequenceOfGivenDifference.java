import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * <p>
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 * <p>
 * 提示：
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 */

public class Question1218_LongestArithmeticSubsequenceOfGivenDifference {
	public static void main(String[] args) {
		Solution1218 solution1218 = new Solution1218();
		int[] arr = {3, 4, -3, -2, -4};
		int difference = -5;
		System.out.println(solution1218.longestSubsequence(arr, difference));
	}
}

class Solution1218 {
	public int longestSubsequence(int[] arr, int difference) {
		HashMap<Integer, ArrayList<Integer>> numIndexHashMap = new HashMap<>();

		int[] dp = new int[arr.length];
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int needNum = num - difference;

			ArrayList<Integer> needIndexArrayList = numIndexHashMap.getOrDefault(needNum, new ArrayList<>());
			for(int needIndex : needIndexArrayList) {
				dp[i] = Math.max(dp[i], dp[needIndex] + 1);
				max = Math.max(dp[i], max);
			}

			ArrayList<Integer> indexArrayList = numIndexHashMap.getOrDefault(num, new ArrayList<>());
			indexArrayList.add(i);
			numIndexHashMap.put(num, indexArrayList);
		}

		return max + 1;
	}
}