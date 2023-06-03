import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1156. 单字符重复子串的最大长度
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 */

public class Question1156_单字符重复子串的最大长度 {
	Solution1156 solution1156 = new Solution1156();

	@Test
	public void test() {
		String text = "ababa";
		Assertions.assertEquals(3, solution1156.maxRepOpt1(text));
	}
}

class Solution1156 {
	public int maxRepOpt1(String text) {
		int[] totalCounts = new int[26];
		for(int i = 0; i < text.length(); i++) {
			totalCounts[text.charAt(i) - 'a']++;
		}

		int[] counts = new int[26];
		int left = 0;
		int right = 0;
		while(right < text.length()) {
			counts[text.charAt(right) - 'a']++;

			boolean b = false;
			int width = right - left + 1;
			for(int i = 0; i < 26; i++) {
				if(counts[i] == width || (counts[i] == width - 1 && counts[i] != totalCounts[i])) {
				    b = true;
					break;
				}
			}

			if(!b) {
				counts[text.charAt(left) - 'a']--;
			    left++;
			}

			right++;
		}

		return right - left;
	}
}