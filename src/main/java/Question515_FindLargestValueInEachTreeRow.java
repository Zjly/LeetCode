import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 */

public class Question515_FindLargestValueInEachTreeRow {
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
class Solution515 {
	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		if(root == null) {
			return result;
		}

		queue.offer(root);

		while(!queue.isEmpty()) {
		    int size = queue.size();
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < size; i++) {
				TreeNode p = queue.poll();
				max = Math.max(max, p.val);
				if(p.left != null) {
				    queue.offer(p.left);
				}
				if(p.right != null) {
					queue.offer(p.right);
				}
			}
			result.add(max);
		}

		return result;
	}
}