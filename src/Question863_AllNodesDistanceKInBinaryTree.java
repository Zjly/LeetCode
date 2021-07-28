import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * 提示：
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */

public class Question863_AllNodesDistanceKInBinaryTree {
	public static void main(String[] args) {

	}
}

class Solution863 {
	HashMap<Integer, List<Integer>> adjacentNodeHashMap = new HashMap<>();
	int nodeCount = 0;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		traverseTree(root);

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(target.val);
		for(int i = 0; i < k; i++) {
			if(nodeCount == visited.size()) {
			    break;
			}

			int queueSize = queue.size();
			for(int j = 0; j < queueSize; j++) {
				int qVal = queue.poll();
				visited.add(qVal);

				List<Integer> adjacentNodeList = adjacentNodeHashMap.get(qVal);
				if(adjacentNodeList != null) {
					for(int aVal : adjacentNodeList) {
						if(!visited.contains(aVal)) {
							queue.add(aVal);
						}
					}
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			result.add(queue.poll());
		}
		return result;
	}

	private void traverseTree(TreeNode root) {
		nodeCount++;

		if(root.left != null) {
			List<Integer> listRoot = adjacentNodeHashMap.getOrDefault(root.val, new ArrayList<>());
			listRoot.add(root.left.val);
			adjacentNodeHashMap.put(root.val, listRoot);

			List<Integer> listLeft = adjacentNodeHashMap.getOrDefault(root.left.val, new ArrayList<>());
			listLeft.add(root.val);
			adjacentNodeHashMap.put(root.left.val, listLeft);

			traverseTree(root.left);
		}

		if(root.right != null) {
			List<Integer> listRoot = adjacentNodeHashMap.getOrDefault(root.val, new ArrayList<>());
			listRoot.add(root.right.val);
			adjacentNodeHashMap.put(root.val, listRoot);

			List<Integer> listRight = adjacentNodeHashMap.getOrDefault(root.right.val, new ArrayList<>());
			listRight.add(root.val);
			adjacentNodeHashMap.put(root.right.val, listRight);

			traverseTree(root.right);
		}
	}
}