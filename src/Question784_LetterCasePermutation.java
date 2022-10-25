import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */

public class Question784_LetterCasePermutation {
	public static void main(String[] args) {

	}
}

class Solution784 {
	public List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();

		bfs(result, s, 0, new StringBuilder());
		return result;
	}

	public void bfs(List<String> result, String s, int index, StringBuilder stringBuilder) {
		if(index == s.length()) {
		    result.add(stringBuilder.toString());
			return;
		}

		char c = s.charAt(index);
		if(c >= '0' && c <= '9') {
		    bfs(result, s, index + 1, new StringBuilder(stringBuilder).append(c));
		} else if(c >= 'a' && c <= 'z') {
			bfs(result, s, index + 1, new StringBuilder(stringBuilder).append(c));
			bfs(result, s, index + 1, new StringBuilder(stringBuilder).append((char)(c - 'a' + 'A')));
		} else {
			bfs(result, s, index + 1, new StringBuilder(stringBuilder).append(c));
			bfs(result, s, index + 1, new StringBuilder(stringBuilder).append((char)(c - 'A' + 'a')));
		}
	}
}