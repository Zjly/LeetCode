/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 */

public class Question965_UnivaluedBinaryTree {
	public static void main(String[] args) {

	}
}

/*
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
class Solution965 {
	int val = -1;
	boolean same = true;

	public boolean isUnivalTree(TreeNode root) {
		dfs(root);

		return same;
	}

	public void dfs(TreeNode root) {
		if(!same || root == null) {
			return;
		}

		if(val != -1 && root.val != val) {
			same = false;
		} else {
			val = root.val;
			dfs(root.left);
			dfs(root.right);
		}
	}
}