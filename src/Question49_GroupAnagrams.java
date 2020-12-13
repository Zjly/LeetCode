import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class Question49_GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};
		Solution49 solution49 = new Solution49();
		List<List<String>> result = solution49.groupAnagrams(strs);
		System.out.println(result);
	}
}

class Solution49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, Integer> hashMap = new HashMap<>();

		List<List<String>> result = new ArrayList<>();

		for(String str : strs) {
			int[] charCount = new int[26];
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				charCount[c - 'a']++;
			}

			StringBuilder stringBuilder = new StringBuilder();

			for(int i = 0; i < 26; i++) {
				if(charCount[i] != 0) {
					char thisChar = (char)(i + 'a');
					stringBuilder.append(thisChar).append(charCount[i]);
				}
			}

			String s = stringBuilder.toString();

			if(hashMap.containsKey(s)) {
				result.get(hashMap.get(s)).add(str);
			} else {
				hashMap.put(s, result.size());
				ArrayList<String> arrayList = new ArrayList<>();
				arrayList.add(str);
				result.add(arrayList);
			}
		}

		return result;
	}
}
