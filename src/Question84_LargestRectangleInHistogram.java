import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * <p>
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */

public class Question84_LargestRectangleInHistogram {
	public static void main(String[] args) {

	}
}

class Solution84 {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);

		Stack<Integer> mono_stack = new Stack<>();
		for(int i = 0; i < n; ++i) {
			while(!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
				right[mono_stack.peek()] = i;
				mono_stack.pop();
			}
			left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
			mono_stack.push(i);
		}

		int ans = 0;
		for(int i = 0; i < n; ++i) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}
		return ans;
	}
}