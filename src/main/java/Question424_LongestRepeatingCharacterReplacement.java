/**
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 10^4。
 * <p>
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */

public class Question424_LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		String s = "AAAA";
		int k = 1;
		Solution424 solution424 = new Solution424();
		System.out.println(solution424.characterReplacement(s, k));
	}
}

class Solution424 {
	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int sLength = s.length();
		int left = 0;
		int right = 0;
		int maxLength = 0;
		while(right < sLength) {
			count[s.charAt(right) - 'A']++;
			maxLength = Math.max(maxLength, count[s.charAt(right) - 'A']);
			if(right - left + 1 - maxLength > k) {
				count[s.charAt(left) - 'A']--;
			    left++;
			}
			right++;
		}
		return right - left;
	}
}
