/**
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * <p>
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含字符 "I" 或 "D"
 */

public class Question942_DIStringMatch {
	public static void main(String[] args) {

	}
}

class Solution942 {
	public int[] diStringMatch(String s) {
		int[] result = new int[s.length() + 1];
		int left = 0;
		int right = s.length();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I') {
			    result[i] = left;
				left++;
			} else {
			    result[i] = right;
				right--;
			}
		}

		result[s.length()] = left;
		return result;
	}
}