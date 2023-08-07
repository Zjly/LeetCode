import java.util.ArrayList;
import java.util.List;

/**
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 */

public class Question655_PrintBinaryTree {
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
class Solution655 {
	public List<List<String>> printTree(TreeNode root) {
		int depth = getDepth(root);
		String[][] strings = new String[depth][(int)(Math.pow(2, depth) - 1)];

		dfs(root, strings, depth - 1, 0, (strings[0].length - 1) / 2);

		List<List<String>> result = new ArrayList<>();
		for(String[] string : strings) {
			ArrayList<String> arrayList = new ArrayList<>();
			for(int j = 0; j < strings[0].length; j++) {
				if(string[j] != null) {
					arrayList.add(string[j]);
				} else {
					arrayList.add("");
				}
			}
			result.add(arrayList);
		}
		return result;
	}

	public int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

	public void dfs(TreeNode root, String[][] strings, int height, int r, int c) {
		if(root != null) {
			strings[r][c] = String.valueOf(root.val);
			dfs(root.left, strings, height, r + 1, (int)(c - Math.pow(2, height - r - 1)));
			dfs(root.right, strings, height, r + 1, (int)(c + Math.pow(2, height - r - 1)));
		}
	}
}