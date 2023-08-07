import java.util.ArrayList;
import java.util.HashMap;

/**
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * 示例 1：
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * <p>
 * 示例 2：
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>
 * 提示：
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 */

public class Question446_ArithmeticSlicesIISubsequence {
	public static void main(String[] args) {
		Solution446 solution446 = new Solution446();
		int[] nums = {0,2000000000,-294967296};
		System.out.println(solution446.numberOfArithmeticSlices(nums));
	}
}

class Solution446 {
	public int numberOfArithmeticSlices(int[] nums) {
		ArrayList<HashMap<Long, ArrayList<Integer>>> indexArraylist = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			HashMap<Long, ArrayList<Integer>> dValueHashMap = new HashMap<>();
			for(int j = 0; j < i; j++) {
				long dValue = (long)nums[i] - (long)nums[j];

				ArrayList<Integer> dValueIndexArraylist = dValueHashMap.getOrDefault(dValue, new ArrayList<>());
				dValueIndexArraylist.add(j);
				dValueHashMap.put(dValue, dValueIndexArraylist);
			}
			indexArraylist.add(dValueHashMap);
		}

		int[][] dp = new int[nums.length][nums.length];
		for(int i = 2; i < nums.length; i++) {
			for(int j = 1; j < i; j++) {
				long dValue = (long)nums[i] - (long)nums[j];
				HashMap<Long, ArrayList<Integer>> dValueHashMap = indexArraylist.get(j);

				if(dValueHashMap.containsKey(dValue)) {
					ArrayList<Integer> dValueIndexArraylist = dValueHashMap.get(dValue);
					for(int index : dValueIndexArraylist) {
						dp[i][j] += dp[j][index] + 1;
					}
				}
			}
		}

		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				sum += dp[i][j];
			}
		}

		return sum;
	}
}