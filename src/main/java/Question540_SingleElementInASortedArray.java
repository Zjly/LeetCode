/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */

public class Question540_SingleElementInASortedArray {
	public static void main(String[] args) {
		Solution540 solution540 = new Solution540();
		int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
		System.out.println(solution540.singleNonDuplicate(nums));
	}
}

class Solution540 {
	public int singleNonDuplicate(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}

		int left = 0;
		int right = nums.length - 1;
		int mid;

		while(left != right) {
			mid = (left + right) / 2;
			if(mid % 2 == 0) {
				if(nums[mid] == nums[mid - 1]) {
					right = mid - 2;
				} else if(nums[mid] == nums[mid + 1]) {
					left = mid + 2;
				} else {
					return nums[mid];
				}
			} else {
				if(nums[mid] == nums[mid + 1]) {
					right = mid - 1;
				} else if(nums[mid] == nums[mid - 1]) {
					left = mid + 1;
				} else {
					return nums[mid];
				}
			}
		}

		return nums[left];
	}
}