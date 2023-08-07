/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：
s = "leetcode"
返回 0

s = "loveleetcode"
返回 2


提示：你可以假定该字符串只包含小写字母。
 */

public class Question387_FirstUniqueCharacterInAString {
	public static void main(String[] args) {
		String s = "cc";

		Solution387 solution387 = new Solution387();
		System.out.println(solution387.firstUniqChar(s));
	}
}

class Solution387 {
	public int firstUniqChar(String s) {
		if(s.equals("")) {
			return -1;
		}

		char[] letterSequence = new char[26];
		int[] occurCount = new int[26];
		int[] firstIndex = new int[26];
		int index = 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(occurCount[c - 'a'] == 0) {
				letterSequence[index] = c;
				firstIndex[c - 'a'] = i;
				index++;
			}			
			occurCount[c - 'a']++;
		}

		for(char c : letterSequence) {
			if(c != 0 && occurCount[c - 'a'] == 1) {
				return firstIndex[c - 'a'];
			}
		}

		return -1;
	}
}
