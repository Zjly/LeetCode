/**
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 */

public class Question1022_SumOfRootToLeafBinaryNumbers {
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
class Solution1022 {
	public int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int sum) {
		if(root == null) {
		    return 0;
		}

		sum <<= 1;

		if(root.val == 1) {
		    sum += 1;
		}

		if(root.left == null && root.right == null) {
		    return sum;
		} else {
		    return dfs(root.left, sum) + dfs(root.right, sum);
		}
	}
}