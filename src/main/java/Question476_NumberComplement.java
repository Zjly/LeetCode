/**
 * 476. 数字的补数
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 * 提示：
 * 1 <= num < 231
 */

public class Question476_NumberComplement {
	public static void main(String[] args) {
		Solution476 solution476 = new Solution476();
		int num = 5;
		System.out.println(solution476.findComplement(num));
	}
}

class Solution476 {
	public int findComplement(int num) {
		int result = 0;
		boolean begin = false;

		for(int i = 30; i >= 0; i--) {
			if(!begin && ((1 << i) & num) != 0) {
				begin = true;
			}

			if(begin) {
				result = result | ((num & (1 << i)) ^ (1 << i));
			}
		}

		return result;
	}
}