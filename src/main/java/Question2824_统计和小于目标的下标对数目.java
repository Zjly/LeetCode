import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 * 提示
 * 1166
 * 48
 * 第 111 场双周赛
 * Q1
 * 相关企业
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,1,2,3,1], target = 2
 * 输出：3
 * 解释：总共有 3 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
 * - (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
 * 注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target 。
 * 示例 2：
 * <p>
 * 输入：nums = [-6,2,5,-2,-7,-1,3], target = -2
 * 输出：10
 * 解释：总共有 10 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = -4 < target
 * - (0, 3) ，0 < 3 且 nums[0] + nums[3] = -8 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = -13 < target
 * - (0, 5) ，0 < 5 且 nums[0] + nums[5] = -7 < target
 * - (0, 6) ，0 < 6 且 nums[0] + nums[6] = -3 < target
 * - (1, 4) ，1 < 4 且 nums[1] + nums[4] = -5 < target
 * - (3, 4) ，3 < 4 且 nums[3] + nums[4] = -9 < target
 * - (3, 5) ，3 < 5 且 nums[3] + nums[5] = -3 < target
 * - (4, 5) ，4 < 5 且 nums[4] + nums[5] = -8 < target
 * - (4, 6) ，4 < 6 且 nums[4] + nums[6] = -4 < target
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == n <= 50
 * -50 <= nums[i], target <= 50
 */

public class Question2824_统计和小于目标的下标对数目 {
    Solution2824 solution2824 = new Solution2824();

    @Test
    public void test() {
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        System.out.println(solution2824.countPairs(nums, 2));
    }

    @Test
    public void test2() {
        List<Integer> nums = new ArrayList<>();
        nums.add(-6);
        nums.add(2);
        nums.add(5);
        nums.add(-2);
        nums.add(-7);
        nums.add(-1);
        nums.add(3);
        System.out.println(solution2824.countPairs(nums, -2));
    }

    @Test
    public void test3() {
        List<Integer> nums = new ArrayList<>();
        nums.add(-4);
        nums.add(-6);
        nums.add(-7);
        nums.add(8);
        nums.add(1);
        System.out.println(solution2824.countPairs(nums, -13));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/11/24 23:01
 */
class Solution2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {
            while (left < right && nums.get(left) + nums.get(right) < target) {
                left++;
            }
            count += left;
            right--;
        }

        while (right > 0) {
            count += right;
            right--;
        }

        return count;
    }
}