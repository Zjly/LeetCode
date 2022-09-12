/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 */

public class Question670_MaximumSwap {
	public static void main(String[] args) {

	}
}

class Solution670 {
	public int maximumSwap(int num) {
		char[] nums = String.valueOf(num).toCharArray();
		for(int i = 0; i < nums.length - 1; i++) {
			char maxNum = '0';
			int maxIndex = -1;
			char charI = nums[i];
			for(int j = i + 1; j < nums.length; j++) {
				char charJ = nums[j];
				if(charJ > charI && charJ >= maxNum) {
					maxNum = charJ;
					maxIndex = j;
				}
			}

			if(maxIndex != -1) {
				nums[i] = maxNum;
				nums[maxIndex] = charI;
				break;
			}
		}

		return Integer.parseInt(String.valueOf(nums));
	}
}