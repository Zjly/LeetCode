import java.util.ArrayList;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 */

public class Question872_LeafSimilarTrees {
	public static void main(String[] args) {

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
class Solution872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> tree1 = new ArrayList<>();
		ArrayList<Integer> tree2 = new ArrayList<>();

		traverse(root1, tree1);
		traverse(root2, tree2);

		if(tree1.size() != tree2.size()) {
		    return false;
		}
		for(int i = 0; i < tree1.size(); i++) {
			if(!tree1.get(i).equals(tree2.get(i))) {
			    return false;
			}
		}
		return true;
	}

	public void traverse(TreeNode root, ArrayList<Integer> tree) {
		if(root.left != null) {
		    traverse(root.left, tree);
		}
		if(root.right != null) {
		    traverse(root.right, tree);
		}
		if(root.left == null && root.right == null) {
		    tree.add(root.val);
		}
	}
}
