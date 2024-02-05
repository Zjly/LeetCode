import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 1696. 跳跃游戏 VI
 * 第 220 场周赛
 * Q3
 * 1954
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 */

public class Question1696_跳跃游戏VI {
    Solution1696 solution1696 = new Solution1696();

    @Test
    public void test() {
        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        System.out.println(solution1696.maxResult(nums, k));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/2/5 18:26
 */
class Solution1696 {
    public int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[]{nums[0], 0});

        for (int i = 1; i < nums.length; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] + k < i) {
                priorityQueue.poll();
            }

            assert priorityQueue.peek() != null;
            int current = priorityQueue.peek()[0] + nums[i];

            if (i == nums.length - 1) {
                return current;
            }

            priorityQueue.add(new int[]{current, i});
        }

        return -1;
    }
}