import java.util.ArrayList;
import java.util.List;

/**
 * 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 */

public class Question890_FindAndReplacePattern {
	public static void main(String[] args) {

	}
}

class Solution890 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		int length = pattern.length();
		for(String word : words) {
			char[] p2w = new char[26];
			char[] w2p = new char[26];
			boolean isPattern = true;

			for(int i = 0; i < length; i++) {
				char wordChar = word.charAt(i);
				char patternChar = pattern.charAt(i);

				if(p2w[patternChar - 'a'] == 0 && w2p[wordChar - 'a'] == 0) {
					p2w[patternChar - 'a'] = wordChar;
					w2p[wordChar - 'a'] = patternChar;
				} else if(p2w[patternChar - 'a'] == wordChar && w2p[wordChar - 'a'] == patternChar) {

				} else {
					isPattern = false;
					break;
				}
			}

			if(isPattern) {
			    result.add(word);
			}
		}

		return result;
	}
}