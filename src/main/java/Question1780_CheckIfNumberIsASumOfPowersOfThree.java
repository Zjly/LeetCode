/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 107
 */

public class Question1780_CheckIfNumberIsASumOfPowersOfThree {
	public static void main(String[] args) {

	}
}

class Solution1780 {
	public boolean checkPowersOfThree(int n) {
		int times = 14348907;

		while(times > 0 && n != 0) {
			if(n == times) {
			    return true;
			} else if(n > times) {
			    n -= times;
			}
			times /= 3;
		}

		return false;
	}
}