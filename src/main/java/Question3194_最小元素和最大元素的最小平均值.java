import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2024/10/16 22:55
 */
public class Question3194_最小元素和最大元素的最小平均值 {
}

/**
 * @author ZhangLei
 * @version 2024/10/16 22:55
 */
class Solution3194 {
    public double minimumAverage(int[] nums) {

        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.min(min, (nums[i] + nums[nums.length - i - 1]) * 0.5);
        }

        return min;
    }
}