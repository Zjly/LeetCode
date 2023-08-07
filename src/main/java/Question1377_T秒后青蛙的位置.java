import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1377. T 秒后青蛙的位置
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * <p>
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 * <p>
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 */

public class Question1377_T秒后青蛙的位置 {
	Solution1377 solution1377 = new Solution1377();

	@Test
	public void test1() {
		int n = 4;
		int[][] edges = {{2, 1}, {3, 2}, {4, 1}};
		int t = 4;
		int target = 1;
		Assertions.assertEquals(0, solution1377.frogPosition(n, edges, t, target));
	}
}

class Solution1377 {
	class TreeNode {
		int index;
		ArrayList<TreeNode> children;
		double ratio;

		public TreeNode(int index) {
			this.index = index;
			children = new ArrayList<>();
		}
	}

	public double frogPosition(int n, int[][] edges, int t, int target) {
		TreeNode[] treeNodes = new TreeNode[n];
		for(int i = 0; i < n; i++) {
			treeNodes[i] = new TreeNode(i);
		}
		treeNodes[0].ratio = 1;
		TreeNode parent = new TreeNode(-1);
		treeNodes[0].children.add(parent);

		for(int[] edge : edges) {
			int no1 = edge[0] - 1;
			int no2 = edge[1] - 1;
			treeNodes[no1].children.add(treeNodes[no2]);
			treeNodes[no2].children.add(treeNodes[no1]);
		}

		Queue<TreeNode[]> queue = new LinkedList<>();
		queue.add(new TreeNode[]{treeNodes[0], parent});
		int time = 0;
		while(!queue.isEmpty() && time <= t) {
			int size = queue.size();

			for(int i = 0; i < size; i++) {
				TreeNode[] tN = queue.poll();
				TreeNode currentTreeNode = tN[0];
				TreeNode parentTreeNode = tN[1];

				if(currentTreeNode.index == target - 1) {
					// 没有子节点所以可以一直原地 || 时间刚好是t
					if(currentTreeNode.children.size() == 1 || time == t) {
						return currentTreeNode.ratio;
					} else {
						return 0;
					}
				}

				for(TreeNode child : currentTreeNode.children) {
					if(child.index != parentTreeNode.index) {
						child.ratio = currentTreeNode.ratio / (currentTreeNode.children.size() - 1);
						queue.offer(new TreeNode[]{child, currentTreeNode});
					}
				}
			}

			time++;
		}

		return 0;
	}
}