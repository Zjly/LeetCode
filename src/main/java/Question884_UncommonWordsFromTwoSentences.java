/*
884. 两句话中的不常见单词
句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。

如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。

给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。



示例 1：

输入：s1 = "this apple is sweet", s2 = "this apple is sour"
输出：["sweet","sour"]
示例 2：

输入：s1 = "apple apple", s2 = "banana"
输出：["banana"]


提示：

1 <= s1.length, s2.length <= 200
s1 和 s2 由小写英文字母和空格组成
s1 和 s2 都不含前导或尾随空格
s1 和 s2 中的所有单词间均由单个空格分隔
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Question884_UncommonWordsFromTwoSentences {
	public static void main(String[] args) {

	}
}

class Solution884 {
	public String[] uncommonFromSentences(String s1, String s2) {
		String[] words1 = s1.split(" ");
		String[] words2 = s2.split(" ");

		HashMap<String, int[]> hashMap = new HashMap<>();

		for(String word : words1) {
			int[] count = hashMap.getOrDefault(word, new int[]{0, 0});
			count[0]++;
			hashMap.put(word, count);
		}

		for(String word : words2) {
			int[] count = hashMap.getOrDefault(word, new int[]{0, 0});
			count[1]++;
			hashMap.put(word, count);
		}

		ArrayList<String> result = new ArrayList<>();

		for(HashMap.Entry<String, int[]> entry : hashMap.entrySet()) {
			int[] count = entry.getValue();
			if(count[0] == 1 && count[1] == 0 || count[0] == 0 && count[1] == 1) {
				result.add(entry.getKey());
			}
		}

		return result.toArray(new String[0]);
	}
}