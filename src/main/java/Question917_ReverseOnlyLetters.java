/**
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 */

public class Question917_ReverseOnlyLetters {
	public static void main(String[] args) {
		Solution917 solution917 = new Solution917();
		String s = "-";
		System.out.println(solution917.reverseOnlyLetters(s));
	}
}

class Solution917 {
	public String reverseOnlyLetters(String s) {
		int left = 0;
		int right = s.length() - 1;

		while(left < s.length() && !isLetter(s.charAt(left))) {
			left++;
		}

		while(right >= 0 && !isLetter(s.charAt(right))) {
			right--;
		}

		char[] chars = s.toCharArray();
		while(left < right) {
			char c = chars[left];
			chars[left] = chars[right];
			chars[right] = c;

			left++;
			while(!isLetter(s.charAt(left))) {
				left++;
			}

			right--;
			while(!isLetter(s.charAt(right))) {
				right--;
			}
		}

		return String.valueOf(chars);
	}

	public boolean isLetter(char c) {
		return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
	}
}