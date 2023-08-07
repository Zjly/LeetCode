import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class Question10_02_GroupAnagramsLCCI {
	public static void main(String[] args) {

	}
}

class Solution10_02 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, Integer> countIndexHashMap = new HashMap<>();
		int index = 0;
		for(String str : strs) {
			int[] count = new int[26];
			for(int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a']++;
			}
			StringBuilder stringBuilder = new StringBuilder();
			for(int i = 0; i < count.length; i++) {
				stringBuilder.append((char)(i + 'a')).append(count[i]);
			}
			String key = stringBuilder.toString();
			if(countIndexHashMap.containsKey(key)) {
				result.get(countIndexHashMap.get(key)).add(str);
			} else {
			    List<String> list = new ArrayList<>();
			    list.add(str);
			    result.add(list);
			    countIndexHashMap.put(key, index);
			    index++;
			}
		}
		return result;
	}
}
