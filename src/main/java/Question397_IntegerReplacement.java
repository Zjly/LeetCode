/**
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 */

public class Question397_IntegerReplacement {
	public static void main(String[] args) {
		Solution397 solution397 = new Solution397();
		int n = 10000;
		System.out.println(solution397.integerReplacement(n));
	}
}

class Solution397 {
	public int integerReplacement(int n) {
		int count = 0;
		while(n != 1) {
			if(n == 0xffffffff) {
				return 32;
			}
			count++;

			if((n & 1) == 1) {
				if((n & 3) == 3) {
					if(n == 3) {
						n -= 1;
					} else {
						n += 1;
					}
				} else {
					n -= 1;
				}
			} else {
				n = n >> 1;
			}
		}

		return count;
	}
}
