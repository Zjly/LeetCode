import java.util.HashMap;

/**
 * 447. 回旋镖的数量
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 */

public class Question447_NumberOfBoomerangs {
	public static void main(String[] args) {
		Solution447 solution447 = new Solution447();
		int[][] points = {{0, 0}, {1, 0}, {2, 0}};
		System.out.println(solution447.numberOfBoomerangs(points));
	}
}

class Solution447 {
	public int numberOfBoomerangs(int[][] points) {
		HashMap<Integer, Integer> distanceCountHashMap;
		int count = 0;
		for(int i = 0; i < points.length; i++) {
			distanceCountHashMap = new HashMap<>();
			for(int j = 0; j < points.length; j++) {
				if(i == j) {
					continue;
				}
				int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
				distanceCountHashMap.put(distance, distanceCountHashMap.getOrDefault(distance, 0) + 1);
			}

			for(HashMap.Entry<Integer, Integer> entry : distanceCountHashMap.entrySet()) {
				if(entry.getValue() >= 2) {
					count += (entry.getValue() - 1) * (entry.getValue());
				}
			}
		}

		return count;
	}
}