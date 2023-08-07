/**
 * 552. 学生出勤记录 II
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：n = 10101
 * 输出：183236316
 */

public class Question552_StudentAttendanceRecordII {
	public static void main(String[] args) {
		Solution552 solution552 = new Solution552();
		System.out.println(solution552.checkRecord(10101));
	}
}

class Solution552 {
	public int checkRecord(int n) {
		long[][] dp = new long[2][3];
		final int MOD = 1000000007;

		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[1][0] = 1;

		for(int i = 1; i < n; i++) {
			long[][] ndp = new long[2][3];
			ndp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
			ndp[0][1] = dp[0][0];
			ndp[0][2] = dp[0][1];
			ndp[1][0] = (dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % MOD;
			ndp[1][1] = dp[1][0];
			ndp[1][2] = dp[1][1];
			dp = ndp;
		}

		return (int)((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % MOD);
	}
}