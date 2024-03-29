import java.util.ArrayList;

/**
 * 1048. 最长字符串链
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * 示例 2:
 * <p>
 * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * 输出：5
 * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * 示例 3:
 * <p>
 * 输入：words = ["abcd","dbqca"]
 * 输出：1
 * 解释：字链["abcd"]是最长的字链之一。
 * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 */

public class Question1048_LongestStringChain {
	public static void main(String[] args) {

	}
}

class Solution1048 {
	public int longestStrChain(String[] words) {
		ArrayList<ArrayList<Word>> wordsLength = new ArrayList<>();
		for(int i = 0; i <= 16; i++) {
			wordsLength.add(new ArrayList<>());
		}

		for(String word : words) {
			wordsLength.get(word.length()).add(new Word(word));
		}

		int maxLength = 1;
		for(int i = 2; i <= 16; i++) {
			ArrayList<Word> currents = wordsLength.get(i);
			ArrayList<Word> pres = wordsLength.get(i - 1);
			for(Word current : currents) {
				for(Word pre : pres) {
					if(chain(pre.s, current.s)) {
					    current.length = Math.max(current.length, pre.length + 1);
						maxLength = Math.max(maxLength, current.length);
					}
				}
			}
		}

		return maxLength;
	}

	public boolean chain(String pre, String current) {
		boolean add = false;
		for(int i = 0; i < pre.length(); i++) {
			 if(!add) {
				if(pre.charAt(i) != current.charAt(i)) {
					add = true;
				}
			}

			if(add) {
				if(pre.charAt(i) != current.charAt(i + 1)) {
					return false;
				}
			}
		}

		return true;
	}
}

class Word {
	String s;
	int length;

	public Word(String s) {
		this.s = s;
		length = 1;
	}
}