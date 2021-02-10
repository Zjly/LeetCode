/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例 1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */

public class Question567_PermutationInString {
	public static void main(String[] args) {
		Solution567 solution567 = new Solution567();
		String s1 = "ab";
		String s2 = "eidbaooo";
		System.out.println(solution567.checkInclusion(s1, s2));
	}
}

class Solution567 {
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return false;
		}

		int[] count = new int[26];
		for(int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}

		int left = 0;
		int right = s1.length();

		if(isZero(count)) {
		    return true;
		}

		while(right < s2.length()) {
			count[s2.charAt(left) - 'a']++;
			count[s2.charAt(right) - 'a']--;

			if(isZero(count)) {
			    return true;
			}

			left++;
			right++;
		}
		return false;
	}

	public boolean isZero(int[] count) {
		for(int i = 0; i < 26; i++) {
			if(count[i] != 0) {
				return false;
			}
		}

		return true;
	}
}