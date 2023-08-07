/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */

public class Question222_CountCompleteTreeNodes {
	public static void main(String[] args) {
		Tool222 tool222 = new Tool222();
		TreeNode root;
		Solution222 solution222 = new Solution222();

		for(int i = 1; i < 128; i++) {
			root = tool222.createTree(i);
			int count = solution222.countNodes(root);
			if(count != i) {
				System.out.println(i + ": false(" + count + ")");
			} else {
				System.out.println(i + ": true");
			}
		}
		System.out.println("ok");
	}
}


class Tool222 {
	int current = 1;
	int count;

	public TreeNode createTree(int count) {
		if(count <= 0) {
			return null;
		}

		TreeNode root = new TreeNode(1);
		this.count = count;

		while(this.count != current) {
			createNode(root);
		}

		current = 1;

		return root;
	}

	public void createNode(TreeNode TreeNode) {
		if(TreeNode != null) {
			createNode(TreeNode.left);
			createNode(TreeNode.right);

			if(TreeNode.left == null) {
				if(current != count) {
					current++;
					TreeNode.left = new TreeNode(current);
				}
			}
			if(TreeNode.right == null) {
				if(current != count) {
					current++;
					TreeNode.right = new TreeNode(current);
				}
			}
		}
	}
}

class Solution222 {
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int count = 0;

		// 求出该树的深度
		int depth = 0;
		TreeNode current = root;
		while(current.left != null) {
			current = current.left;
			depth++;
		}

		count += Math.pow(2, depth);

		// 查找基准
		TreeNode base = root;
		int baseDepth = 0;

		// 未查找完成
		while(baseDepth != depth) {
			current = base;
			int currentDepth = baseDepth;

			// 进行二分查找，以右子树的左子树路线进行中点确定
			if(current.right != null) {
				current = current.right;
				currentDepth++;

				while(current.left != null) {
					current = current.left;
					currentDepth++;
				}
			}

			baseDepth++;

			// 确定下一步的基准方向
			if(currentDepth == depth) {
				base = base.right;
				count += Math.pow(2, depth - baseDepth);
			} else {
				base = base.left;
			}
		}

		return count;
	}
}