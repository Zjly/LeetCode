/**
 * 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 */

public class Question1832_CheckIfTheSentenceIsPangram {
	public static void main(String[] args) {

	}
}

class Solution1832 {
	public boolean checkIfPangram(String sentence) {
		int num = 0;
		for(int i = 0; i < sentence.length(); i++) {
			num = num | (1 << (sentence.charAt(i) - 'a'));
		}

		return num == 0x3ffffff;
	}
}