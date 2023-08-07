/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */

public class Question767_ReorganizeString {
	public static void main(String[] args) {
		Solution767 solution767 = new Solution767();
		String S = "rvhrlpiesrrryrbrrrrrxrkirranrrrrbdrrzgasoxrrr";

		System.out.println(solution767.reorganizeString(S));
	}
}

class Solution767 {
	public String reorganizeString(String S) {
		StringBuilder result = new StringBuilder();
		int[] sArray = new int[26];

		// 统计字符数量
		for(int i = 0; i < S.length(); i++) {
			sArray[S.charAt(i) - 'a']++;
		}

		// 添加第一个字符
		int location = findMaxLocation(sArray, -1);
		result.append((char)(location + 'a'));

		// 添加后续字符
		while(result.length() != S.length()) {
			location = findMaxLocation(sArray, result.charAt(result.length() - 1) - 'a');

			// 未找到能够匹配的返回-1
			if(location == -1) {
				return "";
			}
			result.append((char)(location + 'a'));
		}

		return result.toString();
	}

	/**
	 * 寻找剩余数量最多且不与前一个字符相同的字符
	 *
	 * @param sArray   字符数量数组
	 * @param previous 前一个字符
	 * @return 结果字符位置
	 */
	public int findMaxLocation(int[] sArray, int previous) {
		int max = -1;
		int location = -1;

		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i] > max && i != previous && sArray[i] != 0) {
				location = i;
				max = sArray[i];
			}
		}

		if(location == -1) {
			return -1;
		}

		sArray[location]--;

		return location;
	}
}