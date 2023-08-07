/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */

public class Question389_FindTheDifference {
	public static void main(String[] args) {

	}
}

class Solution389 {
	public char findTheDifference(String s, String t) {
		int[] array = new int[26];

		for(int i = 0; i < s.length(); i++) {
			array[t.charAt(i) - 'a']++;
			array[s.charAt(i) - 'a']--;
		}

		array[t.charAt(t.length() - 1) - 'a']++;

		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
			    return (char)(i + 'a');
			}
		}

		return 'a';
	}
}
