/**
 * 1037. 有效的回旋镖
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * <p>
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 */

public class Question1037_ValidBoomerang {
	public static void main(String[] args) {

	}
}

class Solution1037 {
	public boolean isBoomerang(int[][] points) {
		for(int i = 0; i < 3; i++) {
			for(int j = i + 1; j < 3; j++) {
				int[] p1 = points[i];
				int[] p2 = points[j];

				if(p1[0] == p2[0] && p1[1] == p2[1]) {
				    return false;
				}
			}
		}

		int[] point1 = points[0];
		int[] point2 = points[1];
		int[] point3 = points[2];

		double k1;
		if(point1[0] == point2[0]) {
		    k1 = 101;
		} else {
		    k1 = 1.0 * (point1[1] - point2[1]) / (point1[0] - point2[0]);
		}

		double k2;
		if(point1[0] == point3[0]) {
			k2 = 101;
		} else {
			k2 = 1.0 * (point1[1] - point3[1]) / (point1[0] - point3[0]);
		}

		return k1 != k2;
	}
}
