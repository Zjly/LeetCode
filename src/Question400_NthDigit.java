/**
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 */

public class Question400_NthDigit {
	public static void main(String[] args) {
		Solution400 solution400 = new Solution400();
		int n = 9; // 26 -> 2
		System.out.println(solution400.findNthDigit(n));
	}
}

class Solution400 {
	public int findNthDigit(int n) {
		int MAX = 9;
		int[] digitCount = new int[MAX];
		for(int i = 1; i < MAX; i++) {
			digitCount[i] = digitCount[i - 1] + (int)(Math.pow(10, i) - Math.pow(10, i - 1)) * i;
		}

		int index = 0;
		while(index < MAX - 1) {
			if(n > digitCount[index] && n <= digitCount[index + 1]) {
				break;
			}
			index++;
		}

		int remain = n - digitCount[index] - 1;
		int p = remain / (index + 1);
		int q = remain % (index + 1);
		int num = (int)(Math.pow(10, index) + p);

		return (num / (int)(Math.pow(10, index - q))) % 10;
	}
}
