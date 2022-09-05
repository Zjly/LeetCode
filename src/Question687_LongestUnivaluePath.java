/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 树的节点数的范围是 [0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 */

public class Question687_LongestUnivaluePath {
	public static void main(String[] args) {
		Solution687 solution687 = new Solution687();
		TreeNode root = Tool.createTreeFromArray(new Integer[]{5, 4, 5, 1, 1, null, 5});
		System.out.println(solution687.longestUnivaluePath(root));
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
class Solution687 {
	int maxLength = 0;

	public int longestUnivaluePath(TreeNode root) {
		getDepth(root);
		return maxLength;
	}

	public int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = getDepth(root.left);
		int right = getDepth(root.right);

		int length = 0;

		if(root.left != null && root.left.val == root.val) {
			length = left + 1;
			maxLength = Math.max(maxLength, length);
		}

		if(root.right != null && root.right.val == root.val) {
			maxLength = Math.max(maxLength, length + right + 1);
			length = Math.max(length, right + 1);
		}

		return length;
	}
}