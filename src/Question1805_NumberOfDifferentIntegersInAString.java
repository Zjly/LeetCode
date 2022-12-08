import java.util.HashSet;

/**
 * 1805. 字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * <p>
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * <p>
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * <p>
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 */

public class Question1805_NumberOfDifferentIntegersInAString {
	public static void main(String[] args) {
		Solution1805 solution1805 = new Solution1805();
		String word = "ab000c00";
		System.out.println(solution1805.numDifferentIntegers(word));
	}
}

class Solution1805 {
	public int numDifferentIntegers(String word) {
		HashSet<String> hashSet = new HashSet<>();
		int index = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while(index < word.length()) {
		    char c = word.charAt(index);
			if(c >= '0' && c <= '9') {
			    stringBuilder.append(c);
			} else {
				getString(hashSet, stringBuilder);
				stringBuilder = new StringBuilder();
			}
			index++;
		}

		getString(hashSet, stringBuilder);

		return hashSet.size();
	}

	public void getString(HashSet<String> hashSet, StringBuilder stringBuilder) {
		if(stringBuilder.length() != 0) {
			if(stringBuilder.length() == 1 && stringBuilder.toString().equals("0")) {
				hashSet.add("0");
			} else {
				boolean b = true;
				for(int i = 0; i < stringBuilder.length(); i++) {
					if(stringBuilder.charAt(i) != '0') {
						hashSet.add(stringBuilder.substring(i));
						b = false;
						break;
					}
				}

				if(b) {
				    hashSet.add("0");
				}
			}
		}
	}
}
