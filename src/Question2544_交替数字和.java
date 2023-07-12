/**
 * 2544. 交替数字和
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */

public class Question2544_交替数字和 {
}

/**
 * @author Zhang Lei
 * @date 2023/7/12 23:15
 */
class Solution2544 {
	public int alternateDigitSum(int n) {
		String s = String.valueOf(n);
		int sum = 0;
		int positive = 1;
		for (int i = 0; i < s.length(); i++) {
			sum += positive * (s.charAt(i) - '0');
			positive = positive * -1;
		}

		return sum;
	}
}