import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * 树的深度在 [1, 104]范围内
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 */

public class Question623_AddOneRowToTree {
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
class Solution623 {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(depth == 1) {
			TreeNode p = new TreeNode(val);
			p.left = root;
			return p;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		for(int i = 1; i < depth - 1; i++) {
			int size = queue.size();

			for(int j = 0; j < size; j++) {
				TreeNode p = queue.poll();

				if(p.left != null) {
					queue.add(p.left);
				}

				if(p.right != null) {
					queue.add(p.right);
				}
			}
		}

		while(!queue.isEmpty()) {
			TreeNode p = queue.poll();

			TreeNode q = new TreeNode(val);
			q.left = p.left;
			p.left = q;

			TreeNode r = new TreeNode(val);
			r.right = p.right;
			p.right = r;
		}

		return root;
	}
}