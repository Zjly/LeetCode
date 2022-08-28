/**
 * 793. 阶乘函数后 K 个零
 * f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
 * <p>
 * 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
 * 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 0
 * 输出：5
 * 解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
 * 示例 2：
 * <p>
 * 输入：k = 5
 * 输出：0
 * 解释：没有匹配到这样的 x!，符合 k = 5 的条件。
 * 示例 3:
 * <p>
 * 输入: k = 3
 * 输出: 5
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= k <= 109
 */

public class Question793_PreimageSizeOfFactorialZeroesFunction {
	public static void main(String[] args) {

	}
}

class Solution793 {
	public int preimageSizeFZF(int k) {
		return getMinX(k + 1) - getMinX(k);
	}

	public int getMinX(int k) {
		long left = 0;
		long right = 5L * k;

		while(left <= right) {
		    long mid = (left + right) / 2;
			long fiveCount = get5Count(mid);
			if(fiveCount < k) {
			    left = mid + 1;
			} else {
			    right = mid - 1;
			}
		}

		return (int)left;
	}

	public long get5Count(long n) {
		long five = 5;
		long count = 0;
		while(five <= n) {
			count += n / five;
			five *= 5;
		}

		return count;
	}
}
