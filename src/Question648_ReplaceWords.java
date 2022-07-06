import java.util.List;

/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 */

public class Question648_ReplaceWords {
	public static void main(String[] args) {

	}
}

class Solution648 {
	public String replaceWords(List<String> dictionary, String sentence) {
		Trie trie = new Trie();
		for(String word : dictionary) {
			trie.add(word);
		}


		String[] words = sentence.split(" ");
		for(int i = 0; i < words.length; i++) {
			words[i] = trie.find(words[i]);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			stringBuilder.append(words[i]);
			if(i != words.length - 1) {
				stringBuilder.append(" ");
			}
		}

		return stringBuilder.toString();
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		public void add(String word) {
			TrieNode p = root;

			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(p.children[c - 'a'] == null) {
					p.children[c - 'a'] = new TrieNode();
				}
				p = p.children[c - 'a'];

				if(i == word.length() - 1) {
				    p.end = true;
				}
			}
		}

		public String find(String word) {
			StringBuilder stringBuilder = new StringBuilder();
			TrieNode p = root;

			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(p.children[c - 'a'] == null) {
					return word;
				}

				p = p.children[c - 'a'];
				stringBuilder.append(c);
				if(p.end) {
				    return stringBuilder.toString();
				}
			}

			return word;
		}
	}

	static class TrieNode {
		TrieNode[] children;
		boolean end;

		TrieNode() {
			children = new TrieNode[26];
			end = false;
		}
	}
}