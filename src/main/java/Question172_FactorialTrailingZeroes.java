/**
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 104
 * <p>
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 */

public class Question172_FactorialTrailingZeroes {
	public static void main(String[] args) {

	}
}

class Solution172 {
	public int trailingZeroes(int n) {
		int five = 5;
		int count = 0;
		while(five <= n) {
		    count += n / five;
			five *= 5;
		}

		return count;
	}
}
