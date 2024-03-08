import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 2834. 找出美丽数组的最小和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个正整数：n 和 target 。
 * <p>
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 * <p>
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, target = 3
 * 输出：4
 * 解释：nums = [1,3] 是美丽数组。
 * - nums 的长度为 n = 2 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 4 是符合条件的美丽数组所可能具备的最小和。
 * 示例 2：
 * <p>
 * 输入：n = 3, target = 3
 * 输出：8
 * 解释：
 * nums = [1,3,4] 是美丽数组。
 * - nums 的长度为 n = 3 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 8 是符合条件的美丽数组所可能具备的最小和。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：1
 * 解释：nums = [1] 是美丽数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 1 <= target <= 109
 */

public class Question2834_找出美丽数组的最小和 {
    Solution2834 solution2834 = new Solution2834();

    @Test
    public void test() {
        int n = 3;
        int target = 3;
        Assertions.assertEquals(8, solution2834.minimumPossibleSum(n, target));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/3/8 17:02
 */
class Solution2834 {
    public int minimumPossibleSum(int n, int target) {
        long safe = target / 2;
        long MOD = 1000000007;
        if (n <= safe) {
            return (int)(((1 + n) * n / 2) % MOD);
        }

        long pre = ((1 + safe) * safe / 2) % MOD;
        long remainCount = n - safe;
        long next = ((target + target + remainCount - 1) * remainCount / 2) % MOD;
        return (int)((pre + next) % MOD);
    }
}
