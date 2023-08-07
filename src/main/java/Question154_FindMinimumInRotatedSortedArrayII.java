/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * <p>
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * <p>
 * 说明：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */

public class Question154_FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 0, 1};
		Solution154 solution154 = new Solution154();
		System.out.println(solution154.findMin(nums));
	}
}

class Solution154 {
	public int findMin(int[] nums) {
		if(nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}

		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;

		while(left < right) {
			if(mid == 0) {
				left++;
				mid = (left + right) / 2;
				continue;
			}

			int numM = nums[mid];
			int numMM = nums[mid - 1];
			int numL = nums[left];
			int numR = nums[right];

			if(numMM > numM) {
				return numM;
			}

			if(numL < numR) {
				return numL;
			}

			if(numL < numM) {
				left = mid + 1;
			} else if(numL > numM) {
				right = mid - 1;
			} else {
				left++;
			}
			mid = (left + right) / 2;
		}

		return nums[mid];
	}
}