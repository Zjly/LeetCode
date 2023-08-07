/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 */

public class Question509_FibonacciNumber {
	public static void main(String[] args) {
		Solution509 solution509 = new Solution509();
		System.out.println(solution509.fib(30));
	}
}

class Solution509 {
	public int fib(int n) {
		if(n == 0) {
		    return 0;
		}
		if(n == 1 || n == 2) {
			return 1;
		}

		int a = 1;
		int b = 1;
		for(int i = 0; i < n - 2; i++) {
			int p = a;
			a = b;
			b = p + a;
		}

		return b;
	}
}