import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * 提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 */

public class Question187_RepeatedDNASequences {
	public static void main(String[] args) {
		Solution187 solution187 = new Solution187();
	}
}

class Solution187 {
	public List<String> findRepeatedDnaSequences(String s) {
		if(s.length() <= 10) {
		    return new ArrayList<>();
		}
		HashMap<String, Boolean> hashMap = new HashMap<>();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s, 0, 10);
		hashMap.put(stringBuilder.toString(), false);
		for(int i = 10; i < s.length(); i++) {
			stringBuilder.deleteCharAt(0);
			stringBuilder.append(s.charAt(i));
			if(hashMap.containsKey(stringBuilder.toString())) {
			    hashMap.put(stringBuilder.toString(), true);
			} else {
			    hashMap.put(stringBuilder.toString(), false);
			}
		}

		List<String> result = new ArrayList<>();
		for(HashMap.Entry<String, Boolean> entry : hashMap.entrySet()) {
			if(entry.getValue()) {
			    result.add(entry.getKey());
			}
		}

		return result;
	}
}