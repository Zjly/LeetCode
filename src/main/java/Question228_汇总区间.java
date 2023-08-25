import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 简单
 * 282
 * 相关企业
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */

public class Question228_汇总区间 {
}

/**
 * @author Zhang Lei
 * @date 2023/8/26 0:36
 */
class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int begin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (begin == nums[i]) {
                    result.add(String.valueOf(begin));
                } else {
                    result.add(begin + "->" + nums[i]);
                }

                if (i != nums.length - 1) {
                    begin = nums[i + 1];
                }
            }
        }

        return result;
    }
}