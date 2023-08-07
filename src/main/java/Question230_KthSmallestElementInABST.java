/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */

public class Question230_KthSmallestElementInABST {
	public static void main(String[] args) {
		Solution230 solution230 = new Solution230();

		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2, p1, null);
		TreeNode p4 = new TreeNode(4);
		TreeNode p3 = new TreeNode(3, p2, p4);
		TreeNode p6 = new TreeNode(6);
		TreeNode p5 = new TreeNode(5, p3, p6);
		System.out.println(solution230.kthSmallest(p5, 6));

//		TreeNode p2 = new TreeNode(2);
//		TreeNode p1 = new TreeNode(1, null, p2);
//		System.out.println(solution230.kthSmallest(p1, 2));
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
class Solution230 {
	TreeNode result = null;
	int countP = 0;

	public int kthSmallest(TreeNode root, int k) {
		nodeCount(root, k);
		return result.val;
	}

	public void nodeCount(TreeNode root, int k) {
		if(result != null || root == null) {
		    return;
		}
		nodeCount(root.left, k);
		countP++;
		if(countP == k) {
		    result = root;
		}
		nodeCount(root.right, k);
	}
}