import java.util.*;

/**
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>
 * 示例 1：
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 示例 2：
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * 示例 3：
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * <p>
 * 示例 4：
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * <p>
 * 示例 5：
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>
 * 提示：
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 */

public class Question797_AllPathsFromSourceToTarget {
	public static void main(String[] args) {
		Solution797 solution797 = new Solution797();
		int[][] graph = {{1, 2}, {3}, {3}, {}};
		System.out.println(solution797.allPathsSourceTarget(graph));
	}
}

class Solution797 {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> listQueue = new LinkedList<>();
		List<Integer> initPath = new ArrayList<>();
		initPath.add(0);
		listQueue.offer(initPath);

		while(!listQueue.isEmpty()) {
			int size = listQueue.size();
			for(int i = 0; i < size; i++) {
				List<Integer> path = listQueue.poll();
				int lastNode = path.get(path.size() - 1);
				for(int j = 0; j < graph[lastNode].length; j++) {
					int target = graph[lastNode][j];
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(target);
					if(target == graph.length - 1) {
						result.add(newPath);
					} else {
						listQueue.offer(newPath);
					}
				}
			}
		}

		return result;
	}
}