import java.util.Arrays;

/**
 * 1220. 统计元音字母序列的数目
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：68
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 */

public class Question1220_CountVowelsPermutation {
	public static void main(String[] args) {

	}
}

class Solution1220 {
	public int countVowelPermutation(int n) {
		long MOD = 1000000007;

		long[] counts = new long[5];
		Arrays.fill(counts, 1);

		for(int i = 2; i <= n; i++) {
			long[] p = new long[5];
			p[0] = (counts[1] + counts[2] + counts[4]) % MOD;
			p[1] = (counts[0] + counts[2]) % MOD;
			p[2] = (counts[1] + counts[3]) % MOD;
			p[3] = (counts[2]) % MOD;
			p[4] = (counts[2] + counts[3]) % MOD;
			counts = p;
		}

		return (int)((counts[0] + counts[1] + counts[2] + counts[3] + counts[4]) % MOD);
	}
}