import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 */

public class Question1373_二叉搜索子树的最大键值和 {
	Solution1373 solution1373 = new Solution1373();

	@Test
	public void test1() {
		TreeNode root = Tool.createTreeFromArray(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null,
				null, 4, 6});
		Assertions.assertEquals(20, solution1373.maxSumBST(root));
	}

	@Test
	public void test2() {
		TreeNode root = Tool.createTreeFromArray(new Integer[]{1, null, 10, -5, 20});
		Assertions.assertEquals(25, solution1373.maxSumBST(root));
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
class Solution1373 {
	private int maxSum = 0;

	public int maxSumBST(TreeNode root) {
		dfs(root);

		return maxSum;
	}

	private Integer[] dfs(TreeNode root) {
		if(root == null) {
			return new Integer[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
		}

		Integer[] left = dfs(root.left);
		Integer[] right = dfs(root.right);

		if(left == null
				|| right == null
				|| left[2] >= root.val
				|| right[1] <= root.val
				|| (root.left != null && root.left.val >= root.val)
				|| (root.right != null && root.right.val <= root.val)) {
			return null;
		}

		int sum = left[0] + right[0] + root.val;
		maxSum = Math.max(maxSum, sum);
		return new Integer[]{sum, Math.min(left[1], root.val), Math.max(right[2], root.val)};
	}
}