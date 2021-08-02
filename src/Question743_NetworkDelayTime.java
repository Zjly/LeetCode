import java.util.Arrays;
import java.util.HashSet;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 */

public class Question743_NetworkDelayTime {
	public static void main(String[] args) {
		Solution743 solution743 = new Solution743();
		int[][] times =
				{{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}};
		int n = 5;
		int k = 5;
		System.out.println(solution743.networkDelayTime(times, n, k));
	}
}

class Solution743 {
	public int networkDelayTime(int[][] times, int n, int k) {
		int[][] cost = new int[n + 1][n + 1];

		for(int i = 0; i < cost.length; i++) {
			for(int j = 0; j < cost[0].length; j++) {
				cost[i][j] = -1;
			}
		}

		for(int[] time : times) {
			cost[time[0]][time[1]] = time[2];
		}

		int[] minCost = new int[n + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[k] = 0;

		boolean[] isOK = new boolean[n + 1];

		while(true) {
			int minIndex = 0;
			int minValue = Integer.MAX_VALUE;
			for(int i = 1; i < minCost.length; i++) {
				if(isOK[i]) {
					continue;
				}

				if(minCost[i] < minValue) {
					minIndex = i;
					minValue = minCost[i];
				}
			}

			if(minIndex == 0) {
				break;
			}

			isOK[minIndex] = true;
			for(int i = 1; i < cost.length; i++) {
				if(!isOK[i] && cost[minIndex][i] != -1 && minValue + cost[minIndex][i] < minCost[i]) {
					minCost[i] = minValue + cost[minIndex][i];
				}
			}
		}

		int maxCost = Integer.MIN_VALUE;
		for(int i = 1; i < minCost.length; i++) {
			maxCost = Math.max(maxCost, minCost[i]);
		}

		if(maxCost == Integer.MAX_VALUE) {
			return -1;
		}
		return maxCost;
	}
}

