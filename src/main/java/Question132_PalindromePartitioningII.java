import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 */

public class Question132_PalindromePartitioningII {
	public static void main(String[] args) {
		Solution132 solution132 = new Solution132();
		String s = "aabaab";
		System.out.println(solution132.minCut(s));
	}
}

class Solution132 {
	public int minCut(String s) {
		int n = s.length();
		boolean[][] g = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(g[i], true);
		}

		// 判断[i, j]是否为回文串
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
			}
		}

		int[] f = new int[n];
		Arrays.fill(f, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			if (g[0][i]) {
				f[i] = 0;
			} else {
				// 进行枚举
				for (int j = 0; j < i; ++j) {
					// 其中[0, j]被分割为回文串，当[j+1, i]为回文串时，[0, i]的分隔次数为f[j]的分隔次数+1次，
					// 遍历每个并取其最小值即可
					if (g[j + 1][i]) {
						f[i] = Math.min(f[i], f[j] + 1);
					}
				}
			}
		}

		return f[n - 1];
	}
}

