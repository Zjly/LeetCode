import java.util.HashMap;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */

public class Question318_MaximumProductOfWordLengths {
	public static void main(String[] args) {

	}
}

class Solution318 {
	public int maxProduct(String[] words) {
		HashMap<Integer, Integer> wordLengthHashMap = new HashMap<>();
		for(String word : words) {
			int wordInt = 0;
			for(int i = 0; i < word.length(); i++) {
				wordInt = wordInt | (1 << (word.charAt(i) - 'a'));
			}
			wordLengthHashMap.put(wordInt, Math.max(wordLengthHashMap.getOrDefault(wordInt, 0), word.length()));
		}

		int maxProduct = 0;
		for(HashMap.Entry<Integer, Integer> entry1 : wordLengthHashMap.entrySet()) {
			for(HashMap.Entry<Integer, Integer> entry2 : wordLengthHashMap.entrySet()) {
				if((entry1.getKey() & entry2.getKey()) == 0) {
					maxProduct = Math.max(entry1.getValue() * entry2.getValue(), maxProduct);
				}
			}
		}

		return maxProduct;
	}
}

class Solution318_2 {
	public int maxProduct(String[] words) {
		int[] wordsBit = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int bit = 0;
			for (int j = 0; j < word.length(); j++) {
				bit = bit | (1 << (word.charAt(j) - 'a'));
			}
			wordsBit[i] = bit;
		}

		int maxProduct = 0;
		for (int i = 0; i < wordsBit.length; i++) {
			for (int j = i + 1; j < wordsBit.length; j++) {
				if ((wordsBit[i] & wordsBit[j]) == 0) {
					maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
				}
			}
		}

		return maxProduct;
	}
}