/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */

public class Question1189_MaximumNumberOfBalloons {
	public static void main(String[] args) {

	}
}

class Solution1189 {
	public int maxNumberOfBalloons(String text) {
		int[] count = new int[26];

		for(int i = 0; i < text.length(); i++) {
			count[text.charAt(i) - 'a']++;
		}

		int maxNumber = 0;
		while(true) {
		    count['a' - 'a'] -= 1;
			count['b' - 'a'] -= 1;
			count['l' - 'a'] -= 2;
			count['o' - 'a'] -= 2;
			count['n' -  'a'] -= 1;

			if(count['a' - 'a'] >= 0 && count['b' - 'a'] >= 0 && count['l' - 'a'] >= 0 && count['o' - 'a'] >= 0 && count['n' -  'a'] >= 0) {
			    maxNumber++;
			} else {
			    break;
			}
		}

		return maxNumber;
	}
}