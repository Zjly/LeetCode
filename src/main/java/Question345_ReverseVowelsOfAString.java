/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 元音字母不包含字母 "y" 。
 */

public class Question345_ReverseVowelsOfAString {
	public static void main(String[] args) {
		Solution345 solution345 = new Solution345();
		String s = "leetcode";
		System.out.println(solution345.reverseVowels(s));
	}
}

class Solution345 {
	public String reverseVowels(String s) {
		int left = 0;
		int right = s.length() - 1;
		StringBuilder stringBuilder = new StringBuilder(s);
		while(left < right) {
			while(left < s.length() && "AEIOUaeiou".indexOf(s.charAt(left)) < 0) {
				left++;
			}
			while(right >= 0 && "AEIOUaeiou".indexOf(s.charAt(right)) < 0) {
				right--;
			}
			if(left >= s.length() || right < 0) {
			    break;
			}
			stringBuilder.replace(left, left + 1, String.valueOf(s.charAt(right)));
			stringBuilder.replace(right, right + 1, String.valueOf(s.charAt(left)));
			left++;
			right--;
		}

		return stringBuilder.toString();
	}
}