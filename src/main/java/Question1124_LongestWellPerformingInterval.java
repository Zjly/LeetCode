import java.util.HashMap;
import java.util.TreeMap;

/**
 * 1124. 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 */

public class Question1124_LongestWellPerformingInterval {
	public static void main(String[] args) {
		Solution1124 solution1124 = new Solution1124();
		int[] hours = {9,9,6,0,6,6,9};
		System.out.println(solution1124.longestWPI(hours));
	}
}

class Solution1124 {
	public int longestWPI(int[] hours) {
		int length = 0;

		int[] dp = new int[hours.length + 1];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, 0);
		for(int i = 0; i < hours.length; i++) {
			dp[i + 1] = dp[i] + (hours[i] > 8 ? 1 : -1);
		}

		for(int i = 1; i < hours.length + 1; i++) {
			if(dp[i] > 0) {
				length = i;
			} else {
			    if(hashMap.containsKey(dp[i] - 1)) {
				    length = Math.max(length, i - hashMap.get(dp[i] - 1));
			    }
			}

			if(!hashMap.containsKey(dp[i])) {
				hashMap.put(dp[i], i);
			}
		}

		return length;
	}
}
