import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 */

public class Question1027_LongestArithmeticSubsequence {
	public static void main(String[] args) {

	}
}

class Solution1027 {
	public int longestArithSeqLength(int[] nums) {
		int max = 0;
		ArrayList<HashMap<Integer, Integer>> arrayList = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int numI = nums[i];
			arrayList.add(new HashMap<>());
			for(int j = 0; j < i; j++) {
				int numJ = nums[j];
				int diff = numI - numJ;
				int c = arrayList.get(j).getOrDefault(diff, 1) + 1;
				arrayList.get(i).put(diff, c);
				max = Math.max(max, c);
			}
		}

		return max;
	}

	public int longestArithSeqLength2(int[] nums) {
		int max = 0;
		int[][] dp = new int[nums.length][1001];
		for(int i = 0; i < nums.length; i++) {
			int numI = nums[i];
			for(int j = 0; j < i; j++) {
				int numJ = nums[j];
				int diff = numI - numJ;
				dp[i][diff + 500] = Math.max(dp[i][diff + 500], dp[j][diff + 500] + 1);
				max = Math.max(max, dp[i][diff + 500]);
			}
		}

		return max + 1;
	}
}