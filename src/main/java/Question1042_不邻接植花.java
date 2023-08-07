/**
 * 1042. 不邻接植花
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 * <p>
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 * <p>
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 */

public class Question1042_不邻接植花 {
	public static void main(String[] args) {

	}
}

class Solution1042 {
	public int[] gardenNoAdj(int n, int[][] paths) {
		boolean[][] matrix = new boolean[n][n];
		for(int[] path : paths) {
			matrix[path[0] - 1][path[1] - 1] = true;
			matrix[path[1] - 1][path[0] - 1] = true;
		}

		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			result[i] = dfs(result, matrix, i);
		}
		return result;
	}

	public int dfs(int[] result, boolean[][] matrix, int index) {
		boolean[] color = new boolean[5];
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[index][i]) {
			    color[result[i]] = true;
			}
		}

		for(int i = 1; i < 5; i++) {
			if(!color[i]) {
			    return i;
			}
		}

		return -1;
	}
}
