import java.util.HashSet;
import java.util.Set;

/**
 * 762. 二进制表示中质数个计算置位
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * <p>
 * 计算置位位数 就是二进制表示中 1 的个数。
 * <p>
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * 示例 2：
 * <p>
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= left <= right <= 106
 * 0 <= right - left <= 104
 */

public class Question762_PrimeNumberOfSetBitsInBinaryRepresentation {
	public static void main(String[] args) {

	}
}

class Solution762 {
	public int countPrimeSetBits(int left, int right) {
		int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
		Set<Integer> set = new HashSet<>();
		for(int primeNumber : primeNumbers) {
			set.add(primeNumber);
		}
		int count = 0;
		for(int i = left; i <= right; i++) {
			if(set.contains(getNum1(i))) {
				count++;
			}
		}

		return count;
	}

	private int getNum1(int i) {
		int count = 0;
		while(i != 0) {
			i = i & (i - 1);
			count++;
		}
		return count;
	}
}