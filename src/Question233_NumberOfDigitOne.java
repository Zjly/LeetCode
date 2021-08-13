/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 提示：
 * 0 <= n <= 2 * 109
 */

public class Question233_NumberOfDigitOne {
	public static void main(String[] args) {
		Solution233 solution233 = new Solution233();
		int n = 11;
		System.out.println(solution233.countDigitOne(n));
	}
}

class Solution233 {
	public int countDigitOne(int n) {
		int count = 0;

		int[] search = new int[10];
		for(int i = 0; i < 10; i++) {
			search[i] = i * (int)Math.pow(10, (i - 1));
		}

		int p = n;
		int pow = 0;
		while(p != 0) {
			int num = p % 10;

			if(num == 0) {
				p = p / 10;
				pow++;
			    continue;
			}

			count += num * search[pow];
			if(num == 1) {
				count += n % (int)Math.pow(10, pow) + 1;
			} else {
				count += (int)Math.pow(10, pow);
			}
			p = p / 10;
			pow++;
		}

		return count;
	}
}