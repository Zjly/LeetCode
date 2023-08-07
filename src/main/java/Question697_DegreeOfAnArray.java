/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */

public class Question697_DegreeOfAnArray {
	public static void main(String[] args) {

	}
}

class Solution697 {
	public int findShortestSubArray(int[] nums) {
		int[] count = new int[50000];
		int[] firstIndex = new int[50000];
		int maxDegree = 0;
		int minLength = 0;
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if(count[num] == 0) {
			    firstIndex[num] = i;
			}
			count[num]++;

			if(count[num] > maxDegree) {
			    maxDegree = count[num];
			    minLength = i - firstIndex[num] + 1;
			} else if(count[num] == maxDegree && i - firstIndex[num] + 1 < minLength) {
			    minLength = i - firstIndex[num] + 1;
			}
		}

		return minLength;
	}
}
