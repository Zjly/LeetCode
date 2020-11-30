import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */

public class Question34_FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		Solution34 solution34 = new Solution34();
		int[] nums = new int[] {2, 2};
		int target = 3;

		int[] result = solution34.searchRange(nums, target);
		System.out.println(Arrays.toString(result));
	}
}

class Solution34 {
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}

		int left = 0;
		int right = nums.length - 1;
		int mid;
		int location = -1;
		int begin = 0;
		int end = nums.length - 1;

		while(left <= right) {
			mid = (left + right) / 2;
			if(nums[mid] == target) {
				location = mid;
				break;
			} else if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if(location == -1) {
			return new int[]{-1, -1};
		}

		for(int i = location; i >= 0; i--) {
			if(nums[i] != target) {
				begin = i + 1;
				break;
			}
		}

		for(int i = location; i < nums.length; i++) {
			if(nums[i] != target) {
				end = i - 1;
				break;
			}
		}

		return new int[]{begin, end};
	}
}
