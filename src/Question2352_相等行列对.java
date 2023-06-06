import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */

public class Question2352_相等行列对 {
	Solution2352 solution2352 = new Solution2352();

	@Test
	public void test() {
		int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
		Assertions.assertEquals(1, solution2352.equalPairs(grid));
	}
}

class Solution2352 {
	public int equalPairs(int[][] grid) {
		HashMap<String, Integer> rowHashmap = new HashMap<>();
		HashMap<String, Integer> columnHashmap = new HashMap<>();

		for(int i = 0; i < grid.length; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int j = 0; j < grid[0].length; j++) {
				stringBuilder.append(grid[i][j] + " ");
			}

			String s = stringBuilder.toString();
			rowHashmap.put(s, rowHashmap.getOrDefault(s, 0) + 1);
		}

		for(int j = 0; j < grid[0].length; j++) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int i = 0; i < grid.length; i++) {
				stringBuilder.append(grid[i][j] + " ");
			}
			String s = stringBuilder.toString();
			columnHashmap.put(s, columnHashmap.getOrDefault(s, 0) + 1);
		}

		int count = 0;
		for(String key : rowHashmap.keySet()) {
			count += rowHashmap.get(key) * columnHashmap.getOrDefault(key, 0);
		}

		return count;
	}
}
