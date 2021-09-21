/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */

public class Question58_LengthOfLastWord {
	public static void main(String[] args) {

	}
}

class Solution58 {
	public int lengthOfLastWord(String s) {
		int length = 0;
		int lastLength = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') {
				if(length != 0) {
					lastLength = length;
					length = 0;
				}
			} else {
				length++;
			}
		}

		return length == 0 ? lastLength : length;
	}
}