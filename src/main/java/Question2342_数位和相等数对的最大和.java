import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 2342. 数位和相等数对的最大和
 * 提示
 * 中等
 * 47
 * 相关企业
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */

public class Question2342_数位和相等数对的最大和 {
}

/**
 * @author Zhang Lei
 * @date 2023/11/18 14:18
 */
class Solution2342 {
    public int maximumSum(int[] nums) {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int num : nums) {
            int bitSum = bitSum(num);
            int[] array = new int[2];
            array = hashMap.getOrDefault(bitSum, array);
            if (num >= array[0]) {
                array[1] = array[0];
                array[0] = num;
            } else if (num > array[1]) {
                array[1] = num;
            }

            hashMap.put(bitSum, array);
        }

        int max = -1;
        for (Integer key : hashMap.keySet()) {
            int[] array = hashMap.get(key);
            if (array[1] != 0) {
                max = Math.max(max, array[0] + array[1]);
            }
        }

        return max;
    }

    public int bitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}