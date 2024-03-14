/**
 * 2789. 合并后数组中的最大元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
 * <p>
 * 你可以在数组上执行下述操作 任意 次：
 * <p>
 * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
 * 返回你可以从最终数组中获得的 最大 元素的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,7,9,3]
 * 输出：21
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 0 ，得到数组 nums = [5,7,9,3] 。
 * - 选中 i = 1 ，得到数组 nums = [5,16,3] 。
 * - 选中 i = 0 ，得到数组 nums = [21,3] 。
 * 最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [5,3,3]
 * 输出：11
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 1 ，得到数组 nums = [5,6] 。
 * - 选中 i = 0 ，得到数组 nums = [11] 。
 * 最终数组中只有一个元素，即 11 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */

public class Question2789_合并后数组中的最大元素 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/14 14:56
 */
class Solution2789 {
    public long maxArrayValue(int[] nums) {
        long num = nums[nums.length - 1];
        long maxNum = num;
        for (int i = nums.length - 2; i >= 0; i--) {
        	if (num >= nums[i]) {
        	    num += nums[i];
        	} else {
                num = nums[i];
        	}
            maxNum = Math.max(num, maxNum);
        }

        return maxNum;
    }
}