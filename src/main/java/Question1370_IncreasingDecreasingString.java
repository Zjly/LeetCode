import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * <p>
 * 示例 2：
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * <p>
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * <p>
 * 示例 4：
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * <p>
 * 示例 5：
 * 输入：s = "spo"
 * 输出："ops"
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */

public class Question1370_IncreasingDecreasingString {
	public static void main(String[] args) {
		Solution1370 solution1370 = new Solution1370();
		String result = solution1370.sortString2("aaaabbbbcccc");
		System.out.println(result);
	}
}

class Solution1370 {
	public String sortString(String s) {
		StringBuilder result = new StringBuilder();

		// 创建哈希表
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < 26; i++) {
			hashMap.put((char)('a' + i), 0);
		}

		// 字符个数存入哈希表
		for(int i = 0; i < s.length(); i++) {
			hashMap.replace(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
		}

		removeZero(hashMap);

		// 未完毕循环.
		while(!hashMap.isEmpty()) {
			StringBuilder firstString = new StringBuilder();
			StringBuilder secondString = new StringBuilder();

			// 步骤1-3
			for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
				char c = entry.getKey();
				hashMap.replace(c, entry.getValue() - 1);
				firstString.append(c);
			}

			removeZero(hashMap);

			// 步骤4-6
			for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
				char c = entry.getKey();
				hashMap.replace(c, entry.getValue() - 1);
				secondString.append(c);
			}

			removeZero(hashMap);

			result.append(firstString);
			result.append(secondString.reverse());
		}

		return result.toString();
	}

	/**
	 * 去除哈希表中已经移除完毕的字符
	 *
	 * @param hashMap 哈希表
	 */
	public void removeZero(HashMap<Character, Integer> hashMap) {
		LinkedList<Character> linkedList = new LinkedList<>();

		// 选择出已经移除完毕的字符
		for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() == 0) {
				linkedList.add(entry.getKey());
			}
		}

		// 对键值进行删除
		for(char c : linkedList) {
			hashMap.remove(c);
		}
	}

	public String sortString2(String s) {
		StringBuilder result = new StringBuilder();

		int[] countChar = new int[26];
		for(int i = 0; i < s.length(); i++) {
			countChar[s.charAt(i) - 'a']++;
		}

		while(result.length() != s.length()) {
			for(int i = 0; i < countChar.length; i++) {
				if(countChar[i] != 0) {
					countChar[i]--;
					result.append((char)(i + 'a'));
				}
			}

			for(int i = countChar.length - 1; i >= 0; i--) {
				if(countChar[i] != 0) {
					countChar[i]--;
					result.append((char)(i + 'a'));
				}
			}
		}

		return result.toString();
	}
}
