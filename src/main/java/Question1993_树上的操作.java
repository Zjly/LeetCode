import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// 没做对

/**
 * 1993. 树上的操作
 * 提示
 * 中等
 * 55
 * 相关企业
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 * <p>
 * 数据结构需要支持如下函数：
 * <p>
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * 请你实现 LockingTree 类：
 * <p>
 * LockingTree(int[] parent) 用父节点数组初始化数据结构。
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
 * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
 * [[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
 * 输出：
 * [null, true, false, true, true, true, false]
 * <p>
 * 解释：
 * LockingTree lockingTree = new LockingTree([-1, 0, 0, 1, 1, 2, 2]);
 * lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
 * // 节点 2 被用户 2 上锁。
 * lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
 * lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
 * // 节点 2 现在变为未上锁状态。
 * lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
 * // 节点 4 被用户 5 上锁。
 * lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
 * // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
 * lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == parent.length
 * 2 <= n <= 2000
 * 对于 i != 0 ，满足 0 <= parent[i] <= n - 1
 * parent[0] == -1
 * 0 <= num <= n - 1
 * 1 <= user <= 104
 * parent 表示一棵合法的树。
 * lock ，unlock 和 upgrade 的调用 总共 不超过 2000 次。
 */

public class Question1993_树上的操作 {
    LockingTree lockingTree = new LockingTree(new int[]{-1, 4, 0, 2, 5, 0, 4, 8, 2, 4});

    @Test
    public void test() {
        lockingTree.lock(6, 41);
        System.out.println(lockingTree.upgrade(0, 7));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/9/23 17:00
 */
class LockingTree {
    public class TreeNode {
        int index;
        boolean lock;
        int user;
        List<TreeNode> children;

        public TreeNode(int index) {
            this.index = index;
            children = new ArrayList<>();
        }
    }

    TreeNode[] treeNodes;
    TreeNode root;

    public LockingTree(int[] parent) {
        int length = parent.length;
        treeNodes = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            treeNodes[i] = new TreeNode(i);
        }

        root = treeNodes[0];
        for (int i = 1; i < length; i++) {
            TreeNode parentNode = treeNodes[parent[i]];
            parentNode.children.add(treeNodes[i]);
        }
    }

    public boolean lock(int num, int user) {
        TreeNode treeNode = treeNodes[num];
        if (!treeNode.lock) {
            treeNode.lock = true;
            treeNode.user = user;
            return true;
        }

        return false;
    }

    public boolean unlock(int num, int user) {
        TreeNode treeNode = treeNodes[num];
        if (treeNode.lock && treeNode.user == user) {
            treeNode.lock = false;
            treeNode.user = 0;
            return true;
        }

        return false;
    }

    public boolean upgrade(int num, int user) {
        return dfs(root, num, user);
    }

    private boolean dfs(TreeNode root, int num, int user) {
        if (root == null) {
            return false;
        }

        if (root.lock) {
            return false;
        }

        if (root.index == num) {
            boolean b = dfs2(root);
            if (b) {
                root.lock = true;
                root.user = user;
                return true;
            }
            return false;
        } else {
            boolean b = false;
            for (TreeNode child : root.children) {
                b = b || dfs(child, num, user);
            }
            return b;
        }
    }

    private boolean dfs2(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean b = false;
        for (TreeNode child : root.children) {
            b = b || dfs2(child);
        }

        if (root.lock) {
            root.lock = false;
            root.user = 0;
            return true;
        }

        return b;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */