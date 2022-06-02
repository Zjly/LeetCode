/**
 * 829. 连续整数求和
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * <p>
 * 输入: n = 9
 * 输出: 3
 * 解释: 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * <p>
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109
 */

public class Question829_ConsecutiveNumbersSum {
	public static void main(String[] args) {
		Solution829 solution829 = new Solution829();
		System.out.println(solution829.consecutiveNumbersSum(100000002));
	}
}

class Solution829 {
	public int consecutiveNumbersSum(int n) {
		int count = 1;

		int s = n * 2;
		for(int i = 2; i * i <= s; i++) {
			if(s % i == 0 && (s / i - i + 1) % 2 == 0) {
				count++;
			}
		}

		return count;
	}
}