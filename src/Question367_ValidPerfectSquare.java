/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * <p>
 * 提示：
 * 1 <= num <= 2^31 - 1
 */

public class Question367_ValidPerfectSquare {
	public static void main(String[] args) {

	}
}

class Solution367 {
	public boolean isPerfectSquare(int num) {
		int left = 1;
		int right = 46340;
		int mid;
		int mm;
		while(left <= right) {
			mid = (left + right) / 2;
			mm = mid * mid;
			if(mm > num) {
				right = mid - 1;
			} else if(mm < num) {
				left = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}