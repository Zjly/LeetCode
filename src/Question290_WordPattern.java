import java.util.HashMap;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例 1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */

public class Question290_WordPattern {
	public static void main(String[] args) {

	}
}

class Solution290 {
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> hashMap1 = new HashMap<>();
		HashMap<String, Character> hashmap2 = new HashMap<>();
		String[] strS = s.split(" ");

		if(pattern.length() != strS.length) {
			return false;
		}

		for(int i = 0; i < pattern.length(); i++) {
			char currentPattern = pattern.charAt(i);
			String currentStr = strS[i];

			if(hashMap1.containsKey(currentPattern)) {
				String patternStr = hashMap1.get(currentPattern);
				if(!patternStr.equals(currentStr)) {
					return false;
				}
			} else {
				hashMap1.put(currentPattern, currentStr);
			}

			if(hashmap2.containsKey(currentStr)) {
			    char patternPattern = hashmap2.get(currentStr);
			    if(patternPattern != currentPattern) {
			        return false;
			    }
			} else {
			    hashmap2.put(currentStr, currentPattern);
			}
		}

		return true;
	}
}
