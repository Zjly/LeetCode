import java.util.Arrays;

/**
 * 1620. 网络信号最好的坐标
 * 给你一个数组 towers 和一个整数 radius 。
 * <p>
 * 数组  towers  中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 * <p>
 * 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
 * <p>
 * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能到达 该坐标的塔的信号强度之和。
 * <p>
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点 (cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * <p>
 * 注意：
 * <p>
 * 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小，需满足以下条件之一：
 * 要么 x1 < x2 ，
 * 要么 x1 == x2 且 y1 < y2 。
 * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
 * 输出：[2,1]
 * 解释：
 * 坐标 (2, 1) 信号强度之和为 13
 * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
 * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
 * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
 * 没有别的坐标有更大的信号强度。
 * 示例 2：
 * <p>
 * 输入：towers = [[23,11,21]], radius = 9
 * 输出：[23,11]
 * 解释：由于仅存在一座信号塔，所以塔的位置信号强度最大。
 * 示例 3：
 * <p>
 * 输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
 * 输出：[1,2]
 * 解释：坐标 (1, 2) 的信号强度最大。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= towers.length <= 50
 * towers[i].length == 3
 * 0 <= xi, yi, qi <= 50
 * 1 <= radius <= 50
 */

public class Question1620_CoordinateWithMaximumNetworkQuality {
	public static void main(String[] args) {
		Solution1620 solution1620 = new Solution1620();
		int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
		int radius = 2;
		System.out.println(Arrays.toString(solution1620.bestCoordinate(towers, radius)));
	}
}

class Solution1620 {
	public int[] bestCoordinate(int[][] towers, int radius) {
		int minX = 50;
		int minY = 50;
		int maxX = 0;
		int maxY = 0;
		for(int[] tower : towers) {
			minX = Math.min(minX, tower[0]);
			minY = Math.min(minY, tower[1]);
			maxX = Math.max(maxX, tower[0]);
			maxY = Math.max(maxY, tower[1]);
		}

		int maxSign = 0;
		int x = 0;
		int y = 0;
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				int sign = 0;

				for(int[] tower : towers) {
					int distance = (tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j);
					if(distance <= radius * radius) {
						sign += (int)Math.floor(1.0 * tower[2] / (1 + Math.sqrt(distance)));
					}
				}

				if(sign > maxSign) {
					maxSign = sign;
					x = i;
					y = j;
				}
			}
		}
		return new int[]{x, y};
	}
}
