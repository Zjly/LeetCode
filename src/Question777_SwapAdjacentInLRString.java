/**
 * 777. 在LR字符串中交换相邻字符
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 */

public class Question777_SwapAdjacentInLRString {
	public static void main(String[] args) {
		Solution777 solution777 = new Solution777();
		String start = "X";
		String end = "L";
		System.out.println(solution777.canTransform(start, end));
	}
}

class Solution777 {
	public boolean canTransform(String start, String end) {
		int length = start.length();

		int LCount = 0;
		int RCount = 0;

		for(int i = 0; i < length; i++) {
			char s = start.charAt(i);
			char e = end.charAt(i);

			if(s == 'L') {
				if(LCount < 0 || RCount != 0) {
				    return false;
				}
			    LCount--;
			} else if(s == 'R') {
				if(LCount != 0) {
				    return false;
				}
			    RCount++;
			}

			if(e == 'L') {
				if(RCount != 0) {
				    return false;
				}
				LCount++;
			} else if(e == 'R') {
				if(RCount < 0 || LCount != 0) {
				    return false;
				}
				RCount--;
			}

			if(LCount < 0 || RCount < 0) {
			    return false;
			}
		}

		return LCount == 0 && RCount == 0;
	}
}