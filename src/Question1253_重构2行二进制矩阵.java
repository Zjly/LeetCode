import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1253. 重构 2 行二进制矩阵
 * 给你一个 2 行 n 列的二进制数组：
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * 示例 2：
 * <p>
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 */

public class Question1253_重构2行二进制矩阵 {}

/**
 * @author Zhang Lei
 * @date 2023/6/29 23:49
 */
class Solution1253 {
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		int sum = 0;
		int two = 0;
		for (int i = 0; i < colsum.length; i++) {
			sum += colsum[i];
			if (colsum[i] == 2) {
			    two++;
			}
		}

		if (upper + lower != sum || upper < two || lower < two) {
			return new ArrayList<>();
		}

		upper -= two;

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> result0 = new ArrayList<>();
		List<Integer> result1 = new ArrayList<>();
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 2) {
				result0.add(1);
				result1.add(1);
			} else if (colsum[i] == 0) {
				result0.add(0);
				result1.add(0);
			} else {
				if (upper > 0) {
					result0.add(1);
					result1.add(0);
					upper--;
				} else {
					result0.add(0);
					result1.add(1);
				}
			}
		}

		result.add(result0);
		result.add(result1);
		return result;
	}
}