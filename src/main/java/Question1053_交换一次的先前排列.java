import java.util.Arrays;
import java.util.Stack;

/**
 * 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 */

public class Question1053_交换一次的先前排列 {
	public static void main(String[] args) {
		Solution1053 solution1053 = new Solution1053();
		int[] arr = {3, 1, 1, 3};
		System.out.println(Arrays.toString(solution1053.prevPermOpt1(arr)));
	}
}

class Solution1053 {
	public int[] prevPermOpt1(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for(int i = arr.length - 1; i >= 0; i--) {
			int index = -1;
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				index = stack.pop();
			}

			if(index != -1) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				return arr;
			}

			if(stack.isEmpty() || arr[stack.peek()] != arr[i]) {
				stack.push(i);
			} else {
				stack.pop();
				stack.push(i);
			}
		}

		return arr;
	}
}
