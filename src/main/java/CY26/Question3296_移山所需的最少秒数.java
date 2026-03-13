package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/13 01:06
 */
public class Question3296_移山所需的最少秒数 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        // 最坏情况：一个工人，workerTime = 10^6，mountainHeight = 10^5
        // 时间 = 10^6 * (1+2+...+10^5) = 10^6 * 10^5 * 10^5 / 2 ≈ 5 * 10^15
        long right = 5_000_000_000_000_000L; // 5e15
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (height(mid, workerTimes) >= mountainHeight) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    /**
     * 计算在给定时间 times 内，所有工人能降低的山的总高度
     * 对于工人 i，时间为 t 时能降低的高度 x 满足：
     * workerTime * x * (x + 1) / 2 <= t
     * 即 x * (x + 1) <= 2 * t / workerTime
     * 求最大整数 x
     */
    private long height(long times, int[] workerTimes) {
        long result = 0;
        for (int workerTime : workerTimes) {
            // 解 x * (x + 1) <= 2 * times / workerTime
            // 即 x^2 + x - (2 * times / workerTime) <= 0
            // 用求根公式：x = (-1 + sqrt(1 + 4 * 2 * times / workerTime)) / 2
            long ratio = (2 * times) / workerTime;
            long x = (long) ((-1 + Math.sqrt(1 + 4.0 * ratio)) / 2);
            result += x;
        }
        return result;
    }
}
