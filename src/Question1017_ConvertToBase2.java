/**
 * 1017. 负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 */

public class Question1017_ConvertToBase2 {
	public static void main(String[] args) {

	}
}

class Solution1017 {
	public String baseNeg2(int n) {
		if(n == 0) {
		    return "0";
		}

		StringBuilder stringBuilder = new StringBuilder();
		while(n != 0) {
		    int remain = n % -2;

			if(remain == 0 || remain == 1) {
			    n = n / -2;
				stringBuilder.append(remain);
			} else if(remain == -1) {
				n = n / -2 + 1;
				stringBuilder.append(1);
			}
		}

		return stringBuilder.reverse().toString();
	}
}