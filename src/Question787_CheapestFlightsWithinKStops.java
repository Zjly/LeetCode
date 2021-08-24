import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 * 示例 1：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * <p>
 * 示例 2：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * 提示：
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 */

public class Question787_CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		Solution787 solution787 = new Solution787();
		int n = 7;
		int[][] flights = {{0, 3, 7}, {4, 5, 3}, {6, 4, 8}, {2, 0, 10}, {6, 5, 6}, {1, 2, 2}, {2, 5, 9}, {2, 6, 8}, {3, 6, 3}, {4, 0, 10}, {4, 6, 8}, {5, 2, 6}, {1, 4, 3}, {4, 1, 6}, {0, 5, 10}, {3, 1, 5}, {4, 3, 1}, {5, 4, 10}, {0, 1, 6}};
		int src = 2;
		int dst = 4;
		int k = 1;
		System.out.println(solution787.findCheapestPrice(n, flights, src, dst, k));
	}
}

class Solution787 {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		if(k > n) {
			k = n;
		}

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[src] = 0;

		for(int i = 0; i < k + 1; i++) {
			int[] ndp = Arrays.copyOf(dp, n);
			for(int[] flight : flights) {
				if(dp[flight[0]] == Integer.MAX_VALUE) {
					continue;
				}
				if(dp[flight[0]] + flight[2] < ndp[flight[1]]) {
					ndp[flight[1]] = dp[flight[0]] + flight[2];
				}
			}
			dp = ndp;
		}

		if(dp[dst] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[dst];
	}
}
