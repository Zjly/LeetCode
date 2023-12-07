import java.util.ArrayList;
import java.util.List;

/**
 * 1466. 重新规划路线
 * 提示
 * 中等
 * 208
 * 相关企业
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 */

public class Question1466_重新规划路线 {
}

/**
 * @author Zhang Lei
 * @date 2023/12/7 20:52
 */
class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int begin = connection[0];
            int end = connection[1];

            list.get(begin).add(new int[]{end, 1});
            list.get(end).add(new int[]{begin, -1});
        }

        return dfs(0, -1, list);
    }

    private int dfs(int root, int parent, List<List<int[]>> list) {
        List<int[]> children = list.get(root);

        int count = 0;
        for (int[] child : children) {
            if (child[0] == parent) {
                continue;
            }

            if (child[1] == 1) {
                count++;
            }

            count += dfs(child[0], root, list);
        }

        return count;
    }
}