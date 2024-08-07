import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 * 算术评级: 3
 * 第 289 场周赛
 * Q2
 * 1372
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * <p>
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * 示例 2：
 * <p>
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 */

public class Question2244_完成所有任务需要的最少轮数 {
}

/**
 * @author Zhang Lei
 * @date 2024/5/14 0:13
 */
class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int task : tasks) {
            hashmap.put(task, hashmap.getOrDefault(task, 0) + 1);
        }

        int count = 0;
        for (HashMap.Entry<Integer, Integer> entry : hashmap.entrySet()) {
           int key = entry.getKey();
           int value = entry.getValue();
           if (value == 1) {
               return -1;
           }

           if (value % 3 == 0) {
               count += value / 3;
           } else if (value % 3 == 1) {
               count += (value - 4) / 3 + 2;
           } else {
               count += value / 3 + 1;
           }
        }

        return count;
    }
}