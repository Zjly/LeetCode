import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 */

public class Question653_TwoSumIVInputIsABST {
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
class Solution653 {
	boolean target = false;
	Set<Integer> targetSet = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		find(root, k);

		return target;
	}

	public void find(TreeNode root, int k) {
		if(target || root == null) {
		    return;
		}

		if(targetSet.contains(root.val)) {
		    target = true;
			return;
		}

		targetSet.add(k - root.val);
		find(root.left, k);
		find(root.right, k);
	}
}