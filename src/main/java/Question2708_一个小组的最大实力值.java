/**
 * 2708. 一个小组的最大实力值
 * 算术评级: 4
 * 第 105 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1502
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 * <p>
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,-1,-5,2,5,-9]
 * 输出：1350
 * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
 * 示例 2：
 * <p>
 * 输入：nums = [-4,-5,-4]
 * 输出：20
 * 解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 13
 * -9 <= nums[i] <= 9
 */

import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2024/09/03 22:26
 */
public class Question2708_一个小组的最大实力值 {
}

/**
 * @author Zhang Lei
 * @date 2024/09/03 22:27
 */
class Solution2708 {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);

        int x1 = 0;
        int index = 0;
        long result = 1;
        boolean in = false;
        while (index < nums.length) {
            int num = nums[index];
            if (num > 0) {
                result *= num;
                in = true;
            } else if (num < 0 && x1 == 0) {
                x1 = num;
            } else if (num < 0) {
                result *= (long)x1 * num;
                x1 = 0;
                in = true;
            }

            index++;
        }

        if (nums.length == 1 && nums[0] < 0) {
            return nums[0];
        }

        return in ? result : 0;
    }
}