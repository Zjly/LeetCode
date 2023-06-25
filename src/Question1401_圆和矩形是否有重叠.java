/**
 * 1401. 圆和矩形是否有重叠
 * 给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
 * <p>
 * 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。
 * <p>
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形存在公共点 (1,0) 。
 * 示例 2 ：
 * <p>
 * 输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 * 示例 3 ：
 * <p>
 * <p>
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= radius <= 2000
 * -104 <= xCenter, yCenter <= 104
 * -104 <= x1 < x2 <= 104
 * -104 <= y1 < y2 <= 104
 */

public class Question1401_圆和矩形是否有重叠 {
}

class Solution1401 {
	public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
		/* 圆心在矩形内部 */
		if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter <= y2) {
			return true;
		}
		/* 圆心在矩形上部 */
		if (x1 <= xCenter && xCenter <= x2 && y2 <= yCenter && yCenter <= y2 + radius) {
			return true;
		}
		/* 圆心在矩形下部 */
		if (x1 <= xCenter && xCenter <= x2 && y1 - radius <= yCenter && yCenter <= y1) {
			return true;
		}
		/* 圆心在矩形左部 */
		if (x1 - radius <= xCenter && xCenter <= x1 && y1 <= yCenter && yCenter <= y2) {
			return true;
		}
		/* 圆心在矩形右部 */
		if (x2 <= xCenter && xCenter <= x2 + radius && y1 <= yCenter && yCenter <= y2) {
			return true;
		}
		/* 矩形左上角 */
		if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
			return true;
		}
		/* 矩形左下角 */
		if (distance(xCenter, yCenter, x1, y1) <= radius * radius) {
			return true;
		}
		/* 矩形右上角 */
		if (distance(xCenter, yCenter, x2, y2) <= radius * radius) {
			return true;
		}
		/* 矩形右下角 */
		if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
			return true;
		}
		/* 无交点 */
		return false;
	}

	public long distance(int ux, int uy, int vx, int vy) {
		return (long)Math.pow(ux - vx, 2) + (long)Math.pow(uy - vy, 2);
	}
}