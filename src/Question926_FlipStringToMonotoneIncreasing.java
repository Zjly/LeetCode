/**
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 */

public class Question926_FlipStringToMonotoneIncreasing {
	public static void main(String[] args) {
		Solution926 solution926 = new Solution926();
		String s = "00110";
		System.out.println(solution926.minFlipsMonoIncr(s));
	}
}

class Solution926 {
	public int minFlipsMonoIncr(String s) {
		int[] counts = new int[s.length() + 1];

		// 统计整个字符串中0的数量
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') {
			    count++;
			}
		}
		counts[0] = count;

		// 整体思路 找到一个分界点 使得分界点左边的1的数量+分界点右边的0的数量最小
		// 真妙啊
		for(int i = 0; i < s.length(); i++) {
			// 分界点为i/i+1之间的点

			// 如若i为0 则说明原本的count 即分界点右边的0的数目减少
			if(s.charAt(i) == '0') {
			    count--;
			}
			// 如若i为1 则说明原本的count 即分界点左边的1的数目增加
			else {
			    count++;
			}
			counts[i + 1] = count;
		}

		int result = Integer.MAX_VALUE;
		for(int c : counts) {
			result = Math.min(result, c);
		}

		return result;
	}
}