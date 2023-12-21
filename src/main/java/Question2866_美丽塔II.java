import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2866. 美丽塔 II
 * 提示
 * 中等
 * 70
 * 相关企业
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 * <p>
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 * <p>
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 * <p>
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山脉 数组。
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 * <p>
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 * 示例 2：
 * <p>
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 * 示例 3：
 * <p>
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == maxHeights <= 105
 * 1 <= maxHeights[i] <= 109
 */

public class Question2866_美丽塔II {
    Solution2866 solution2866 = new Solution2866();

    @Test
    public void test() {
        List<Integer> maxHeights = new ArrayList<>();
        maxHeights.add(5);
        maxHeights.add(3);
        maxHeights.add(4);
        maxHeights.add(1);
        maxHeights.add(1);

        Assertions.assertEquals(13, solution2866.maximumSumOfHeights(maxHeights));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/12/21 15:47
 */
class Solution2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        int size = maxHeights.size();
        long[] sum1 = new long[size];
        long[] sum2 = new long[size];

        for (int i = 0; i < size; i++) {
            int height = maxHeights.get(i);
            while (!deque1.isEmpty() && height < maxHeights.get(deque1.peek())) {
                deque1.pop();
            }

            if (deque1.isEmpty()) {
                sum1[i] = (long)height * (i + 1);
            } else {
                int preIndex = deque1.peek();
                sum1[i] = sum1[preIndex] + (long)height * (i - preIndex);
            }

            deque1.push(i);
        }

        long result = 0;
        for (int i = size - 1; i >= 0; i--) {
            int height = maxHeights.get(i);
            while (!deque2.isEmpty() && height < maxHeights.get(deque2.peek())) {
                deque2.pop();
            }

            if (deque2.isEmpty()) {
                sum2[i] = (long)height * (size - i);
            } else {
                int nextIndex = deque2.peek();
                sum2[i] = sum2[nextIndex] + (long)height * (nextIndex - i);
            }

            deque2.push(i);
            result = Math.max(result, sum1[i] + sum2[i] - height);
        }

        return result;
    }
}