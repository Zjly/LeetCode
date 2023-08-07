/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */

public class Question993_CousinsInBinaryTree {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		Solution993 solution993 = new Solution993();
		System.out.println(solution993.isCousins(n1, 4, 3));
	}
}

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution993 {
	public boolean isCousins(TreeNode root, int x, int y) {
		int[] i1 = depth(root, x, 0, 0);
		int[] i2 = depth(root, y, 0, 0);
		return (i1[0] == i2[0]) && (i1[1] != i2[1]);
	}

	private int[] depth(TreeNode root, int num, int d, int f) {
		if(root.val == num) {
			return new int[]{d, f};
		}
		if(root.left != null) {
			int[] p = depth(root.left, num, d + 1, root.val);
			if(p != null) {
			    return p;
			}
		}
		if(root.right != null) {
			return depth(root.right, num, d + 1, root.val);
		}
		return null;
	}
}