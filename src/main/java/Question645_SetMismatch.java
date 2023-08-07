/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */

public class Question645_SetMismatch {
	public static void main(String[] args) {

	}
}

class Solution645 {
	public int[] findErrorNums(int[] nums) {
		int n = nums.length;
		boolean[] isIn = new boolean[n + 1];
		int[] result = new int[2];
		int sum = 0;
		int tSum = (1 + n) * n / 2;
		for(int num : nums) {
			sum += num;
			if(!isIn[num]) {
				isIn[num] = true;
			} else {
				result[0] = num;
			}
		}
		result[1] = result[0] + tSum - sum;
		return result;
	}
}
