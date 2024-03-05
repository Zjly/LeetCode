import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 1976. 到达目的地的方案数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
 * <p>
 * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 * <p>
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * 输出：4
 * 解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
 * 四条花费 7 分钟的路径分别为：
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * 示例 2：
 * <p>
 * 输入：n = 2, roads = [[1,0,10]]
 * 输出：1
 * 解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 109
 * ui != vi
 * 任意两个路口之间至多有一条路。
 * 从任意路口出发，你能够到达其他任意路口。
 */

public class Question1976_到达目的地的方案数 {
    Solution1976 solution1976 = new Solution1976();

    @Test
    public void test() {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        Assertions.assertEquals(4, solution1976.countPaths(n, roads));
    }

    @Test
    public void test2() {
        int n = 12;
        int[][] roads = {{1, 0, 2348}, {2, 1, 2852}, {2, 0, 5200}, {3, 1, 12480}, {2, 3, 9628}, {4, 3, 7367}, {4, 0, 22195}, {5, 4, 5668}, {1
                , 5, 25515}, {0, 5, 27863}, {6, 5, 836}, {6, 0, 28699}, {2, 6, 23499}, {6, 3, 13871}, {1, 6, 26351}, {5, 7, 6229}, {2, 7, 28892}, {1, 7, 31744}, {3, 7, 19264}, {6, 7, 5393}, {2, 8, 31998}, {8, 7, 3106}, {3, 8, 22370}, {8, 4, 15003}, {8, 6, 8499}, {8, 5, 9335}, {8, 9, 5258}, {9, 2, 37256}, {3, 9, 27628}, {7, 9, 8364}, {1, 9, 40108}, {9, 5, 14593}, {2, 10, 45922}, {5, 10, 23259}, {9, 10, 8666}, {10, 0, 51122}, {10, 3, 36294}, {10, 4, 28927}, {11, 4, 25190}, {11, 9, 4929}, {11, 8, 10187}, {11, 6, 18686}, {2, 11, 42185}, {11, 3, 32557}, {1, 11, 45037}};
        Assertions.assertEquals(166, solution1976.countPaths(n, roads));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/3/5 10:51
 */
class Solution1976 {
    public int countPaths(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        final long MOD = 1000000007;
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }

        long[][] minDistance = new long[n][2];
        Set<Integer> arrived = new HashSet<>();
        for (int i = 0; i < n; i++) {
            minDistance[i][0] = Long.MAX_VALUE - 1;
            minDistance[i][1] = 0;
        }
        minDistance[0][0] = 0;
        minDistance[0][1] = 1;

        while (true) {
            int minNode = -1;
            long minDis = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (arrived.contains(i)) {
                    continue;
                }

                if (minDistance[i][0] < minDis) {
                    minNode = i;
                    minDis = minDistance[i][0];
                }
            }

            if (minNode == -1) {
                break;
            }
            arrived.add(minNode);

            int[] weight = graph[minNode];
            for (int i = 0; i < n; i++) {
                if (arrived.contains(i) || weight[i] == 0) {
                    continue;
                }

                long distance = minDistance[minNode][0];
                long count = minDistance[minNode][1];

                if (distance + weight[i] < minDistance[i][0]) {
                    minDistance[i][0] = distance + weight[i];
                    minDistance[i][1] = count;
                } else if (distance + weight[i] == minDistance[i][0]) {
                    minDistance[i][1] = (minDistance[i][1] + count) % MOD;
                }
            }
        }

        return (int)(minDistance[n - 1][1] % MOD);
    }
}