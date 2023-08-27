import java.util.ArrayList;
import java.util.Arrays;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

public class Question56_合并区间 {
}

/**
 * @author Zhang Lei
 * @date 2023/8/27 23:56
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> arrayList = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > right) {
                arrayList.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            } else {
                right = Math.max(right, interval[1]);
            }
        }

        arrayList.add(new int[]{left, right});

        int[][] result = new int[arrayList.size()][2];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}