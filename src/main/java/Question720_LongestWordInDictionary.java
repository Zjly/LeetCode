/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * <p>
 * 示例 2：
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母。
 */

public class Question720_LongestWordInDictionary {
	public static void main(String[] args) {
		Solution720 solution720 = new Solution720();
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(solution720.longestWord(words));
	}
}

class Solution720 {
	public String longestWord(String[] words) {
		Trie trie = new Trie();
		for(String word : words) {
			trie.insert(word);
		}
		trie.longestWord(trie.root);
		return trie.word;
	}

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word = "";

		TrieNode() {

		}
	}

	static class Trie {
		TrieNode root;
		String word = "";

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode p = root;

			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int cIndex = c - 'a';
				if(p.children[cIndex] == null) {
					p.children[cIndex] = new TrieNode();
				}
				p = p.children[cIndex];
				if(i == word.length() - 1) {
					p.word = word;
				}
			}
		}

		public void longestWord(TrieNode p) {
			if(p != null && (!p.word.equals("") || p == root)) {
				if(p.word.length() > this.word.length()) {
					this.word = p.word;
				}

				for(int i = 0; i < p.children.length; i++) {
					longestWord(p.children[i]);
				}
			}
		}
	}
}