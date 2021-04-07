/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：1
 */

public class Question153_FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[]{3, -1};
		Solution153 solution153 = new Solution153();
		System.out.println(solution153.findMin(nums));
	}
}

class Solution153 {
	public int findMin(int[] nums) {
		if(nums.length == 1) {
		    return nums[0];
		}

		if(nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}

		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		int numF = nums[0];

		while(left < right) {
			if(mid == 0) {
				left++;
				mid = (left + right) / 2;
				continue;
			}

			int numM = nums[mid];
			int numMM = nums[mid - 1];

			if(numMM > numM) {
				return numM;
			}

			if(numF < numM) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}

		return nums[mid];
	}
}
