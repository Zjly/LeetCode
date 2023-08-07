import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数量范围为 [1, 1000]
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000
 * 每个测试用例最多调用 insert 和 get_root 操作 104 次
 */

public class Question919_CompleteBinaryTreeInserter {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);

		CBTInserter cbtInserter = new CBTInserter(t1);
		cbtInserter.insert(3);
		cbtInserter.insert(4);
		TreeNode p = cbtInserter.get_root();
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
class CBTInserter {
	Queue<TreeNode> queue;
	TreeNode root;

	public CBTInserter(TreeNode root) {
		queue = new LinkedList<>();
		queue.offer(root);

		this.root = root;

		while(true) {
			TreeNode p = queue.peek();
			if(p.left != null) {
				queue.offer(p.left);
			} else {
				break;
			}

			if(p.right != null) {
				queue.offer(p.right);
				queue.poll();
			} else {
				break;
			}
		}
	}

	public int insert(int val) {
		if(queue.peek() != null) {
			TreeNode p = queue.peek();
			if(p.left == null) {
				TreeNode newNode = new TreeNode(val);
				p.left = newNode;
				queue.offer(newNode);
			} else if(p.right == null) {
				TreeNode newNode = new TreeNode(val);
				p.right = newNode;
				queue.poll();
				queue.offer(newNode);
			}

			return p.val;
		} else {
			return -1;
		}
	}

	public TreeNode get_root() {
		return root;
	}
}

/*
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */