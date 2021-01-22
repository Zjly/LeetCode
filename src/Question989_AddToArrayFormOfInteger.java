import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */

public class Question989_AddToArrayFormOfInteger {
	public static void main(String[] args) {
		Solution989 solution989 = new Solution989();
		int[] A = new int[]{2,1,5};
		int K = 806;
		System.out.println(solution989.addToArrayForm(A, K));
	}
}

class Solution989 {
	public List<Integer> addToArrayForm(int[] A, int K) {
		int tail = 0;
		int index = A.length - 1;
		while(index >= 0) {
			tail += K % 10;
			K = K / 10;
			if(A[index] + tail >= 10) {
				A[index] += tail - 10;
				tail = 1;
			} else {
				A[index] += tail;
				tail = 0;
			}

			index--;
		}

		int p = K + tail;
		Stack<Integer> stack = new Stack<>();
		while(p != 0) {
			int t = p % 10;
			stack.push(t);
			p = p / 10;
		}

		List<Integer> result = new ArrayList<>();
		while(stack.size() != 0) {
			result.add(stack.pop());
		}
		for(int i : A) {
			result.add(i);
		}
		return result;
	}
}