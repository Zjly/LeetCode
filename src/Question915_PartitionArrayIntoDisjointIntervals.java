/**
 * 915. 分割数组
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 0 <= nums[i] <= 106
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
 */

public class Question915_PartitionArrayIntoDisjointIntervals {
	public static void main(String[] args) {

	}
}

class Solution915 {
	public int partitionDisjoint(int[] nums) {
		int maxLeft = nums[0];
		int maxRight = Integer.MIN_VALUE;
		int minRight = Integer.MAX_VALUE;

		int size = 1;
		int index = 1;
		while(index < nums.length) {
			maxRight = Math.max(maxRight, nums[index]);
		    minRight = Math.min(minRight, nums[index]);
			if(minRight < maxLeft) {
			    size = index + 1;
				maxLeft = Math.max(maxLeft, maxRight);
				maxRight = Integer.MIN_VALUE;
				minRight = Integer.MAX_VALUE;
			}
			index++;
		}

		return size;
	}
}