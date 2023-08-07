import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 */

public class Question652_FindDuplicateSubtrees {
	public static void main(String[] args) {
		TreeNode root = Tool.createTreeFromArray(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
		Solution652 solution652 = new Solution652();
		System.out.println(solution652.findDuplicateSubtrees(root));
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
class Solution652 {
	HashMap<String, Integer> hashMap = new HashMap<>();
	List<TreeNode> result = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		dfs(root);
		return result;
	}

	public String dfs(TreeNode root) {
		if(root == null) {
			return "";
		}

		String left = dfs(root.left);
		String right = dfs(root.right);

		String currentString = "(" + root.val + "," + left + "," + right + ")";
		if(hashMap.containsKey(currentString)) {
			if(hashMap.get(currentString) == 1) {
				result.add(root);
				hashMap.put(currentString, -1);
			}
		} else {
			hashMap.put(currentString, 1);
		}

		return currentString;
	}
}