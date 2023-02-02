import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 * <p>
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */

public class Question1129_ShortestPathWithAlternatingColors {
	public static void main(String[] args) {

	}
}

class Solution1129 {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		HashMap<Integer, ArrayList<Integer>> redEdge = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> blueEdge = new HashMap<>();
		for(int[] edge : redEdges) {
			int begin = edge[0];
			int end = edge[1];
			ArrayList<Integer> arrayList = redEdge.getOrDefault(begin, new ArrayList<>());
			arrayList.add(end);
			redEdge.put(begin, arrayList);
		}

		for(int[] edge : blueEdges) {
			int begin = edge[0];
			int end = edge[1];
			ArrayList<Integer> arrayList = blueEdge.getOrDefault(begin, new ArrayList<>());
			arrayList.add(end);
			blueEdge.put(begin, arrayList);
		}

		boolean[] redArrive = new boolean[n];
		boolean[] blueArrive = new boolean[n];
		redArrive[0] = true;
		blueArrive[0] = true;

		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{0, 0});
		queue.offer(new int[]{0, 1});

		int d = 0;
		while(!queue.isEmpty()) {
		    int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] points = queue.poll();
				int point = points[0];
				int color = points[1];

				// pre is red
				if(color == 0) {
				    ArrayList<Integer> arrayList = blueEdge.getOrDefault(point, new ArrayList<>());
					for(int nextPoint : arrayList) {
						if(!blueArrive[nextPoint]) {
						    distance[nextPoint] = Math.min(distance[nextPoint], d + 1);
							blueArrive[nextPoint] = true;
							queue.offer(new int[]{nextPoint, 1});
						}
					}
				} else {
					ArrayList<Integer> arrayList = redEdge.getOrDefault(point, new ArrayList<>());
					for(int nextPoint : arrayList) {
						if(!redArrive[nextPoint]) {
							distance[nextPoint] = Math.min(distance[nextPoint], d + 1);
							redArrive[nextPoint] = true;
							queue.offer(new int[]{nextPoint, 0});
						}
					}
				}
			}
			d++;
		}

		for(int i = 0; i < distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
			    distance[i] = -1;
			}
		}

		return distance;
	}
}