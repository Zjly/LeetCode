/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 */

public class Question1026_节点与其祖先之间的最大差值 {
	public static void main(String[] args) {

	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution1026 {
	int maxDiff = 0;

	public int maxAncestorDiff(TreeNode root) {
		dfs(root);
		return maxDiff;
	}

	public int[] dfs(TreeNode root) {
		if(root == null) {
			return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
		}
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int min = Math.min(left[0], right[0]);
		int max = Math.max(left[1], right[1]);
		if(min != Integer.MAX_VALUE) {
			maxDiff = Math.max(maxDiff, Math.abs(root.val - min));
		}

		if(max != Integer.MIN_VALUE) {
			maxDiff = Math.max(maxDiff, Math.abs(root.val - max));
		}
		return new int[]{Math.min(min, root.val), Math.max(max, root.val)};
	}
}