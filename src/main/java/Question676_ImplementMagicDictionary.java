import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 */

public class Question676_ImplementMagicDictionary {
	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[]{"hello", "hallo"});
		System.out.println(magicDictionary.search("hallo"));
	}
}

class MagicDictionary {
	HashSet<Integer> lengthHashSet;
	TrieNode root;

	public MagicDictionary() {
		lengthHashSet = new HashSet<>();
		root = new TrieNode();
	}

	public void buildDict(String[] dictionary) {
		for(String word : dictionary) {
			lengthHashSet.add(word.length());
			add(word);
		}
	}

	public boolean search(String searchWord) {
		if(!lengthHashSet.contains(searchWord.length())) {
			return false;
		}

		Queue<State> queue = new LinkedList<>();
		queue.add(new State(root));

		for(int i = 0; i < searchWord.length(); i++) {
			char c = searchWord.charAt(i);
			int queueSize = queue.size();

			for(int j = 0; j < queueSize; j++) {
				State state = queue.poll();
				TrieNode p = state.p;

				if(state.change) {
					if(p.children[c - 'a'] != null) {
						p = p.children[c - 'a'];
						queue.add(new State(p, true));
					}
				} else {
					for(int k = 0; k < 26; k++) {
						if(p.children[k] != null) {
							TrieNode q = p.children[k];

							if(k != c - 'a') {
								queue.add(new State(q, true));
							} else {
								queue.add(new State(q, false));
							}
						}
					}
				}
			}
		}

		int queueSize = queue.size();
		for(int i = 0; i < queueSize; i++) {
			State state = queue.poll();
			TrieNode p = state.p;

			if(p.end && state.change) {
				return true;
			}
		}

		return false;
	}

	private void add(String str) {
		TrieNode p = root;

		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(p.children[c - 'a'] == null) {
				p.children[c - 'a'] = new TrieNode();
			}
			p = p.children[c - 'a'];
		}

		p.end = true;
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean end = false;

		TrieNode() {

		}
	}

	class State {
		TrieNode p;
		boolean change;

		State(TrieNode p) {
			this.p = p;
		}

		State(TrieNode p, boolean change) {
			this.p = p;
			this.change = change;
		}
	}
}
