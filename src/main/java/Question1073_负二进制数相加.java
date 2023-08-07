import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 1073. 负二进制数相加
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * <p>
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。
 * <p>
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 * 示例 2：
 * <p>
 * 输入：arr1 = [0], arr2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：arr1 = [0], arr2 = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * arr1[i] 和 arr2[i] 都是 0 或 1
 * arr1 和 arr2 都没有前导0
 */

public class Question1073_负二进制数相加 {
	Solution1073 solution1073 = new Solution1073();

	@Test
	public void test() {
		int[] arr1 = {0};
		int[] arr2 = {1, 0};
		System.out.println(Arrays.toString(solution1073.addNegabinary(arr1, arr2)));
	}
}

class Solution1073 {
	public int[] addNegabinary(int[] arr1, int[] arr2) {
		int[] result = new int[Math.max(arr1.length, arr2.length) + 2];
		int index1 = arr1.length - 1;
		int index2 = arr2.length - 1;
		int index = result.length - 1;
		while(index1 >= 0 && index2 >= 0) {
			result[index] = arr1[index1] + arr2[index2];
			index--;
			index1--;
			index2--;
		}

		while(index1 >= 0) {
			result[index] = arr1[index1];
			index--;
			index1--;
		}

		while(index2 >= 0) {
			result[index] = arr2[index2];
			index--;
			index2--;
		}

		for(int i = result.length - 1; i >= 0; i--) {
			while(result[i] >= 2) {
			    if(result[i - 1] >= 1) {
					result[i - 1] -= 1;
			    } else {
			        result[i - 1]++;
			        result[i - 2]++;
			    }

				result[i] -= 2;
			}
		}

		int indexX = 0;
		while(indexX < result.length && result[indexX] == 0) {
		    indexX++;
		}

		if(indexX == result.length) {
		    return new int[]{0};
		}

		int[] res = new int[result.length - indexX];
		for(int i = 0; i < res.length; i++) {
			res[i] = result[indexX];
			indexX++;
		}

		return res;
	}
}