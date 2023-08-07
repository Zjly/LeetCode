import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 764. 最大加号标志
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 */

public class Question764_LargestPlusSign {
	public static void main(String[] args) {
		Solution764 solution764 = new Solution764();
		int n = 2;
		int[][] mines = {{0, 0}, {1, 1}};
		System.out.println(solution764.orderOfLargestPlusSign(n, mines));
	}
}

class Solution764 {
	public int orderOfLargestPlusSign(int n, int[][] mines) {
		if(n * n == mines.length) {
			return 0;
		}

		HashMap<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
		HashMap<Integer, TreeSet<Integer>> columnMap = new HashMap<>();

		for(int[] mine : mines) {
			int row = mine[0];
			int column = mine[1];

			TreeSet<Integer> rowSet = rowMap.getOrDefault(row, new TreeSet<>());
			rowSet.add(column);
			rowMap.put(row, rowSet);

			TreeSet<Integer> columnSet = columnMap.getOrDefault(column, new TreeSet<>());
			columnSet.add(row);
			columnMap.put(column, columnSet);
		}

		int large = 0;
		for(int i = 0; i < n; i++) {
			TreeSet<Integer> iMap = rowMap.getOrDefault(i, new TreeSet<>());
			for(int j = 0; j < n; j++) {
				TreeSet<Integer> jMap = columnMap.getOrDefault(j, new TreeSet<>());
				if(!iMap.contains(j)) {
					int rowFloor = iMap.floor(j) != null ? iMap.floor(j) : -1;
					int rowCeiling = iMap.ceiling(j) != null ? iMap.ceiling(j) : n;
					int columnFloor = jMap.floor(i) != null ? jMap.floor(i) : -1;
					int columnCeiling = jMap.ceiling(i) != null ? jMap.ceiling(i) : n;
					int rowMin = Math.min(j - rowFloor, rowCeiling - j);
					int columnMin = Math.min(i - columnFloor, columnCeiling - i);
					large = Math.max(large, Math.min(rowMin, columnMin));
				}
			}
		}

		return large;
	}
}