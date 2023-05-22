import org.junit.jupiter.api.Test;

/**
 * 1080. 根到叶路径上的不足节点
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 * <p>
 * 叶子节点，就是没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,-3,-5,null,4,null], limit = -1
 * 输出：[1,null,-3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 5000] 内
 * -105 <= Node.val <= 105
 * -109 <= limit <= 109
 */

public class Question1080_根到叶路径上的不足节点 {
	Solution1080 solution1080 = new Solution1080();

	@Test
	public void test1() {
		TreeNode root = Tool.createTreeFromArray(new Integer[]{10, 5, 10});
		int limit = 21;
		TreeNode nRoot = solution1080.sufficientSubset(root, limit);
		System.out.println(nRoot);
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
class Solution1080 {
	public TreeNode sufficientSubset(TreeNode root, int limit) {
		boolean b = dfs(root, 0, limit);
		return b ? null : root;
	}

	public boolean dfs(TreeNode root, int sum, int limit) {
		if(root == null) {
			return false;
		}

		sum += root.val;

		if(root.left == null && root.right == null && sum < limit) {
			return true;
		}

		boolean left = dfs(root.left, sum, limit);
		boolean right = dfs(root.right, sum, limit);

		if(left && right) {
			return true;
		} else if(left && root.right == null) {
			return true;
		} else if(right && root.left == null) {
			return true;
		} else if(left) {
			root.left = null;
		} else if(right) {
			root.right = null;
		}

		return false;
	}
}