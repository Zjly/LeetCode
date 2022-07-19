import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 */

public class Question1260_Shift2DGrid {
	public static void main(String[] args) {
		Solution1260 solution1260 = new Solution1260();
		int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int k = 12;
		System.out.println(solution1260.shiftGrid(grid, k));
	}
}

class Solution1260 {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int size = grid.length * grid[0].length;
		k = k % size;

		int p = (size - k) % size;

		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < grid.length; i++) {
			List<Integer> row = new ArrayList<>();
			for(int j = 0; j < grid[0].length; j++) {
				row.add(grid[p / grid[0].length][p % grid[0].length]);
				p++;
				p = p % size;
			}
			result.add(row);
		}

		return result;
	}
}