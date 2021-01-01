import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */

public class Question239_SlidingWindowMaximum {
	public static void main(String[] args) {
		Solution239 solution239 = new Solution239();
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;

		System.out.println(Arrays.toString(solution239.maxSlidingWindow(nums, k)));
	}
}

class Solution239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]));
		int[] result = new int[nums.length - k + 1];
		int resultIndex = 0;

		for(int i = 0; i < k; i++) {
			queue.offer(new int[]{nums[i], i});
		}

		result[resultIndex++] = queue.element()[0];
		for(int i = k; i < nums.length; i++) {
			queue.offer(new int[]{nums[i], i});
			while(queue.element()[1] <= i - k) {
				queue.poll();
			}
			result[resultIndex++] = queue.element()[0];
		}

		return result;
	}
}
