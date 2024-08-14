/**
 * 3152. 特殊数组 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * <p>
 * 你有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助你检查
 * 子数组
 * nums[fromi..toi] 是不是一个 特殊数组 。
 * <p>
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,1,2,6], queries = [[0,4]]
 * <p>
 * 输出：[false]
 * <p>
 * 解释：
 * <p>
 * 子数组是 [3,4,1,2,6]。2 和 6 都是偶数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,1,6], queries = [[0,2],[2,3]]
 * <p>
 * 输出：[false,true]
 * <p>
 * 解释：
 * <p>
 * 子数组是 [4,3,1]。3 和 1 都是奇数。因此这个查询的答案是 false。
 * 子数组是 [1,6]。只有一对：(1,6)，且包含了奇偶性不同的数字。因此这个查询的答案是 true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2024/08/14 20:42
 */
public class Question3152_特殊数组II {
    Solution3152 solution3152 = new Solution3152();

    @Test
    public void test() {
        int[] nums = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};
        System.out.println(Arrays.toString(solution3152.isArraySpecial(nums, queries)));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/08/14 20:42
 */
class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2 == 0 && nums[i - 1] % 2 == 1) || (nums[i] % 2 == 1 && nums[i - 1] % 2 == 0)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < result.length; i++) {
            int length = queries[i][1] - queries[i][0] + 1;
            result[i] = length <= dp[queries[i][1]];
        }

        return result;
    }
}