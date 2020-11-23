import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * <p>
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * <p>
 * 示例 4：
 * 输入：points = [[1,2]]
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * <p>
 * 提示：
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 */

public class Question452_MinimumNumberOfArrowsToBurstBalloons {
	public static void main(String[] args) {
		Solution452 solution452 = new Solution452();

		int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		System.out.println(solution452.findMinArrowShots(points));
	}
}

class Solution452 {
	public int findMinArrowShots(int[][] points) {
		if(points == null || points.length == 0) {
			return 0;
		}

		// 二维数组排序
		Arrays.sort(points, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o2[1] < o1[1] ? -1 : 1;
			}
			return o1[0] < o2[0] ? -1 : 1;
		});

		int index = 0;
		int count = points.length;

		while(index + 1 < points.length) {
			int[] indexBalloon = points[index];
			int[] nextBalloon = points[index + 1];

			// 计算重叠部分与下一部分是否重叠
			while(isOverlap(indexBalloon, nextBalloon) && index + 1 < points.length) {
				indexBalloon = overlapSection(indexBalloon, nextBalloon);
				index++;
				count--;
				if(index + 1 == points.length) {
					break;
				}
				nextBalloon = points[index + 1];
			}

			index++;
		}

		return count;
	}

	/**
	 * 判断两个区间是否重叠
	 *
	 * @param section1 区间1
	 * @param section2 区间2
	 * @return 是否重叠
	 */
	public boolean isOverlap(int[] section1, int[] section2) {
		return section1[0] <= section2[1] && section2[0] <= section1[1];
	}

	/**
	 * 得到重叠区间的重叠范围
	 *
	 * @param section1 区间1
	 * @param section2 区间2
	 * @return 重叠范围
	 */
	public int[] overlapSection(int[] section1, int[] section2) {
		return new int[]{Math.max(section1[0], section2[0]), Math.min(section1[1], section2[1])};
	}
}
