import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

public class Question103_BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode temp1 = new TreeNode(2);
		TreeNode temp2 = new TreeNode(3);
		TreeNode temp3 = new TreeNode(4);
		TreeNode temp4 = new TreeNode(5);
		TreeNode temp5 = new TreeNode(6);
		TreeNode temp6 = new TreeNode(7);
		root.left = temp1;
		root.right = temp2;
		temp1.left = temp3;
		temp1.right = temp4;
		temp2.left = temp5;
		temp2.right = temp6;

		Solution103 solution103 = new Solution103();
		System.out.println(solution103.zigzagLevelOrder(root));
	}
}

class Solution103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) {
		    return new LinkedList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> floorResult = new LinkedList<>();

		// 记录加入顺序以及层数
		boolean leftToRight = true;
		int thisFloorCount = 1;
		int nextFloorAdd = 0;

		queue.offer(root);
		while(queue.size() != 0) {
			TreeNode thisNode = queue.poll();
			thisFloorCount--;

			// 不同的顺序使用不同的加入方式
			if(leftToRight) {
				floorResult.add(thisNode.val);
			} else {
				floorResult.add(0, thisNode.val);
			}

			// 加入队列
			if(thisNode.left != null) {
				queue.offer(thisNode.left);
				nextFloorAdd++;
			}
			if(thisNode.right != null) {
				queue.offer(thisNode.right);
				nextFloorAdd++;
			}

			// 该层已经遍历完毕 进行换向
			if(thisFloorCount == 0) {
				leftToRight = !leftToRight;
				thisFloorCount = nextFloorAdd;
				nextFloorAdd = 0;
				resultList.add(floorResult);
				floorResult = new LinkedList<>();
			}
		}

		return resultList;
	}
}
