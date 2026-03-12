package CY26;

import tools.UnionSet;
import java.util.*;

/**
 * @author ZhangLei
 * @version 2026/03/12 23:06
 */
public class Question3600_升级后最大生成树稳定性 {

    public int maxStability(int n, int[][] edges, int k) {
        // 分离 must=1 和 must=0 的边
        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge);
            } else {
                optionalEdges.add(edge);
            }
        }

        // 二分答案
        int left = 1, right = 200000; // 最大边权 10^5，升级后 2*10^5
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAchieve(n, mustEdges, optionalEdges, k, mid)) {
                ans = mid;
                left = mid + 1; // 尝试更大的值
            } else {
                right = mid - 1; // 降低要求
            }
        }

        return ans;
    }

    private boolean canAchieve(int n, List<int[]> mustEdges, List<int[]> optionalEdges, int k, int target) {
        UnionSet uf = new UnionSet(n);

        // 1. 检查 must=1 的边
        for (int[] edge : mustEdges) {
            int strength = edge[2];
            if (strength < target) {
                // 必须的边但强度不够，且不能升级
                return false;
            }
            // 如果 must 边连接的两个节点已经连通，说明会形成环，无法构成生成树
            if (uf.isConnected(edge[0], edge[1])) {
                return false;
            }
            // 连接这条边
            uf.union(edge[0], edge[1]);
        }

        // 2. 收集可选边
        List<int[]> noUpgradeNeeded = new ArrayList<>(); // 不需要升级
        List<int[]> needUpgrade = new ArrayList<>();     // 需要升级

        for (int[] edge : optionalEdges) {
            int strength = edge[2];
            if (strength >= target) {
                noUpgradeNeeded.add(edge);
            } else if (strength * 2 >= target) {
                needUpgrade.add(edge);
            }
            // 升级后仍不够的边直接忽略
        }

        // 3. 优先使用不需要升级的边
        for (int[] edge : noUpgradeNeeded) {
            uf.union(edge[0], edge[1]);
        }

        // 4. 如果还不够，使用需要升级的边（消耗 k）
        int usedUpgrade = 0;
        for (int[] edge : needUpgrade) {
            if (usedUpgrade >= k) {
                break;
            }
            if (!uf.isConnected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
                usedUpgrade++;
            }
        }

        // 5. 检查是否所有节点连通
        return uf.getConnectCount() == 1;
    }

    // 测试方法
    public static void main(String[] args) {
        Question3600_升级后最大生成树稳定性 solution = new Question3600_升级后最大生成树稳定性();

        // 示例 1
        int n1 = 3;
        int[][] edges1 = {{0,1,2,1},{1,2,3,0}};
        int k1 = 1;
        System.out.println("示例 1 输出：" + solution.maxStability(n1, edges1, k1)); // 期望：2

        // 示例 2
        int n2 = 3;
        int[][] edges2 = {{0,1,4,0},{1,2,3,0},{0,2,1,0}};
        int k2 = 2;
        System.out.println("示例 2 输出：" + solution.maxStability(n2, edges2, k2)); // 期望：6

        // 示例 3
        int n3 = 3;
        int[][] edges3 = {{0,1,1,1},{1,2,1,1},{2,0,1,1}};
        int k3 = 0;
        System.out.println("示例 3 输出：" + solution.maxStability(n3, edges3, k3)); // 期望：-1
    }
}
