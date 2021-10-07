/*
434. 字符串中的单词数
统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

请注意，你可以假定字符串里不包括任何不可打印的字符。

示例:

输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */

public class Question434_NumberOfSegmentsInAString {
	public static void main(String[] args) {

	}
}

class Solution434 {
	public int countSegments(String s) {
		boolean space = true;
		int count = 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') {
			    if(!space) {
			        count++;
			    }
			    space = true;
			} else {
			    space = false;
			}
		}

		if(!space) {
			count++;
		}

		return count;
	}
}