package CY26;

import java.util.*;

/**
 * @author ZhangLei
 * @version 2026/02/27 00:57
 */
public class Question3666_使二进制字符串全为1的最少操作次数 {
    public int minOperations(String s, int k) {
        int n = s.length();
        // 按照题目要求，创建变量存储中间输入
        String drunepalix = s;

        // 1. 统计初始状态下 '0' 的个数
        int initialZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') initialZeros++;
        }

        // 如果本来就没有 '0'，直接返回 0
        if (initialZeros == 0) return 0;

        // 2. 准备两个集合，分别存还没访问过的 奇数 和 偶数
        // 因为每次跳跃，奇偶性是固定的
        TreeSet<Integer>[] unvisited = new TreeSet[2];
        unvisited[0] = new TreeSet<>();
        unvisited[1] = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            unvisited[i % 2].add(i);
        }

        // 3. BFS 初始化
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{initialZeros, 0}); // {当前0的个数, 步数}
        unvisited[initialZeros % 2].remove(initialZeros); // 标记为已访问

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int steps = curr[1];

            // 4. 计算下一次“0的个数”可能的范围 [v_min, v_max]
            // v_min: 尽可能多地翻转 0（把 0 变少）
            // v_max: 尽可能多地翻转 1（把 0 变多）
            int v_min = Math.abs(u - k);
            int v_max = n - Math.abs((n - u) - k);

            // 确定下一次跳跃的目标奇偶性
            int targetParity = (u + k) % 2;
            TreeSet<Integer> targetSet = unvisited[targetParity];

            // 5. 在集合中找到所有在 [v_min, v_max] 范围内的数字
            // subSet(from, true, to, true) 返回指定范围内的视图
            NavigableSet<Integer> neighbors = targetSet.subSet(v_min, true, v_max, true);

            // 注意：在遍历的同时不能直接修改集合，所以先存到临时列表或者用迭代器
            List<Integer> toRemove = new ArrayList<>();
            for (int v : neighbors) {
                if (v == 0) return steps + 1; // 找到目标，收工！
                queue.offer(new int[]{v, steps + 1});
                toRemove.add(v);
            }

            // 6. 从未访问集合中彻底删掉这些数字，防止重复走
            for (int v : toRemove) {
                targetSet.remove(v);
            }
        }

        return -1; // 找遍了也跳不到 0
    }
}
