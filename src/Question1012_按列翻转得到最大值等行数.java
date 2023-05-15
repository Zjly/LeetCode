import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 1072. 按列翻转得到最大值等行数
 * 给定 m x n 矩阵 matrix 。
 * <p>
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * <p>
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 */

public class Question1012_按列翻转得到最大值等行数 {
	Solution1012 solution1012 = new Solution1012();

	@Test
	public void test1() {
		int[][] matrix = {{0, 1}, {1, 0}};
		Assertions.assertEquals(2, solution1012.maxEqualRowsAfterFlips(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = {{0, 1}, {1, 1}};
		Assertions.assertEquals(1, solution1012.maxEqualRowsAfterFlips(matrix));
	}
}

class Solution1012 {
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		HashMap<String, Integer> zCount = new HashMap<>();
		HashMap<String, Integer> fCount = new HashMap<>();
		for(int[] array : matrix) {
			String z = getStr(array, false);
			String f = getStr(array, true);
			zCount.put(z, zCount.getOrDefault(z, 0) + 1);
			fCount.put(f, fCount.getOrDefault(f, 0) + 1);
		}

		int max = 0;
		for(String z : zCount.keySet()) {
			int count = zCount.get(z) + fCount.getOrDefault(z, 0);
			max = Math.max(max, count);
		}

		return max;
	}

	private String getStr(int[] array, boolean reverse) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int num : array) {
			if(reverse) {
				stringBuilder.append(num == 1 ? 0 : 1);
			} else {
				stringBuilder.append(num);
			}
		}
		return stringBuilder.toString();
	}
}