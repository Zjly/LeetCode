import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * 提示：
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */

public class Question976_LargestPerimeterTriangle {
	public static void main(String[] args) {
		Solution976 solution976 = new Solution976();
		int[] A = new int[]{3, 6, 2, 3};
		System.out.println(solution976.largestPerimeter(A));
	}
}

class Solution976 {
	public int largestPerimeter(int[] A) {
		Arrays.sort(A);

		for(int i = A.length - 1; i >= 2; i--) {
			if(A[i] < A[i - 1] + A[i - 2]) {
				return A[i] + A[i - 1] + A[i - 2];
			}
		}

		return 0;
	}
}

