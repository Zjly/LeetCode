import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1654. 到家的最少跳跃次数
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * <p>
 * 跳蚤跳跃的规则如下：
 * <p>
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * <p>
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * 输出：3
 * 解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
 * 示例 2：
 * <p>
 * 输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * 输出：2
 * 解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同。
 * 位置 x 不在 forbidden 中。
 */

public class Question1654_到家的最少跳跃次数 {
    Solution1654 solution1654 = new Solution1654();

    @Test
    public void test() {
        int[] forbidden = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103,
                149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164,
                136, 72, 98};
        int a = 29;
        int b = 98;
        Assertions.assertEquals(121, solution1654.minimumJumps(forbidden, a, b, 80));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/8/30 22:54
 */
class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> arrivedSet = new HashSet<>();
        Set<Integer> forbiddenSet = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        deque.add(new int[]{0, 1});
        arrivedSet.add(0);

        int upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;

        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] nums = deque.poll();
                assert nums != null;
                int location = nums[0];
                int direction = nums[1];

                // reach home
                if (location == x) {
                    return count;
                }

                // forward
                int forwardLocation = location + a;
                if (!arrivedSet.contains(forwardLocation)
                        && !forbiddenSet.contains(forwardLocation)
                        && forwardLocation <= upper) {
                    deque.add(new int[]{forwardLocation, 1});
                    arrivedSet.add(forwardLocation);
                }

                // backward
                int backwardLocation = location - b;
                if (!arrivedSet.contains(-backwardLocation)
                        && !forbiddenSet.contains(backwardLocation)
                        && backwardLocation > 0
                        && direction != -1) {
                    deque.add(new int[]{backwardLocation, -1});
                    arrivedSet.add(-backwardLocation);
                }
            }

            count++;
        }

        return -1;
    }
}