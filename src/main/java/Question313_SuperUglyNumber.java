import java.util.Arrays;

/**
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <p>
 * 示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * <p>
 * 示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * <p>
 * 提示：
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 */

public class Question313_SuperUglyNumber {
	public static void main(String[] args) {
		Solution313 solution313 = new Solution313();
		int n = 12;
		int[] primes = {2, 7, 13, 19};
		System.out.println(solution313.nthSuperUglyNumber(n, primes));
	}
}

class Solution313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int[] indexes = new int[primes.length];
		Arrays.fill(indexes, 1);

		for(int i = 2; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = 0; j < primes.length; j++) {
				dp[i] = Math.min(dp[indexes[j]] * primes[j], dp[i]);
			}

			for(int j = 0; j < primes.length; j++) {
				if(dp[i] == dp[indexes[j]] * primes[j]) {
				    indexes[j]++;
				}
			}
		}

		return dp[n];
	}
}