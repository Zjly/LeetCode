/**
 * 1704. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 */

public class Question1704_DetermineIfStringHalvesAreAlike {
	public static void main(String[] args) {

	}
}

class Solution1704 {
	public boolean halvesAreAlike(String s) {
		int count = 0;
		for(int i = 0; i < s.length() / 2; i++) {
			char c1 = s.charAt(i);
			if(c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u' || c1 == 'A' || c1 == 'E' || c1 == 'I' || c1 == 'O' || c1 == 'U') {
				count++;
			}

			char c2 = s.charAt(s.length() - 1 - i);
			if(c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u' || c2 == 'A' || c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U') {
				count--;
			}
		}

		return count == 0;
	}
}