/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class Question17_21_VolumeOfHistogramLCCI {
	public static void main(String[] args) {
		int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		Solution17_21 solution17_21 = new Solution17_21();
		System.out.println(solution17_21.trap(height));
	}
}

class Solution17_21 {
	public int trap(int[] height) {
		int length = height.length;
		int[] left = new int[length];
		int[] right = new int[length];

		int leftMax = 0;
		for(int i = 0; i < length; i++) {
			left[i] = leftMax;
			leftMax = Math.max(leftMax, height[i]);
		}

		int rightMax = 0;
		for(int i = length - 1; i >= 0; i--) {
			right[i] = rightMax;
			rightMax = Math.max(rightMax, height[i]);
		}

		int result = 0;
		for(int i = 0; i < length; i++) {
			result += Math.max(0, Math.min(left[i], right[i]) - height[i]);
		}

		return result;
	}
}
