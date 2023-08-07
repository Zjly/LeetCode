import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 2423. 删除字符使频率相同
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 * 示例 2：
 * <p>
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 */

public class Question2423_RemoveLetterToEqualizeFrequency {
	public static void main(String[] args) {
		Solution2423 solution2423 = new Solution2423();
		System.out.println(solution2423.equalFrequency("aaaabbbbccc"));
	}
}

class Solution2423 {
	public boolean equalFrequency(String word) {
		int[] charCount = new int[26];
		int n = word.length();
		for (int i = 0; i < n; i++) {
			charCount[word.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (charCount[i] == 0) {
				continue;
			}
			charCount[i]--;
			HashSet<Integer> frequency = new HashSet<Integer>();
			for (int f : charCount) {
				if (f > 0) {
					frequency.add(f);
				}
			}
			if (frequency.size() == 1) {
				return true;
			}
			charCount[i]++;
		}
		return false;
	}
}