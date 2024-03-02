import java.util.*;

/**
 * 2368. 受限条件下可到达节点的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 * <p>
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 * <p>
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 * <p>
 * 注意，节点 0 不 会标记为受限节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值 互不相同
 */

public class Question2368_受限条件下可到达节点的数目 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/2 20:26
 */
class Solution2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        Set<Integer> set = new HashSet<>();
        for (int node : restricted) {
            set.add(node);
        }

        for (int[] edge : edges) {
            int node0 = edge[0];
            int node1 = edge[1];

            if (set.contains(node0) || set.contains(node1)) {
                continue;
            }

            nodes.get(node0).add(node1);
            nodes.get(node1).add(node0);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        Set<Integer> visited = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int node = deque.pollFirst();
                visited.add(node);

                List<Integer> children = nodes.get(node);
                for (Integer child : children) {
                    if (visited.contains(child)) {
                        continue;
                    }

                    deque.addLast(child);
                }
            }
        }

        return visited.size();
    }
}