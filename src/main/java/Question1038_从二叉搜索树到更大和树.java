import org.junit.jupiter.api.Test;

/**
 * 1038. 从二叉搜索树到更大和树
 * 提示
 * 中等
 * 255
 * 相关企业
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 100] 范围内。
 * 0 <= Node.val <= 100
 * 树中的所有值均 不重复 。
 * <p>
 * <p>
 * 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 */

public class Question1038_从二叉搜索树到更大和树 {
    Solution1038 solution1038 = new Solution1038();

    @Test
    public void test() {
        Integer[] integers = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = Tool.createTreeFromArray(integers);
        TreeNode treeNode = solution1038.bstToGst(root);
        System.out.println(treeNode);
    }
}

/**
 * @author Zhang Lei
 * @date 2023/12/4 13:26
 */
class Solution1038 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        dfs2(root);
        return root;
    }

    public int dfs(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }

        int rootVal = root.val;
        int leftVal = dfs(root.left, parentVal);
        int rightVal = dfs(root.right, rootVal + leftVal + parentVal);
        sum += rootVal;
        root.val = leftVal + parentVal;

        return rootVal + leftVal + rightVal;
    }

    public void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }

        root.val = sum - root.val;
        dfs2(root.left);
        dfs2(root.right);
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