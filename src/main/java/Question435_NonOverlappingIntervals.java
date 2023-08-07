import java.util.Arrays;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */

public class Question435_NonOverlappingIntervals {
	public static void main(String[] args) {
		Solution435 solution435 = new Solution435();
		int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};

		System.out.println(solution435.eraseOverlapIntervals(intervals));
	}
}

class Solution435 {
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length == 0 || intervals.length == 1) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a[1] < b[1] ? -1 : 1);
		int move = 0;
		int index = 1;
		int[] interval1 = intervals[0];
		int[] interval2;

		while(index < intervals.length) {
			interval2 = intervals[index];
			if(isOverlap(interval1, interval2)) {
				move++;
			} else {
			    interval1 = interval2;
			}

			index++;
		}

		return move;
	}

	public boolean isOverlap(int[] interval1, int[] interval2) {
		return interval1[0] < interval2[1] && interval2[0] < interval1[1];
	}
}
