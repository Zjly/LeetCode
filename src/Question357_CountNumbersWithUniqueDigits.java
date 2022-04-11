/**
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 */

public class Question357_CountNumbersWithUniqueDigits {
	public static void main(String[] args) {
		Solution357 solution357 = new Solution357();
		System.out.println(solution357.countNumbersWithUniqueDigits(2));
	}
}

class Solution357 {
	public int countNumbersWithUniqueDigits(int n) {
		int sum = 1;
		for(int i = 1; i <= n; i++) {
			int pSum = 9;
			for(int j = 0; j < i - 1; j++) {
				pSum *= 9 - j;
			}
			sum += pSum;
		}
		return sum;
	}
}