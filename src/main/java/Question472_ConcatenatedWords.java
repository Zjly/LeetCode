import java.util.*;

/**
 * 472. 连接词
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * <p>
 * 示例 2：
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 */

public class Question472_ConcatenatedWords {
	public static void main(String[] args) {
		Solution472 solution472 = new Solution472();
		String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
		System.out.println(solution472.findAllConcatenatedWordsInADict(words));
	}
}

class Solution472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();
		TrieNode root = new TrieNode();
		Arrays.sort(words, Comparator.comparingInt(String::length));
		for(String word : words) {
			if(word.length() == 0) {
				continue;
			}
			if(dfs(root, word, 0)) {
				result.add(word);
			} else {
				add(root, word);
			}
		}
		return result;
	}

	public boolean dfs(TrieNode root, String word, int start) {
		if(word.length() == start) {
			return true;
		}
		TrieNode p = root;
		for(int i = start; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			p = p.children[index];
			if(p == null) {
				return false;
			}
			if(p.isEnd) {
				if(dfs(root, word, i + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	public void add(TrieNode root, String word) {
		TrieNode p = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(p.children[c - 'a'] == null) {
				TrieNode trieNode = new TrieNode();
				p.children[c - 'a'] = trieNode;
			}
			p = p.children[c - 'a'];

			if(i == word.length() - 1) {
				p.isEnd = true;
			}
		}
	}

	static class TrieNode {
		TrieNode[] children;
		boolean isEnd;

		TrieNode() {
			children = new TrieNode[26];
		}
	}
}