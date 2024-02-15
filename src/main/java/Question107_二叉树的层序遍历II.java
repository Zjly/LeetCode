import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */

public class Question107_二叉树的层序遍历II {
}

/**
 * @author Zhang Lei
 * @date 2024/2/15 23:53
 */
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLayer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                currentLayer.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }

                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }

            result.add(0, currentLayer);
        }

        return result;
    }
}