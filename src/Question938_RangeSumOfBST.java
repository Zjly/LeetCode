import java.util.Stack;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 */

public class Question938_RangeSumOfBST {
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
class Solution938 {
	public int rangeSumBST(TreeNode root, int low, int high) {
		Stack<TreeNode> stack = new Stack<>();

		TreeNode p = root;
		while(p.val != low) {
		    if(p.val > low) {
		        stack.push(p);
		        p = p.left;
		    } else {
		        p = p.right;
		    }
		}

		int sum = 0;
		stack.push(p);
		p = null;
		while(!stack.empty() || p != null) {
		    if(p != null) {
		        stack.push(p);
		        p = p.left;
		    } else {
		        p = stack.pop();

		        sum += p.val;

		        if(p.val == high) {
		            return sum;
		        }

		        p = p.right;
		    }
		}

		return sum;
	}
}
