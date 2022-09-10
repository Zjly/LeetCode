/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是 唯一 的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 */

public class Question669_TrimABinarySearchTree {
	public static void main(String[] args) {
		Solution669 solution669 = new Solution669();
		TreeNode root = Tool.createTreeFromArray(new Integer[]{1, 0, 2});
		System.out.println(solution669.trimBST(root, 1, 2));
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
class Solution669 {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		// 找到根节点位置
		while(root != null && (root.val < low || root.val > high)) {
			while(root != null && root.val < low) {
				root = root.right;
			}

			while(root != null && root.val > high) {
				root = root.left;
			}
		}

		if(root == null) {
			return null;
		}

		findLeft(root, root.left, low);
		findRight(root, root.right, high);

		return root;
	}

	public void findLeft(TreeNode pre, TreeNode p, int val) {
		if(p == null) {
			return;
		}

		while(p != null && p.val < val) {
			p = p.right;
		}

		pre.left = p;

		if(p == null) {
			return;
		}

		findLeft(p, p.left, val);
	}

	public void findRight(TreeNode pre, TreeNode p, int val) {
		if(p == null) {
			return;
		}

		while(p != null && p.val > val) {
			p = p.left;
		}

		pre.right = p;

		if(p == null) {
			return;
		}

		findRight(p, p.right, val);
	}
}