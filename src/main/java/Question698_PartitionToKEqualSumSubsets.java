import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 */

public class Question698_PartitionToKEqualSumSubsets {
	public static void main(String[] args) {
		Solution698 solution698 = new Solution698();
		int[] nums = {3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};
		int k = 6;
		System.out.println(solution698.canPartitionKSubsets(nums, k));
	}
}

class Solution698 {
	boolean canPartition = false;
	int count = 0;

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int totalSum = Arrays.stream(nums).sum();
		if(totalSum % k != 0) {
			return false;
		}

		int[] sums = new int[k];
		sums[0] = nums[0];

		partition(nums, 1, sums, totalSum / k);
		System.out.println(count);
		return canPartition;
	}

	public void partition(int[] nums, int index, int[] sums, int num) {
		count++;
		if(canPartition) {
			return;
		}

		if(index == nums.length) {
			for(int sum : sums) {
				if(sum != num) {
					return;
				}
			}
			canPartition = true;
			return;
		}

		boolean addZero = false;
		for(int i = 0; i < sums.length; i++) {
			if(sums[i] + nums[index] <= num) {
				if(sums[i] == 0 && !addZero) {
					sums[i] += nums[index];
					partition(nums, index + 1, sums, num);
					sums[i] -= nums[index];
					addZero = true;
				} else if(sums[i] == 0) {
					continue;
				} else {
					sums[i] += nums[index];
					partition(nums, index + 1, sums, num);
					sums[i] -= nums[index];
				}
			}
		}
	}
}