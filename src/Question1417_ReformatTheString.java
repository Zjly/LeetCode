/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 */

public class Question1417_ReformatTheString {
	public static void main(String[] args) {
		Solution1417 solution1417 = new Solution1417();
		String s = "a0b1c2";
		String s1 = "leetcode";
		System.out.println(solution1417.reformat(s1));
	}
}

class Solution1417 {
	public String reformat(String s) {
		int lettersCount = 0;
		int numsCount = 0;
		int[] letters = new int[26];
		int[] nums = new int[10];

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z') {
				lettersCount++;
				letters[c - 'a']++;
			} else if(c >= '0' && c <= '9') {
				numsCount++;
				nums[c - '0']++;
			}
		}

		if(!(lettersCount == numsCount || Math.abs(lettersCount - numsCount) == 1)) {
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();
		int letterIndex = 0;
		int numIndex = 0;
		for(int i = 0; i < Math.min(lettersCount, numsCount); i++) {
			while(letterIndex < 26 && letters[letterIndex] == 0) {
				letterIndex++;
			}

			while(numIndex < 10 && nums[numIndex] == 0) {
				numIndex++;
			}

			if(lettersCount > numsCount) {
				stringBuilder.append((char)(letterIndex + 'a'));
				stringBuilder.append((char)(numIndex + '0'));
			} else {
				stringBuilder.append((char)(numIndex + '0'));
				stringBuilder.append((char)(letterIndex + 'a'));
			}
			letters[letterIndex]--;
			nums[numIndex]--;
		}

		while(letterIndex < 26 && letters[letterIndex] == 0) {
			letterIndex++;
		}

		while(numIndex < 10 && nums[numIndex] == 0) {
			numIndex++;
		}

		if(lettersCount > numsCount) {
			stringBuilder.append((char)(letterIndex + 'a'));
		} else if(lettersCount < numsCount) {
			stringBuilder.append((char)(numIndex + '0'));
		}

		return stringBuilder.toString();
	}
}
