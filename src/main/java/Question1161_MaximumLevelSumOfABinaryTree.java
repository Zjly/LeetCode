import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 */

public class Question1161_MaximumLevelSumOfABinaryTree {
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
class Solution1161 {
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int maxVal = Integer.MIN_VALUE;
		int maxLevel = Integer.MIN_VALUE;

		int level = 1;

		while(!queue.isEmpty()) {
			int size = queue.size();
			int val = 0;

			for(int i = 0; i < size; i++) {
				TreeNode p = queue.poll();
				val += p.val;

				if(p.left != null) {
					queue.offer(p.left);
				}

				if(p.right != null) {
					queue.offer(p.right);
				}
			}

			if(val > maxVal) {
				maxVal = val;
				maxLevel = level;
			}

			level++;
		}

		return maxLevel;
	}
}