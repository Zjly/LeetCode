/**
 * 423. 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 * <p>
 * 输入：s = "fviefuro"
 * 输出："45"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 */

public class Question423_ReconstructOriginalDigitsFromEnglish {
	public static void main(String[] args) {

	}
}

class Solution423 {
	public String originalDigits(String s) {
		int[] count = new int[26];
		int[] nums = new int[10];

		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}

		// 0 zero z
		nums[0] = count['z' - 'a'];

		// 2 two w
		nums[2] = count['w' - 'a'];

		// 6 six x
		nums[6] = count['x' - 'a'];

		// 8 eight g
		nums[8] = count['g' - 'a'];

		// 3 three h - eight
		nums[3] = count['h' - 'a'] - nums[8];

		// 7 seven s - six
		nums[7] = count['s' - 'a'] - nums[6];

		// 5 five v - seven
		nums[5] = count['v' - 'a'] - nums[7];

		// 4 four f - five
		nums[4] = count['f' - 'a'] - nums[5];

		// 1 one o - zero - two - four
		nums[1] = count['o' - 'a'] - nums[0] - nums[2] - nums[4];

		// 9 nine i - five - six - eight
		nums[9] = count['i' - 'a'] - nums[5] - nums[6] - nums[8];

		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < nums[i]; j++) {
				stringBuilder.append(i);
			}
		}

		return stringBuilder.toString();
	}
}