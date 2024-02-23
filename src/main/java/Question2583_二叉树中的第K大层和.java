import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * 2583. 二叉树中的第 K 大层和
 * 第 335 场周赛
 * Q2
 * 1374
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树的根节点 root 和一个正整数 k 。
 * <p>
 * 树中的 层和 是指 同一层 上节点值的总和。
 * <p>
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 * <p>
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,8,9,2,1,3,7,4,6], k = 2
 * 输出：13
 * 解释：树中每一层的层和分别是：
 * - Level 1: 5
 * - Level 2: 8 + 9 = 17
 * - Level 3: 2 + 1 + 3 + 7 = 13
 * - Level 4: 4 + 6 = 10
 * 第 2 大的层和等于 13 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,null,3], k = 1
 * 输出：3
 * 解释：最大的层和是 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n
 * 2 <= n <= 105
 * 1 <= Node.val <= 106
 * 1 <= k <= n
 */

public class Question2583_二叉树中的第K大层和 {
}

/**
 * @author Zhang Lei
 * @date 2024/2/23 21:13
 */

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
class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> arrayList = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode p = deque.pollFirst();
                sum += p.val;
                if (p.left != null) {
                    deque.addLast(p.left);
                }
                if (p.right != null) {
                    deque.addLast(p.right);
                }
            }

            arrayList.add(sum);
        }

        if (k > arrayList.size()) {
            return -1;
        }
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - k);
    }
}