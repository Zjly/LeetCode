/**
 * 849. 到最近的人的最大距离
 * 中等
 * 262
 * 相关企业
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 示例 3：
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= seats.length <= 2 * 104
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 */

public class Question849_到最近的人的最大距离 {
}

class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int pre = -1;
        int max = 1;
        for (int i = 0; i < seats.length; i++) {
        	if (seats[i] == 1) {
        	    if (pre == -1) {
        	        max = Math.max(max, i);
        	    } else {
        	        max = Math.max(max, (i - pre) / 2);
        	    }
                pre = i;
        	}
        }

        if (seats[seats.length - 1] == 0) {
            max = Math.max(max, seats.length - pre - 1);
        }

        return max;
    }
}