/**
 * 1175. 质数排列
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：682289015
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 */

public class Question1175_PrimeArrangements {
	public static void main(String[] args) {
		Solution1175 solution1175 = new Solution1175();
		System.out.println(solution1175.numPrimeArrangements(5));
	}
}

class Solution1175 {
	public int numPrimeArrangements(int n) {
		boolean[] notPrime = new boolean[n + 1];
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i * i <= n; i++) {
			if(notPrime[i]) {
			    continue;
			}
			for(int j = 2; i * j <= n; j++) {
				notPrime[i * j] = true;
			}
		}

		int primeCount = 0;
		for(boolean b : notPrime) {
			if(!b) {
			    primeCount++;
			}
		}

		long MOD = 1000000007;
		long countP = 1;
		long countN = 1;
		for(int i = 2; i <= primeCount; i++) {
			countP = (countP * i) % MOD;
		}

		for(int i = 2; i <= n - primeCount; i++) {
			countN = (countN * i) % MOD;
		}

		return (int)((countP * countN) % MOD);
	}
}