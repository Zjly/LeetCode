/**
 * 507. 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 * <p>
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：num = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 108
 */

public class Question507_PerfectNumber {
	public static void main(String[] args) {

	}
}

class Solution507 {
	public boolean checkPerfectNumber(int num) {
		int sum = 0;
		for(int i = 1; i * i <= num; i++) {
			if(num % i == 0) {
				if(i != num) {
					sum += i;
				}
				if(i * i != num && i != 1) {
				    sum += num / i;
				}
			}
		}

		return sum == num;
	}
}