import java.util.HashMap;

/**
 * 1711. 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * <p>
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * 提示：
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 */

public class Question1711_CountGoodMeals {
	public static void main(String[] args) {
		Solution1711 solution1711 = new Solution1711();
		int[] deliciousness = {2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468};
		System.out.println(solution1711.countPairs(deliciousness));
	}
}

class Solution1711 {
	public int countPairs(int[] deliciousness) {
		long sumCount = 0;

		// 统计每种美味程度的数量
		HashMap<Integer, Integer> deliciousCountHashMap = new HashMap<>();
		for(int delicious : deliciousness) {
			deliciousCountHashMap.put(delicious, deliciousCountHashMap.getOrDefault(delicious, 0) + 1);
		}

		// 对每种美味程度和进行遍历
		int deliciousSum = 1;
		for(int i = 0; i < 22; i++) {
			long count = 0;

			// 寻找每种美味程度的搭配
			for(HashMap.Entry<Integer, Integer> entry : deliciousCountHashMap.entrySet()) {
				int needDeliciousSum = deliciousSum - entry.getKey();
				if(deliciousCountHashMap.containsKey(needDeliciousSum) && entry.getKey() != needDeliciousSum) {
					count += (long)entry.getValue() * deliciousCountHashMap.get(needDeliciousSum);
				}
			}
			count /= 2;
			count = count % (1000000000 + 7);

			// 寻找与自身的搭配
			int needDeliciousSum = deliciousSum / 2;
			if(deliciousCountHashMap.containsKey(needDeliciousSum) && needDeliciousSum != 0) {
				count += (long)deliciousCountHashMap.get(needDeliciousSum) * (deliciousCountHashMap.get(needDeliciousSum) - 1) / 2;
			}
			count = count % (1000000000 + 7);
			sumCount += count;
			sumCount = sumCount % (1000000000 + 7);

			deliciousSum <<= 1;
		}

		return (int)sumCount;
	}
}