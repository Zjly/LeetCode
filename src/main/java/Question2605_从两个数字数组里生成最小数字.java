/**
 * 2605. 从两个数字数组里生成最小数字
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 */

public class Question2605_从两个数字数组里生成最小数字 {
}

/**
 * @author Zhang Lei
 * @date 2023/9/5 22:40
 */
class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[10];
        boolean[] s2 = new boolean[10];
        int minS1 = 10;
        int minS2 = 10;

        for (int num : nums1) {
        	s1[num] = true;
            minS1 = Math.min(minS1, num);
        }

        for (int num : nums2) {
            s2[num] = true;
            minS2 = Math.min(minS2, num);
        }

        for (int i = 0; i < 10; i++) {
        	if (s1[i] && s2[i]) {
        	    return i;
        	}
        }

        return Math.min(minS1 * 10 + minS2, minS2 * 10 + minS1);
    }
}