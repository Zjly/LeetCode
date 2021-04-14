/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */

public class Question208_ImplementTrie {
	public static void main(String[] args) {

	}
}

class TrieNode {
	TrieNode parent;
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;

	TrieNode() {

	}

	TrieNode(TrieNode parent) {
		this.parent = parent;
	}
}

class Trie {
	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode p = root;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int cIndex = c - 'a';
			if(p.children[cIndex] == null) {
				p.children[cIndex] = new TrieNode(p);
			}
			p = p.children[cIndex];
			if(i == word.length() - 1) {
				p.isEnd = true;
			}
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode p = root;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int cIndex = c - 'a';
			if(p.children[cIndex] == null) {
				return false;
			}
			p = p.children[cIndex];
			if(i == word.length() - 1 && !p.isEnd) {
			    return false;
			}
		}

		return true;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode p = root;

		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			int cIndex = c - 'a';
			if(p.children[cIndex] == null) {
				return false;
			}
			p = p.children[cIndex];
		}

		return true;
	}
}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
