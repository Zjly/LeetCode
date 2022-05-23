import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 */

public class Question04_06_SuccessorLCCI {
	public static void main(String[] args) {

	}
}

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution04_06 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		List<TreeNode> arrayList = new ArrayList<>();

		TreeNode q = root;
		while(q != null) {
		    if(q.val == p.val) {
		        if(q.right != null) {
					q = q.right;
					while(q.left != null) {
					    q = q.left;
					}
		            return q;
		        } else {
					// 找到第一个比他大的
			        for(int i = arrayList.size() - 1; i >= 0; i--) {
			        	if(arrayList.get(i).val > p.val) {
			        	    return arrayList.get(i);
			        	}
			        }
			        return null;
		        }
		    } else if(q.val < p.val) {
		        arrayList.add(q);
				if(q.right != null) {
				    q = q.right;
				} else {
					return null;
				}
		    } else {
			    arrayList.add(q);
		        if(q.left != null) {
		            q = q.left;
		        } else {
		            return null;
		        }
		    }
		}

		return null;
	}
}