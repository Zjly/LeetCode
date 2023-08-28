import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */

public class Question57_插入区间 {
    Solution57 solution57 = new Solution57();

    @Test
    public void test1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {2, 5};
        Assertions.assertEquals("[[1, 5], [6, 9]]", Arrays.deepToString(solution57.insert(intervals, interval)));
    }

    @Test
    public void test2() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {5, 7};
        Assertions.assertEquals("[[1, 3], [5, 9]]", Arrays.deepToString(solution57.insert(intervals, interval)));
    }

    @Test
    public void test3() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {-1, 0};
        Assertions.assertEquals("[[-1, 0], [1, 3], [6, 9]]", Arrays.deepToString(solution57.insert(intervals, interval)));
    }

    @Test
    public void test4() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {10, 11};
        Assertions.assertEquals("[[1, 3], [6, 9], [10, 11]]", Arrays.deepToString(solution57.insert(intervals, interval)));
    }

    @Test
    public void test5() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] interval = {4, 8};
        Assertions.assertEquals("[[1, 2], [3, 10], [12, 16]]", Arrays.deepToString(solution57.insert(intervals, interval)));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/8/28 20:57
 */
class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean b = false;

        for (int i = 0; i < intervals.length; i++) {
            int iMin = intervals[i][0];
            int iMax = intervals[i][1];
            if (!b && iMin > newInterval[1]) {
                list.add(new int[]{newInterval[0], newInterval[1]});
                b = true;
            }

            if (intersect(intervals[i], newInterval)) {
                min = Math.min(min, Math.min(iMin, newInterval[0]));
                max = Math.max(max, Math.max(iMax, newInterval[1]));
                b = true;
            } else if (iMax < newInterval[0]) {
                list.add(new int[]{iMin, iMax});
            } else if (iMin > newInterval[1]) {
                if (min == Integer.MAX_VALUE) {
                    list.add(new int[]{iMin, iMax});
                } else {
                    list.add(new int[]{min, max});
                    list.add(new int[]{iMin, iMax});
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            list.add(new int[]{min, max});
        }

        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            list.add(new int[]{newInterval[0], newInterval[1]});
        }

        return list.stream().map(a -> new int[]{a[0], a[1]}).toArray(int[][]::new);
    }

    private boolean intersect(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[1] && interval1[1] >= interval2[0];
    }
}