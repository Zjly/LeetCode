import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 */

public class Question1302_DeepestLeavesSum {
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

class Solution1302 {
	public int deepestLeavesSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int sum = 0;

		while(!queue.isEmpty()) {
			int size = queue.size();
			int pSum = 0;
			for(int i = 0; i < size; i++) {
				TreeNode p = queue.poll();
				pSum += p.val;

				if(p.left != null) {
					queue.add(p.left);
				}

				if(p.right != null) {
					queue.add(p.right);
				}
			}
			sum = pSum;
		}

		return sum;
	}
}