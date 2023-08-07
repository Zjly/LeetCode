import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 1130. 叶值的最小代价生成树
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 * <p>
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * <p>
 * 如果一个节点有 0 个子节点，那么该节点为叶节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [4,11]
 * 输出：44
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * 答案保证是一个 32 位带符号整数，即小于 231 。
 */

public class Question1130_叶值的最小代价生成树 {
	Solution1130 solution1130 = new Solution1130();

	@Test
	public void test1() {
		int[] arr = {6, 2, 4};
		Assertions.assertEquals(32, solution1130.mctFromLeafValues(arr));
	}

	@Test
	public void test2() {
		int[] arr = {1, 11, 8, 8, 13, 2, 6, 1, 7, 6, 8, 10, 14, 9, 13, 15, 11, 2, 13, 15};
		Assertions.assertEquals(1950, solution1130.mctFromLeafValues(arr));
	}
}

class Solution1130 {
	private final HashMap<Long, Integer> dfsHashMap = new HashMap<>();

	public int mctFromLeafValues(int[] arr) {
		int[][] maxNum = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			maxNum[i][i] = arr[i];
			for(int j = i + 1; j < arr.length; j++) {
				maxNum[i][j] = Math.max(maxNum[i][j - 1], arr[j]);
			}
		}

		return dfs(arr, maxNum, 0, arr.length - 1);
	}

	private int dfs(int[] arr, int[][] maxNum, int left, int right) {
		if(right - left == 0) {
			return 0;
		} else if(right - left == 1) {
			return arr[left] * arr[right];
		}

		long key = (1L << left) | (1L << right);
		if(dfsHashMap.containsKey(key)) {
			return dfsHashMap.get(key);
		}

		int minSum = Integer.MAX_VALUE;
		for(int medium = left; medium < right; medium++) {
			int leftSum = dfs(arr, maxNum, left, medium);
			int rightSum = dfs(arr, maxNum, medium + 1, right);

			minSum = Math.min(leftSum + rightSum + maxNum[left][medium] * maxNum[medium + 1][right], minSum);
		}

		dfsHashMap.put(key, minSum);
		return minSum;
	}
}