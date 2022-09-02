import java.util.Arrays;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 */

public class Question646_MaximumLengthOfPairChain {
	public static void main(String[] args) {
		Solution646 solution646 = new Solution646();
		int[][] pairs = {{1, 2}, {2, 3}, {2, 5}, {3, 4}};
		System.out.println(solution646.findLongestChain(pairs));
	}
}

class Solution646 {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> {
			if(a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		int[] dp = new int[pairs.length];
		Arrays.fill(dp, 1);
		for(int i = 1; i < dp.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(pairs[j][1] < pairs[i][0]) {
				    dp[i] = dp[j] + 1;
					break;
				}
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		return dp[dp.length - 1];
	}
}