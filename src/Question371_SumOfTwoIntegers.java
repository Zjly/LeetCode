/**
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * 提示：
 * -1000 <= a, b <= 1000
 */

public class Question371_SumOfTwoIntegers {
	public static void main(String[] args) {
		Solution371 solution371 = new Solution371();
		int a = -1;
		int b = -2;
		System.out.println(solution371.getSum(a, b));
	}
}

class Solution371 {
	public int getSum(int a, int b) {
		int sum = 0;
		int c = 0;
		for(int i = 0; i < 32; i++) {
			int p = 1 << i;
			int xor = (a ^ b) & p;
			int xorC = (xor ^ (c << i)) & p;
			sum = sum | xorC;

			if(xor == 0) {
				if((a & p) == 0) {
					c = 0;
				} else {
					c = 1;
				}
			}
		}

		return sum;
	}
}