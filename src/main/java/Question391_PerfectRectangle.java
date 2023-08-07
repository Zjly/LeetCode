/*
391. 完美矩形
给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。

如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。


示例 1：


输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
输出：true
解释：5 个矩形一起可以精确地覆盖一个矩形区域。
示例 2：


输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
输出：false
解释：两个矩形之间有间隔，无法覆盖成一个矩形。
示例 3：


输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
输出：false
解释：图形顶端留有空缺，无法覆盖成一个矩形。
示例 4：


输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
输出：false
解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。


提示：

1 <= rectangles.length <= 2 * 104
rectangles[i].length == 4
-105 <= xi, yi, ai, bi <= 105
 */

public class Question391_PerfectRectangle {
	public static void main(String[] args) {
		Solution391 solution391 = new Solution391();
		int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
		System.out.println(solution391.isRectangleCover(rectangles));
	}
}

class Solution391 {
	public boolean isRectangleCover(int[][] rectangles) {
		int minX1 = 100001;
		int minY1 = 100001;
		int maxX2 = -100001;
		int maxY2 = -100001;

		int area = 0;

		for(int i = 0; i < rectangles.length; i++) {
			area += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);

			minX1 = Math.min(minX1, rectangles[i][0]);
			minY1 = Math.min(minY1, rectangles[i][1]);
			maxX2 = Math.max(maxX2, rectangles[i][2]);
			maxY2 = Math.max(maxY2, rectangles[i][3]);

			for(int j = i + 1; j < rectangles.length; j++) {
				if(intersect(rectangles[i], rectangles[j])) {
					return false;
				}
			}
		}

		return area == (maxX2 - minX1) * (maxY2 - minY1);
	}

	public boolean intersect(int[] rectangle1, int[] rectangle2) {
		return Math.max(rectangle1[0], rectangle2[0]) < Math.min(rectangle1[2], rectangle2[2]) && Math.max(rectangle1[1], rectangle2[1]) < Math.min(rectangle1[3], rectangle2[3]);
	}
}