/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 */

public class Question91_DecodeWays {
	public static void main(String[] args) {

	}
}

class Solution91 {
	public int numDecodings(String s) {
		int[] dp = new int[s.length()];

		if(s.charAt(0) == '0') {
		    return 0;
		}

		if(s.length() == 1) {
		    return 1;
		}

		dp[0] = 1;

		if(s.charAt(1) == '0') {
			if(s.charAt(0) > '2') {
				return 0;
			}
			dp[1] = 1;
		} else {
			if(isDecoding(s.charAt(0), s.charAt(1))) {
				dp[1] = 2;
			} else {
				dp[1] = 1;
			}
		}

		for(int i = 2; i < s.length(); i++) {
			char c1 = s.charAt(i - 1);
			char c2 = s.charAt(i);

			if(c1 == '0') {
			    if(c2 == '0') {
			        return 0;
			    }
			    dp[i] = dp[i - 1];
			    continue;
			}

			if(c2 == '0') {
				if(c1 > '2') {
					return 0;
				}
				dp[i] = dp[i - 2];
				continue;
			}

			if(isDecoding(c1, c2)) {
				dp[i] = dp[i - 2] + dp[i - 1];
			} else {
			    dp[i] = dp[i - 1];
			}
		}

		return dp[s.length() - 1];
	}

	private boolean isDecoding(char c1, char c2) {
		if(c1 >= '3') {
		    return false;
		}

		if(c1 == '0') {
		    return false;
		}

		if(c1 == '1') {
		    return true;
		}

		if(c1 == '2') {
			return c2 <= '6';
		}

		return false;
	}
}
