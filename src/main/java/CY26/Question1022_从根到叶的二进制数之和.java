package CY26;

import tools.TreeNode;

/**
 * @author ZhangLei
 * @version 2026/02/24 01:09
 */
public class Question1022_从根到叶的二进制数之和 {
    private int sum = 0;
    private int val = 0;

    public int sumRootToLeaf(TreeNode root) {
        // 前序遍历
        pre(root);

        return sum;
    }

    private void pre(TreeNode root) {
        // 空节点
        if (root == null) {
            return;
        }

        // 计算当前路径值
        val <<= 1;
        val += root.val;

        // 叶子结点
        if (root.left == null && root.right == null) {
            sum += val;
        }

        pre(root.left);
        pre(root.right);

        // 退出后减去当前节点值
        val -= root.val;
        val >>= 1;
    }
}