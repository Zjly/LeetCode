/**
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * <p>
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */

public class Question905_SortArrayByParity {
	public static void main(String[] args) {

	}
}

class Solution905 {
	public int[] sortArrayByParity(int[] nums) {
		int indexOdd = 0;
		int indexEven = 0;
		int p;
		while(indexOdd < nums.length && indexEven < nums.length) {
		    while(indexOdd < nums.length && nums[indexOdd] % 2 == 0) {
		        indexOdd++;
		    }

			while(indexEven < nums.length && nums[indexEven] % 2 != 0) {
				indexEven++;
			}

			if(indexOdd < nums.length && indexEven < nums.length && indexOdd < indexEven) {
			    p = nums[indexOdd];
				nums[indexOdd] = nums[indexEven];
				nums[indexEven] = p;
			}

			if(indexOdd > indexEven) {
				indexEven++;
			}
		}

		return nums;
	}
}