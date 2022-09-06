import java.util.ArrayList;

/**
 * 828. 统计子串中的唯一字符
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * <p>
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * <p>
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 * <p>
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 * 其中，每一个子串都由独特字符构成。
 * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * 示例 2：
 * <p>
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 * 示例 3：
 * <p>
 * 输入：s = "LEETCODE"
 * 输出：92
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 只包含大写英文字符
 */

public class Question828_CountUniqueCharactersOfAllSubstringsOfAGivenString {
	public static void main(String[] args) {
		Solution828 solution828 = new Solution828();
		String s = "ABA";
		System.out.println(solution828.uniqueLetterString(s));
	}
}

class Solution828 {
	public int uniqueLetterString(String s) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			arrayList.add(new ArrayList<>());
			arrayList.get(i).add(-1);
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			arrayList.get(c - 'A').add(i);
		}

		int count = 0;
		for(int i = 0; i < 26; i++) {
			ArrayList<Integer> list = arrayList.get(i);
			list.add(s.length());
			for(int j = 1; j < list.size() - 1; j++) {
				count += (list.get(j) - list.get(j - 1)) * (list.get(j + 1) - list.get(j));
			}
		}

		return count;
	}
}
