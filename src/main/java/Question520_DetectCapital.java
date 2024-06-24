/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 */

public class Question520_DetectCapital {
	public static void main(String[] args) {

	}
}

class Solution520 {
	public boolean detectCapitalUse(String word) {
		if(word.length() == 1) {
			return true;
		}

		if(uppercase(word.charAt(0))) {
			if(uppercase(word.charAt(1))) {
				for(int i = 1; i < word.length(); i++) {
					if(lowercase(word.charAt(i))) {
						return false;
					}
				}
			} else {
				for(int i = 1; i < word.length(); i++) {
					if(uppercase(word.charAt(i))) {
						return false;
					}
				}
			}
		} else {
			for(int i = 1; i < word.length(); i++) {
				if(uppercase(word.charAt(i))) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean uppercase(char c) {
		return c >= 'A' && c <= 'Z';
	}

	public boolean lowercase(char c) {
		return c >= 'a' && c <= 'z';
	}
}

/**
 * @author Zhang Lei
 * @date 2024/6/24 10:29
 */
class Solution520_2 {
	public boolean detectCapitalUse(String word) {
		int status = -1;

		if (capitalLetters(word.charAt(0))) {
			// 首字母大写
			status = 0;
		} else {
			// 全小写
			status = 1;
		}

		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (status == 0) {
				if(capitalLetters(c)) {
					// 全大写
					status = 2;
				} else {
					// 首字母大写
					status = 3;
				}
			} else if (status == 1 && !capitalLetters(c)) {
				continue;
			} else if (status == 2 && capitalLetters(c)) {
				continue;
			} else if (status == 3 && !capitalLetters(c)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	private boolean capitalLetters(char c) {
		return c >= 'A' && c <= 'Z';
	}
}