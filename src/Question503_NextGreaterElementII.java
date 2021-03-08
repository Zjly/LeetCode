import java.util.Stack;

public class Question503_NextGreaterElementII {
	public static void main(String[] args) {

	}
}

class Solution503 {
	public int[] nextGreaterElements(int[] nums) {
		int[] nextBigNum = new int[nums.length];
		Stack<int[]> stack = new Stack<>();

		for(int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && stack.peek()[0] < nums[i]) {
				int[] p = stack.pop();
				nextBigNum[p[1]] = nums[i];
			}

			stack.push(new int[]{nums[i], i});
		}

		for(int num : nums) {
			while(!stack.isEmpty() && stack.peek()[0] < num) {
				int[] p = stack.pop();
				nextBigNum[p[1]] = num;
			}
		}

		while(!stack.empty()) {
			int[] p = stack.pop();
			nextBigNum[p[1]] = -1;
		}

		return nextBigNum;
	}
}
