/**
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */

public class Question896_MonotonicArray {
	public static void main(String[] args) {

	}
}

class Solution896 {
	public boolean isMonotonic(int[] A) {
		int sign = 0;
		int i;
		for(i = 0; i < A.length - 1; i++) {
			if(A[i + 1] - A[i] > 0) {
			    sign = 1;
			    break;
			} else if(A[i + 1] - A[i] < 0) {
			    sign = -1;
			    break;
			}
		}

		for(; i < A.length - 1; i++) {
			if(sign == -1 && A[i + 1] - A[i] > 0) {
				return false;
			} else if(sign == 1 && A[i + 1] - A[i] < 0) {
				return false;
			}
		}

		return true;
	}
}