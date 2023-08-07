/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

public class Question242_ValidAnagram {
	public static void main(String[] args) {
		String s = "nl";
		String t = "cx";

		Solution242 solution242 = new Solution242();
		System.out.println(solution242.isAnagram(s, t));
	}
}

class Solution242 {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}

		// 每个字符的个数用数组存储
		int[] sArray = new int[26];
		int[] tArray = new int[26];

		for(int i = 0; i < s.length(); i++) {
			sArray[s.charAt(i) - 'a']++;
			tArray[t.charAt(i) - 'a']++;
		}

		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i] != tArray[i]) {
				return false;
			}
		}

		return true;
	}
}
