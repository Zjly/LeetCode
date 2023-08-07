import java.util.ArrayList;
import java.util.HashMap;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * -105 <= Node.val <= 105
 */

public class Question508_MostFrequentSubtreeSum {
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
class Solution508 {
	HashMap<Integer, Integer> numCount = new HashMap<>();
	ArrayList<Integer> arrayList = new ArrayList<>();
	int maxCount = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		dfs(root);
		int[] result = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++) {
			result[i] = arrayList.get(i);
		}
		return result;
	}

	public int dfs(TreeNode root) {
		if(root == null) {
		    return 0;
		}

		int current = root.val;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int sum = current + left + right;
		numCount.put(sum, numCount.getOrDefault(sum, 0) + 1);

		int currentCount = numCount.get(sum);
		if(currentCount > maxCount) {
		    maxCount = currentCount;
			arrayList = new ArrayList<>();
			arrayList.add(sum);
		} else if(currentCount == maxCount) {
			arrayList.add(sum);
		}

		return sum;
	}
}