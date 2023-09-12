import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1462. 课程表 IV
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * <p>
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * <p>
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * 输出：[false,false]
 * 解释：没有先修课程对，所以每门课程之间是独立的。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * 输出：[true,true]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 每一对 [ai, bi] 都 不同
 * 先修课程图中没有环。
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= n - 1
 * ui != vi
 */

public class Question1462_课程表IV {
	Solution1462 solution1462 = new Solution1462();

	@Test
	public void test() {
	    int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		int[][] queries = {{0,1},{1,0}};
		System.out.println(solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
	}
}

/**
 * @author Zhang Lei
 * @date 2023/9/12 10:09
 */
class Solution1462 {
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		boolean[][] matrix = new boolean[numCourses][numCourses];

		int[] inDegree = new int[numCourses];
		for(int[] prerequisite : prerequisites) {
			int beginPoint = prerequisite[0];
			int endPoint = prerequisite[1];
			matrix[beginPoint][endPoint] = true;
			inDegree[endPoint]++;
		}

		Deque<Integer> deque = new ArrayDeque<>();

		// find in degree = 0
		for(int i = 0; i < inDegree.length; i++) {
			if(inDegree[i] == 0) {
				deque.add(i);
			}
		}

		while(!deque.isEmpty()) {
			int beginPoint = deque.pollFirst();

			for(int endPoint = 0; endPoint < numCourses; endPoint++) {
				if(matrix[beginPoint][endPoint]) {
					inDegree[endPoint]--;
					if(inDegree[endPoint] == 0) {
						deque.add(endPoint);
					}

					for(int row = 0; row < numCourses; row++) {
						matrix[row][endPoint] |= matrix[row][beginPoint];
					}
				}
			}
		}

		List<Boolean> result = new ArrayList<>(queries.length);
		for(int[] query : queries) {
			if(matrix[query[0]][query[1]]) {
				result.add(true);
			} else {
				result.add(false);
			}
		}

		return result;
	}
}