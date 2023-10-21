import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 2316. 统计无向图中无法互相到达点对数
 * 提示
 * 中等
 * 62
 * 相关企业
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * <p>
 * 请你返回 无法互相到达 的不同 点对数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 * 输出：0
 * 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * 输出：14
 * 解释：总共有 14 个点对互相无法到达：
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
 * 所以我们返回 14 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不会有重复边。
 */

public class Question2316_统计无向图中无法互相到达点对数 {
    Solution2316 solution2316 = new Solution2316();

    @Test
    public void test() {
        int n = 100000;
        int[][] edges = {};
        System.out.println(solution2316.countPairs(n, edges));
    }

    @Test
    public void test2() {
        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(solution2316.countPairs(n, edges));
    }

    @Test
    public void test3() {
        int n = 7;
        int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
        System.out.println(solution2316.countPairs(n, edges));
    }
}

class Solution2316 {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int point0 = edge[0];
            int point1 = edge[1];

            List<Integer> list0 = map.getOrDefault(point0, new ArrayList<>());
            list0.add(point1);
            map.put(point0, list0);

            List<Integer> list1 = map.getOrDefault(point1, new ArrayList<>());
            list1.add(point0);
            map.put(point1, list1);
        }

        int[] indexArray = new int[n];
        for (int i = 0; i < n; i++) {
            indexArray[i] = i;
        }

        int index = n + 1;
        long result = 0;
        long s = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indexArray[i] != i) {
                continue;
            }

            int dfs = dfs(indexArray, index, map, i);
            result += s * dfs;
            s += dfs;
            index++;
        }

        return result;
    }

    public int dfs(int[] indexArray, int index, Map<Integer, List<Integer>> map, int point) {
        int count = 1;
        indexArray[point] = index;
        List<Integer> nextList = map.getOrDefault(point, new ArrayList<>());
        for (Integer next : nextList) {
            if (indexArray[next] == index) {
                continue;
            }

            count += dfs(indexArray, index, map, next);
        }

        return count;
    }
}