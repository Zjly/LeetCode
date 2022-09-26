/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */

public class Question01_02_CheckPermutationLCCI {
	public static void main(String[] args) {

	}
}

class Solution01_02 {
	public boolean CheckPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
		    return false;
		}

		int[] count = new int[26];
		for(int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}

		for(int i = 0; i < 26; i++) {
			if(count[i] != 0) {
			    return false;
			}
		}

		return true;
	}
}