import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 */

public class Question1110_删点成林 {
}

class Solution1110 {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		boolean[] delete = new boolean[1001];
		for(int num : to_delete) {
			delete[num] = true;
		}

		List<TreeNode> result = new ArrayList<>();
		dfs(root, delete, null, true, true, result);
		return result;
	}

	private void dfs(TreeNode root, boolean[] delete, TreeNode parent, boolean isLeft, boolean isRoot,
	                 List<TreeNode> result) {
		if(root == null) {
			return;
		}

		if(delete[root.val]) {
			if(parent != null) {
				if(isLeft) {
					parent.left = null;
				} else {
				    parent.right = null;
				}
			}

			dfs(root.left, delete, root, true, true, result);
			dfs(root.right, delete, root, false, true, result);
		} else {
			if(isRoot) {
			    result.add(root);
			}

			dfs(root.left, delete, root, true, false, result);
			dfs(root.right, delete, root, false, false, result);
		}
	}
}