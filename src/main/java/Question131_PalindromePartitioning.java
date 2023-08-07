import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */

public class Question131_PalindromePartitioning {
	public static void main(String[] args) {
		Solution131 solution131 = new Solution131();
		String s = "aabbaa";
		System.out.println(solution131.partition(s));
	}
}

class Solution131 {
	boolean[][] f;
	List<List<String>> ret = new ArrayList<List<String>>();
	List<String> ans = new ArrayList<String>();
	int n;

	public List<List<String>> partition(String s) {
		n = s.length();
		f = new boolean[n][n];
		for(int i = 0; i < n; ++i) {
			Arrays.fill(f[i], true);
		}

		// 判断[i, j]是否为回文串
		for(int i = n - 1; i >= 0; --i) {
			for(int j = i + 1; j < n; ++j) {
				f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
			}
		}

		dfs(s, 0);
		return ret;
	}

	public void dfs(String s, int i) {
		if(i == n) {
			ret.add(new ArrayList<>(ans));
			return;
		}

		// 进行递归搜索
		for(int j = i; j < n; ++j) {
			// 子串为回文串
			if(f[i][j]) {
				// 结果内加入子串
				ans.add(s.substring(i, j + 1));
				// 搜索下一部分
				dfs(s, j + 1);
				// 进行回溯
				ans.remove(ans.size() - 1);
			}
		}
	}
}