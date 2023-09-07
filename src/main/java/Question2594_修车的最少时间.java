import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2594. 修车的最少时间
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * <p>
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * <p>
 * 请你返回修理所有汽车 最少 需要多少时间。
 * <p>
 * 注意：所有机械工可以同时修理汽车。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 * <p>
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 */

public class Question2594_修车的最少时间 {
    Solution2594 solution2594 = new Solution2594();

    @Test
    public void test() {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        Assertions.assertEquals(16, solution2594.repairCars(ranks, cars));
    }

    @Test
    public void test2() {
        int[] ranks = {5, 1, 8};
        int cars = 6;
        Assertions.assertEquals(16, solution2594.repairCars(ranks, cars));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/9/7 15:35
 */
class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        int minRank = Integer.MAX_VALUE;
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }

        long left = 0;
        long right = (long)minRank * cars * cars;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            long allCars = allCars(ranks, mid);
            if (allCars >= cars) {
                right = mid;
            } else if (allCars < cars) {
                left = mid + 1;
            }
        }

        return left;
    }

    // time > rank * car * car -> car = (int)Math.sqrt(time / rank)
    private long allCars(int[] ranks, long time) {
        long sum = 0;
        for (int rank : ranks) {
            sum += (long)Math.sqrt(1.0 * time / rank);
        }

        return sum;
    }
}