import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */

public class Question907_SumOfSubarrayMinimums {
	public static void main(String[] args) {

	}
}

class Solution907 {
	public int sumSubarrayMins(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		// 左边第一个小于arr[i]的数
		for(int i = 0; i < arr.length; i++) {
			while(!stack.empty() && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}

			int l = stack.empty() ? -1 : stack.peek();
			left[i] = i - l;
			stack.push(i);
		}

		stack.clear();

		// 右边第一个小于等于arr[i]的数
		for(int i = arr.length - 1; i >= 0; i--) {
			while(!stack.empty() && arr[i] < arr[stack.peek()]) {
				stack.pop();
			}

			int r = stack.empty() ? arr.length : stack.peek();
			right[i] = r - i;
			stack.push(i);
		}

		long result = 0;
		int MOD = 1000000007;
		for(int i = 0; i < arr.length; i++) {
			result = (result + (long)left[i] * right[i] * arr[i]) % MOD;
		}
		return (int)result;
	}
}