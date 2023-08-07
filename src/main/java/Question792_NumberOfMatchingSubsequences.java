import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */

public class Question792_NumberOfMatchingSubsequences {
	public static void main(String[] args) {
		Solution792 solution792 = new Solution792();
		String s = "abcde";
		String[] words = {"a", "bb", "acd", "ace"};
		System.out.println(solution792.numMatchingSubseq(s, words));
	}
}

class Solution792 {
	public int numMatchingSubseq(String s, String[] words) {
		int count = 0;
		HashMap<Character, TreeSet<Integer>> hashMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			TreeSet<Integer> treeSet = hashMap.getOrDefault(s.charAt(i), new TreeSet<>());
			treeSet.add(i);
			hashMap.put(s.charAt(i), treeSet);
		}

		for(String w : words) {
			int index = -1;
			boolean b = true;
			for(int i = 0; i < w.length(); i++) {
				char c = w.charAt(i);
				Integer pIndex = hashMap.getOrDefault(c, new TreeSet<>()).higher(index);
				if(pIndex == null) {
					b = false;
					break;
				}

				index = pIndex;
			}

			if(b) {
				count++;
			}
		}

		return count;
	}
}