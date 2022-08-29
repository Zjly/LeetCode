import java.util.Arrays;

/**
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */

public class Question1470_ShuffleTheArray {
	public static void main(String[] args) {
		Solution1470 solution1470 = new Solution1470();
		int[] nums = {0, 1, 2, 3, 4, 5};
		int n = 3;
		System.out.println(Arrays.toString(solution1470.shuffle(nums, n)));
	}
}

class Solution1470 {
	public int[] shuffle(int[] nums, int n) {
		int location = 1;

		while(location < nums.length - 1) {
			int pLocation = location;
			int pNum = nums[pLocation];
			while(pNum > 0) {
				int qLocation;
				if(pLocation < n) {
					qLocation = pLocation * 2;
				} else {
					qLocation = (pLocation - n) * 2 + 1;
				}
				int qNum = nums[qLocation];

				// 替换位置的数
				nums[qLocation] = -pNum;
				pLocation = qLocation;
				pNum = qNum;
			}

			location++;
		}

		for(int i = 1; i < nums.length - 1; i++) {
			nums[i] *= -1;
		}

		return nums;
	}
}