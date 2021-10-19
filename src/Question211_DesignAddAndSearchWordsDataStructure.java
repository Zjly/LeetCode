import java.util.LinkedList;
import java.util.Queue;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * <p>
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 */

public class Question211_DesignAddAndSearchWordsDataStructure {
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("add");
		wordDictionary.addWord("adds");
		wordDictionary.addWord("adder");
		System.out.println(wordDictionary.search("add."));
	}
}

class WordDictionary {
	Trie trie;

	public WordDictionary() {
		trie = new Trie();
	}

	public void addWord(String word) {
		trie.addWord(word);
	}

	public boolean search(String word) {
		return trie.search(word);
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		public void addWord(String word) {
			TrieNode p = root;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(p.children[c - 'a'] == null) {
					TrieNode trieNode = new TrieNode(c);
					p.children[c - 'a'] = trieNode;
				}
				p = p.children[c - 'a'];

				if(i == word.length() - 1) {
				    p.isEnd = true;
				}
			}
		}

		public boolean search(String word) {
			Queue<TrieNode> queue = new LinkedList<>();
			queue.add(root);
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int size = queue.size();
				if(size == 0) {
				    return false;
				}
				if(c == '.') {
					for(int j = 0; j < size; j++) {
						TrieNode p = queue.poll();
						for(int k = 0; k < 26; k++) {
							if(p.children[k] != null) {
							    queue.offer(p.children[k]);
							}
						}
					}
				} else {
					for(int j = 0; j < size; j++) {
						TrieNode p = queue.poll();
						if(p.children[c - 'a'] != null) {
							queue.offer(p.children[c - 'a']);
						}
					}
				}
			}

			while(queue.size() != 0) {
				TrieNode p = queue.poll();
				if(p.isEnd) {
					return true;
				}
			}

			return false;
		}
	}

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		char c;
		boolean isEnd = false;

		TrieNode() {

		}

		TrieNode(char c) {
			this.c = c;
		}
	}
}

/*
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */