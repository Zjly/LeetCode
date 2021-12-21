import java.util.TreeSet;

/**
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * <p>
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 * 通过次数25,344提交次数72,647
 */

public class Question475_Heaters {
	public static void main(String[] args) {

	}
}

class Solution475 {
	public int findRadius(int[] houses, int[] heaters) {
		TreeSet<Integer> heatersSet = new TreeSet<>();
		for(int heater : heaters) {
			heatersSet.add(heater);
		}

		int minRadius = 0;
		for(int house : houses) {
			int radius = Integer.MAX_VALUE;
			if(heatersSet.floor(house) != null) {
				radius = Math.min(radius, house - heatersSet.floor(house));
			}
			if(heatersSet.ceiling(house) != null) {
				radius = Math.min(radius, heatersSet.ceiling(house) - house);
			}
			minRadius = Math.max(minRadius, radius);
		}

		return minRadius;
	}
}