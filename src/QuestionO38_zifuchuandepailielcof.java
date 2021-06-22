import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 */

public class QuestionO38_zifuchuandepailielcof {
	public static void main(String[] args) {
		SolutionO38 solutionO38 = new SolutionO38();
		String s = "abc";
		System.out.println(Arrays.toString(solutionO38.permutation(s)));
	}
}

class SolutionO38 {
	List<String> rec;
	boolean[] vis;

	public String[] permutation(String s) {
		int n = s.length();
		rec = new ArrayList<>();
		vis = new boolean[n];
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		StringBuffer perm = new StringBuffer();
		backtrack(arr, 0, n, perm);
		int size = rec.size();
		String[] recArr = new String[size];
		for(int i = 0; i < size; i++) {
			recArr[i] = rec.get(i);
		}
		return recArr;
	}

	public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
		if(i == n) {
			rec.add(perm.toString());
			return;
		}
		for(int j = 0; j < n; j++) {
			if(vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
				continue;
			}
			vis[j] = true;
			perm.append(arr[j]);
			backtrack(arr, i + 1, n, perm);
			perm.deleteCharAt(perm.length() - 1);
			vis[j] = false;
		}
	}
}

