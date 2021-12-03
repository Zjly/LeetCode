import java.util.Arrays;

/**
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>
 * 示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 */

public class Question1109_CorporateFlightBookings {
	public static void main(String[] args) {
		Solution1109 solution1109 = new Solution1109();
		int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
		int n = 5;
		System.out.println(Arrays.toString(solution1109.corpFlightBookings(bookings, n)));
	}
}

class Solution1109 {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] diff = new int[n + 1];

		for(int[] booking : bookings) {
			diff[booking[0] - 1] += booking[2];
			diff[booking[1]] -= booking[2];
		}

		int[] result = new int[n];
		result[0] = diff[0];
		for(int i = 1; i < n; i++) {
			result[i] = result[i - 1] + diff[i];
		}

		return result;
	}
}