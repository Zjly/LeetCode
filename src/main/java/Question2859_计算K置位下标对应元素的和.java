import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2859. 计算 K 置位下标对应元素的和
 * 第 363 场周赛
 * Q1
 * 1218
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * <p>
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * <p>
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,10,1,5,2], k = 1
 * 输出：13
 * 解释：下标的二进制表示是：
 * 0 = 0002
 * 1 = 0012
 * 2 = 0102
 * 3 = 0112
 * 4 = 1002
 * 下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
 * 因此，答案为 nums[1] + nums[2] + nums[4] = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,2,1], k = 2
 * 输出：1
 * 解释：下标的二进制表示是：
 * 0 = 002
 * 1 = 012
 * 2 = 102
 * 3 = 112
 * 只有下标 3 的二进制表示中存在 k = 2 个置位。
 * 因此，答案为 nums[3] = 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 * 0 <= k <= 10
 */

public class Question2859_计算K置位下标对应元素的和 {
    Solution2859 solution2859 = new Solution2859();

    @Test
    public void test() {
        List<Integer> nums = List.of(5, 10, 1, 5, 2);
        int k = 1;
        System.out.println(solution2859.sumIndicesWithKSetBits(nums, k));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/1/25 22:55
 */
class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            int num = i;
            while (num != 0) {
                count += num % 2;
                num /= 2;
            }

            if (count == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }
}