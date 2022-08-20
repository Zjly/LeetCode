/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 */

public class Question654_MaximumBinaryTree {
	public static void main(String[] args) {
		Solution654 solution654 = new Solution654();
		int[] nums = {3, 2, 1, 6, 0, 5};
		TreeNode root = solution654.constructMaximumBinaryTree(nums);
		System.out.println();
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
class Solution654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}

	public TreeNode construct(int[] nums, int left, int right) {
		int maxIndex = findMaxIndex(nums, left, right);
		if(maxIndex == -1) {
			return null;
		}

		TreeNode maxNode = new TreeNode(nums[maxIndex]);
		TreeNode leftNode = construct(nums, left, maxIndex - 1);
		TreeNode rightNode = construct(nums, maxIndex + 1, right);

		maxNode.left = leftNode;
		maxNode.right = rightNode;
		return maxNode;
	}

	public int findMaxIndex(int[] nums, int left, int right) {
		int maxValue = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i = left; i <= right; i++) {
			if(nums[i] > maxValue) {
				maxValue = nums[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}
}