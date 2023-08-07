import java.util.HashSet;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 */

public class Question522_LongestUncommonSubsequenceII {
	public static void main(String[] args) {

	}
}

class Solution522 {
	public int findLUSlength(String[] strs) {
		HashSet<String> onlyOne = new HashSet<>();
		HashSet<String> stringHashSet = new HashSet<>();
		HashSet<String> removed = new HashSet<>();

		for(String str : strs) {
			if(onlyOne.contains(str)) {
				onlyOne.remove(str);
				removed.add(str);
			} else if(!stringHashSet.contains(str)) {
				onlyOne.add(str);
			}

			stringHashSet.add(str);
		}

		int maxLength = -1;
		for(String str : onlyOne) {
			boolean isSubSequence = false;
			for(String remove : removed) {
				isSubSequence = isSubSequence | subSequence(remove, str);
			}

			if(!isSubSequence) {
				maxLength = Math.max(maxLength, str.length());
			}
		}

		return maxLength;
	}

	public boolean subSequence(String s1, String s2) {
		if(s1.length() >= s2.length()) {
			int s2Index = 0;
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) == s2.charAt(s2Index)) {
					s2Index++;
				}

				if(s2Index == s2.length()) {
					return true;
				}
			}
		}

		return false;
	}
}