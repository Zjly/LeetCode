import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 * 示例 1：
 * 输入：a = 2, b = [3]
 * 输出：8
 * <p>
 * 示例 2：
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * <p>
 * 示例 3：
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * <p>
 * 提示：
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 */

public class Question372_SuperPow {
	public static void main(String[] args) {
		Solution372 solution372 = new Solution372();
		int a = 2147483647;
		int[] b = {2, 0, 0};
		System.out.println(solution372.superPow(a, b));
	}
}

class Solution372 {
	public int superPow(int a, int[] b) {
		final int MOD = 1337;
		List<Integer> remainderList = new ArrayList<>();
		Set<Integer> remainderSet = new HashSet<>();

		int remainder = a % MOD;
		while(!remainderSet.contains(remainder)) {
			remainderList.add(remainder);
			remainderSet.add(remainder);
			remainder = (int)(((long)remainder * a) % MOD);
		}

		int remainderListLength = remainderList.size();
		int p = 0;
		for(int num : b) {
			p = (p * 10 + num) % remainderListLength;
		}

		return remainderList.get(p == 0 ? remainderListLength - 1 : p - 1);
	}
}