package Explanation;

import java.util.HashMap;
import java.util.Map;

public class EQuestion8 {
	public static void main(String[] args) {
	    Solution solution = new Solution();
	    int result = solution.myAtoi(" -12num");
	    System.out.println(result);
	}
}

class Solution {
	public int myAtoi(String str) {
		Automaton automaton = new Automaton();
		int length = str.length();
		for(int i = 0; i < length; ++i) {
			automaton.get(str.charAt(i));
		}
		return (int)(automaton.sign * automaton.ans);
	}
}

class Automaton {
	public int sign = 1;
	public long ans = 0;
	private String state = "start";
	private Map<String, String[]> table = new HashMap<String, String[]>() {{
		put("start", new String[]{"start", "signed", "in_number", "end"});
		put("signed", new String[]{"end", "end", "in_number", "end"});
		put("in_number", new String[]{"end", "end", "in_number", "end"});
		put("end", new String[]{"end", "end", "end", "end"});
	}};

	public void get(char c) {
		// 获取下一状态
		state = table.get(state)[get_col(c)];
		if("in_number".equals(state)) {
			// 结果加入该字符
			ans = ans * 10 + c - '0';
			// 计算是否溢出
			ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
		} else if("signed".equals(state)) {
			// 返回符号位结果
			sign = c == '+' ? 1 : -1;
		}
	}

	// 返回不同字符的标签
	private int get_col(char c) {
		if(c == ' ') {
			return 0;
		}
		if(c == '+' || c == '-') {
			return 1;
		}
		if(Character.isDigit(c)) {
			return 2;
		}
		return 3;
	}
}