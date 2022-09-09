/**
 * 1689. 十-二进制数的最少数目
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * <p>
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = "32"
 * 输出：3
 * 解释：10 + 11 + 11 = 32
 * 示例 2：
 * <p>
 * 输入：n = "82734"
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：n = "27346209830709182346"
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n.length <= 105
 * n 仅由数字组成
 * n 不含任何前导零并总是表示正整数
 */

public class Question1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
	public static void main(String[] args) {

	}
}

class Solution1689 {
	public int minPartitions(String n) {
		int max = 0;
		for(int i = 0; i < n.length(); i++) {
			max = Math.max(max, n.charAt(i) - '0');
		}
		return max;
	}
}