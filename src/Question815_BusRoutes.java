import java.util.*;

/**
 * 815. 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * <p>
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */

public class Question815_BusRoutes {
	public static void main(String[] args) {
		Solution815 solution815 = new Solution815();
		int[][] routes = {{1, 2, 7}, {3, 6, 7}};
		int source = 1;
		int target = 6;
		System.out.println(solution815.numBusesToDestination(routes, source, target));
	}
}

class Solution815 {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		if(source == target) {
			return 0;
		}

		int maxStop = 0;
		for(int[] route : routes) {
			for(int i : route) {
				maxStop = Math.max(maxStop, i);
			}
		}

		boolean[][] stopBus = new boolean[maxStop + 1][routes.length];

		for(int i = 0; i < routes.length; i++) {
			for(int j = 0; j < routes[i].length; j++) {
				stopBus[routes[i][j]][i] = true;
			}
		}

		int count = 0;
		Queue<Integer> busStopQueue = new LinkedList<>();
		HashSet<Integer> gotBusStop = new HashSet<>();

		gotBusStop.add(source);
		busStopQueue.offer(source);

		while(!busStopQueue.isEmpty()) {
			count++;

			int queueSize = busStopQueue.size();
			for(int i = 0; i < queueSize; i++) {
				int pBusStop = busStopQueue.poll();

				for(int bus = 0; bus < stopBus[0].length; bus++) {
					if(stopBus[pBusStop][bus]) {
						for(int busStop = 0; busStop < stopBus.length; busStop++) {
							if(stopBus[busStop][bus] && !gotBusStop.contains(busStop)) {
								if(busStop == target) {
									return count;
								}
								gotBusStop.add(busStop);
								busStopQueue.offer(busStop);
							}
						}
					}
				}
			}
		}

		return -1;
	}
}