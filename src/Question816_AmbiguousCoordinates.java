import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
 */

public class Question816_AmbiguousCoordinates {
	public static void main(String[] args) {
		Solution816 solution816 = new Solution816();
		String s = "(00011)";
		System.out.println(solution816.ambiguousCoordinates(s));
	}
}

class Solution816 {
	public List<String> ambiguousCoordinates(String s) {
		List<String> result = new ArrayList<>();
		for(int i = 2; i < s.length() - 1; i++) {
			String s1 = s.substring(1, i);
			String s2 = s.substring(i, s.length() - 1);
			List<String> list1 = getSplit(s1);
			List<String> list2 = getSplit(s2);
			if(list1 != null && list2 != null) {
				for(String child1 : list1) {
					for(String child2 : list2) {
						result.add("(" + child1 + ", " + child2 + ")");
					}
				}
			}
		}
		return result;
	}

	public List<String> getSplit(String s) {
		if(s.length() != 1 && s.charAt(0) == '0' && s.charAt(s.length() - 1) == '0') {
			return null;
		}

		StringBuilder stringBuilder = new StringBuilder(s);
		List<String> result = new ArrayList<>();
		int length = s.length();
		if(length == 1) {
			result.add(s);
		} else if(s.charAt(0) == '0') {
			result.add(stringBuilder.insert(1, '.').toString());
		} else if(s.charAt(length - 1) == '0') {
			result.add(stringBuilder.toString());
		} else {
			result.add(stringBuilder.toString());
			for(int i = 1; i < length; i++) {
				result.add(stringBuilder.insert(i, '.').toString());
				stringBuilder.deleteCharAt(i);
			}
		}

		return result;
	}
}
