import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 */

public class Question662_MaximumWidthOfBinaryTree {
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
class Solution662 {
	public int widthOfBinaryTree(TreeNode root) {
		class Node {
			TreeNode treeNode;
			int location;

			Node(TreeNode treeNode, int location) {
				this.treeNode = treeNode;
				this.location = location;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(root, 1));


		int maxWidth = 1;

		while(!queue.isEmpty()) {
		    int size = queue.size();
			int left = 0;
			int right = 0;
			for(int i = 0; i < size; i++) {
				Node p = queue.poll();
				TreeNode t = p.treeNode;
				int l = p.location;

				if(i == 0) {
				    left = l;
				}

				if(i == size - 1) {
				    right = l;
				}

				if(t.left != null) {
					queue.offer(new Node(t.left, l * 2 - 1));
				}

				if(t.right != null) {
					queue.offer(new Node(t.right, l * 2));
				}
			}

			maxWidth = Math.max(maxWidth, right - left + 1);
		}

		return maxWidth;
	}
}