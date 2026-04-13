package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/13 22:50
 */
public class Question1848_到目标元素的最小距离 {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }

        return res;
    }
}
