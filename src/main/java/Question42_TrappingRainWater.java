import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */

public class Question42_TrappingRainWater {
	public static void main(String[] args) {
		Solution42 solution42 = new Solution42();
		int[] height = {4, 2, 0, 3, 2, 5};
		System.out.println(solution42.trap(height));
	}
}

class Solution42 {
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int rain = 0;
		for(int i = 0; i < height.length; i++) {
			int currentHeight = height[i];
			while(!stack.empty() && height[stack.peek()] < currentHeight) {
				if(stack.size() == 1) {
				    stack.pop();
				    continue;
				}
				int preIndex = stack.pop();
				int preNextIndex = stack.peek();
				rain += (i - preNextIndex - 1) * (Math.min(height[preNextIndex], height[i]) - height[preIndex]);
			}
			stack.push(i);
		}

		return rain;
	}
}