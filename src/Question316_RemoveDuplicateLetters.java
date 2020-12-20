/*
316. 去除重复字母
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

示例 1：
输入：s = "bcabc"
输出："abc"

示例 2：
输入：s = "cbacdcbc"
输出："acdb"


提示：
1 <= s.length <= 104
s 由小写英文字母组成
 */

import java.util.Stack;

public class Question316_RemoveDuplicateLetters {
	public static void main(String[] args) {

	}
}

class Solution316 {
	public String removeDuplicateLetters(String s) {
		int[] lastLocation = new int[26];
		for(int i = 0; i < s.length(); i++) {
			lastLocation[s.charAt(i) - 'a'] = i;
		}

		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(stack.contains(c)) {
			    continue;
			}

			while(!stack.empty() && c < stack.peek() && i < lastLocation[stack.peek() - 'a']) {
			    stack.pop();
			}
			stack.push(c);
		}

		char[] result = new char[stack.size()];
		for(int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return String.valueOf(result);
	}
}
