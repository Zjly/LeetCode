/**
 * 1170. 比较字符串最小字母出现频次
 * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 */

public class Question1170_比较字符串最小字母出现频次 {
}

class Solution1170 {
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] counts = new int[11];
		for(String word : words) {
			counts[getScore(word)]++;
		}

		int[] result = new int[queries.length];
		for(int i = 0; i < queries.length; i++) {
			String query = queries[i];
			int score = getScore(query);
			for(int j = score + 1; j < 11; j++) {
				result[i] += counts[j];
			}
		}

		return result;
	}

	private int getScore(String word) {
		int[] counts = new int[26];
		for(int i = 0; i < word.length(); i++) {
			counts[word.charAt(i)  - 'a']++;
		}

		for(int count : counts) {
			if(count != 0) {
				return count;
			}
		}

		return -1;
	}
}