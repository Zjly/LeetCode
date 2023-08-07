import java.util.ArrayList;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * 1 <= n <= 104
 */

public class Question279_PerfectSquares {
	public static void main(String[] args) {
		Solution279 solution279 = new Solution279();
		int n = 12;
		System.out.println(solution279.numSquares(n));
	}
}

class Solution279 {
	public int numSquares(int n) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int perfectSquares = 1;
		int index = 1;
		do {
			arrayList.add(perfectSquares);
			index++;
			perfectSquares = index * index;
		} while(perfectSquares <= n);

		int[] dp = new int[n + 1];
		for(int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int pNum : arrayList) {
			for(int i = pNum; i < dp.length; i++) {
				dp[i] = Math.min(dp[i], dp[i - pNum] + 1);
			}
		}

		return dp[n];
	}
}