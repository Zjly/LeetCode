import java.util.ArrayList;
import java.util.Arrays;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * <p>
 * 提示：
 * 0 <= n <= 5 * 106
 */

public class Question204_CountPrimes {
	public static void main(String[] args) {
		Solution204 solution204 = new Solution204();

		System.out.println(solution204.countPrimes(5000000));
	}
}

class Solution204 {
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(isPrime[i]) {
				count++;

				if((long)i * i < n) {
					for(int j = i * i; j < n; j += i) {
						isPrime[j] = false;
					}
				}
			}
		}

		return count;
	}
}
