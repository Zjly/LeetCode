/**
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>
 * 注意:
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 */

public class Question477_TotalHammingDistance {
	public static void main(String[] args) {

	}
}

class Solution477 {
	public int totalHammingDistance(int[] nums) {
		int sum = 0;
		int[] bitsOne = new int[32];
		int p = 1;
		for(int num : nums) {
			for(int i = 0; i < 32; i++) {
				if((num & p) == 1) {
				    bitsOne[i]++;
				}
				num >>= 1;
			}
		}

		for(int bitCount : bitsOne) {
			sum += bitCount * (nums.length - bitCount);
		}

		return sum;
	}
}