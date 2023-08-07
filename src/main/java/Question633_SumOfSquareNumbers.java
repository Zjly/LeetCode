import java.util.HashMap;
import java.util.HashSet;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示：
 * 0 <= c <= 231 - 1
 */

public class Question633_SumOfSquareNumbers {
	public static void main(String[] args) {

	}
}

class Solution633 {
	public boolean judgeSquareSum(int c) {
		int sC = (int)Math.pow(c, 0.5);

		HashSet<Integer> hashSet = new HashSet<>();

		for(int i = 0; i <= sC / 2; i++) {
			int value1 = i * i;
			int value2 = (sC - i) * (sC - i);
			hashSet.add(value1);
			hashSet.add(value2);

			if(hashSet.contains(c - value1)) {
			    return true;
			}
			if(hashSet.contains(c - value2)) {
			    return true;
			}
		}

		return false;
	}
}