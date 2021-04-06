/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 * <p>
 * 进阶：
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */

public class Question81_SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] nums = new int[]{3, 1, 2, 2, 2};
		int target = 1;
		Solution81 solution81 = new Solution81();
		System.out.println(solution81.search(nums, target));
	}
}

class Solution81 {
	public boolean search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	private boolean search(int[] nums, int begin, int end, int target) {
		if(begin > end) {
			return false;
		}
		int mid = (begin + end) / 2;
		int numM = nums[mid];
		int numF = nums[begin];

		if(numF == target) {
			return true;
		}

		if(nums[mid] == target) {
			return true;
		} else if(numM < target) {
			if(numM < numF) {
				if(target < numF) {
					return search(nums, mid + 1, end, target);
				} else {
					return search(nums, begin, mid - 1, target);
				}
			} else if(numM > numF) {
				return search(nums, mid + 1, end, target);
			} else {
				boolean l = search(nums, begin, mid - 1, target);
				boolean r = search(nums, mid + 1, end, target);
				return l | r;
			}
		} else if(numM > target) {
			if(numM < numF) {
				return search(nums, begin, mid - 1, target);
			} else if(numM > numF) {
				if(target < numF) {
					return search(nums, mid + 1, end, target);
				} else {
					return search(nums, begin, mid - 1, target);
				}
			} else {
				boolean l = search(nums, begin, mid - 1, target);
				boolean r = search(nums, mid + 1, end, target);
				return l | r;
			}
		}

		return false;
	}
}