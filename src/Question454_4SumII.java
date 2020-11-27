import java.util.HashMap;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

public class Question454_4SumII {
	public static void main(String[] args) {

	}
}

class Solution454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int result = 0;

		// 创建哈希表和其中个数
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int a : A) {
			for(int b : B) {
				hashMap.put(a + b, hashMap.getOrDefault(a + b, 0) + 1);
			}
		}

		// 计算其中个数
		for(int c : C) {
			for(int d : D) {
				int value = -(c + d);
				if(hashMap.containsKey(value)) {
					result += hashMap.get(value);
				}
			}
		}

		return result;
	}
}
