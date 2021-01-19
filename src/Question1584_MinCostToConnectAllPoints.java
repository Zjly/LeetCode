/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * <p>
 * 示例 2：
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * <p>
 * 示例 3：
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * <p>
 * 示例 4：
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * <p>
 * 示例 5：
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 */

public class Question1584_MinCostToConnectAllPoints {
	public static void main(String[] args) {

	}
}

class Solution1584 {
	public int minCostConnectPoints(int[][] points) {
		int result = 0;

		int pointsLength = points.length;
		int[][] matrix = new int[pointsLength][pointsLength];
		int[] cost = new int[pointsLength];
		int[] isAppend = new int[pointsLength];

		for(int i = 0; i < pointsLength - 1; i++) {
			for(int j = i + 1; j < pointsLength; j++) {
				int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				matrix[i][j] = distance;
				matrix[j][i] = distance;
			}
		}

		isAppend[0] = -1;
		for(int i = 1; i < pointsLength; i++) {
			cost[i] = matrix[0][i];
		}

		for(int i = 1; i < pointsLength; i++) {
			int index = -1;
			int minLength = Integer.MAX_VALUE;
			
			for(int j = 0; j < pointsLength; j++) {
				if(isAppend[j] != -1 && cost[j] < minLength) {
				    index = j;
				    minLength = cost[j];
				}
			}

			result += minLength;
			isAppend[index] = -1;
			cost[index] = 0;
			
			for(int j = 0; j < pointsLength; j++) {
				int costIndexToAppend = matrix[j][index];
				if(isAppend[j] != -1 && costIndexToAppend < cost[j]) {
					cost[j] = costIndexToAppend;
				}
			}
		}

		return result;
	}
}