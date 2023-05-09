/**
 * 2437. 有效时间的数目
 * 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * <p>
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * <p>
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "?5:00"
 * 输出：2
 * 解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
 * 示例 2：
 * <p>
 * 输入：time = "0?:0?"
 * 输出：100
 * 解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
 * 示例 3：
 * <p>
 * 输入：time = "??:??"
 * 输出：1440
 * 解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
 * <p>
 * <p>
 * 提示：
 * <p>
 * time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
 * "00" <= hh <= "23"
 * "00" <= mm <= "59"
 * 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。
 */

public class Question2437_有效时间的数目 {

}

class Solution2437 {
	public int countTime(String time) {
		return getCounts(time.split(":")[0], 2, 3) * getCounts(time.split(":")[1], 5, 9);
	}

	public static int getCounts(String time, int limit1, int limit2) {
		char c1 = time.charAt(0);
		char c2 = time.charAt(1);
		if(c1 == '?' && c2 == '?') {
		    return limit1 * 10 + limit2 + 1;
		} else if(c1 == '?') {
		    int i2 = Integer.parseInt(String.valueOf(c2));
			if(i2 <= limit2) {
			    return limit1 + 1;
			} else {
			    return limit1;
			}
		} else if(c2 == '?') {
		    int i1 = Integer.parseInt(String.valueOf(c1));
			if(i1 == limit1) {
				return limit2 + 1;
			} else {
			    return 10;
			}
		} else {
		    return 1;
		}
	}
}