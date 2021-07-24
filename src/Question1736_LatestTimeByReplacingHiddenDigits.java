/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * 示例 1：
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * <p>
 * 示例 2：
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * <p>
 * 示例 3：
 * 输入：time = "1?:22"
 * 输出："19:22"
 */

public class Question1736_LatestTimeByReplacingHiddenDigits {
	public static void main(String[] args) {

	}
}

class Solution1736 {
	public String maximumTime(String time) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			char c = time.charAt(i);
			if(c == '?') {
				if(i == 0 && time.charAt(1) >= '4' && time.charAt(1) <= '9') {
					stringBuilder.append(getMaxNum(0, true));
				} else if(i == 1 && (time.charAt(0) == '2' || time.charAt(0) == '?')) {
					stringBuilder.append(getMaxNum(1, true));
				} else {
					stringBuilder.append(getMaxNum(i, false));
				}
			} else {
				stringBuilder.append(c);
			}
		}

		return stringBuilder.toString();
	}

	private char getMaxNum(int index, boolean needConsider) {
		switch(index) {
			case 0:
				if(needConsider) {
				    return '1';
				}
				return '2';
			case 1:
				if(needConsider) {
					return '3';
				}
				return '9';
			case 3:
				return '5';
			default:
				return '9';
		}
	}
}