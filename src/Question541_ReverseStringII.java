/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */

public class Question541_ReverseStringII {
	public static void main(String[] args) {

	}
}

class Solution541 {
	public String reverseStr(String s, int k) {
		if(k > s.length()) {
		    k = s.length();
		}

		char[] result = new char[s.length()];
		int index = 0;
		boolean reverse = true;
		while(index < s.length()) {
		    if(reverse) {
		    	int p = index + k - 1;
		    	if(p >= s.length()) {
		    	    p = s.length() - 1;
		    	}
		        for(int i = 0; i < k && index < s.length(); i++) {
		        	result[index] = s.charAt(p);
		        	index++;
		        	p--;
		        }
		    } else {
			    for(int i = 0; i < k && index < s.length(); i++) {
				    result[index] = s.charAt(index);
				    index++;
			    }
		    }
			reverse = !reverse;
		}
		return String.valueOf(result);
	}
}


