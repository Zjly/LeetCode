/**
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 */

public class Question342_PowerOfFour {
	public static void main(String[] args) {

	}
}

class Solution342 {
	public boolean isPowerOfFour(int n) {
		int p = n & 0x55555555;
		return n > 0 && p > 0 && (n & (n - 1)) == 0 && (p & (p - 1)) == 0;
	}
}