/**
 * 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 * <p>
 * 提示：
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 */

public class Question1035_UncrossedLines {
	public static void main(String[] args) {
		Solution1035 solution1035 = new Solution1035();
		int[] nums1 = {4, 4, 4, 2, 4, 1, 4, 3, 2, 4, 4, 2, 2, 2, 5, 2};
		int[] nums2 = {2, 1, 5, 4, 2, 3, 5, 1, 2, 2};
		System.out.println(solution1035.maxUncrossedLines(nums1, nums2));
	}
}

class Solution1035 {
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int[][] dp = new int[length1 + 1][length2 + 1];

		for(int i = 1; i <= length1; i++) {
			for(int j = 1; j <= length2; j++) {
				if(nums1[i - 1] == nums2[j - 1] && dp[i - 1][j] == dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[length1][length2];
	}
}