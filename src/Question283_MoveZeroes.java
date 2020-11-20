import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class Question283_MoveZeroes {
	public static void main(String[] args) {
		Solution283 solution283 = new Solution283();
		int[] nums = {0, 1, 0};
		solution283.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}

class Solution283 {
	public void moveZeroes(int[] nums) {
		int zeroPointer = 0;
		int numPointer = 0;

		// 寻找0的位置
		while(zeroPointer < nums.length && nums[zeroPointer] != 0) {
			zeroPointer++;
		}

		// 寻找数字的位置
		while(numPointer < nums.length && (nums[numPointer] == 0 || numPointer < zeroPointer)) {
			numPointer++;
		}

		// 未找到数字或者0
		if(numPointer == nums.length || zeroPointer == nums.length) {
			return;
		}

		while(numPointer < nums.length) {
			// 寻找数字的位置
			while(numPointer < nums.length && nums[numPointer] == 0) {
				numPointer++;
			}

			// 寻找完毕
			if(numPointer == nums.length) {
				return;
			}

			// 进行交换
			nums[zeroPointer] = nums[numPointer];
			nums[numPointer] = 0;
			zeroPointer++;
			numPointer++;
		}
	}
}