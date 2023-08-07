import java.util.HashMap;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */

public class Question437_PathSumIII {
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
class Solution437 {
	public int pathSum(TreeNode root, int targetSum) {
		HashMap<Long, Integer> hashMap = new HashMap<>();
		hashMap.put(0L, 1);
		return dfs(root, hashMap, 0, targetSum);
	}

	private int dfs(TreeNode root, HashMap<Long, Integer> hashMap, long p, int targetSum) {
		if(root == null) {
			return 0;
		}

		p += root.val;
		int count = hashMap.getOrDefault(p - targetSum, 0);
		hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
		count += dfs(root.left, hashMap, p, targetSum);
		count += dfs(root.right, hashMap, p, targetSum);
		hashMap.put(p, hashMap.getOrDefault(p, 0) - 1);

		return count;
	}
}