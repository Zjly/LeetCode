import java.util.Arrays;

/**
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>
 * 示例 1：
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * <p>
 * 示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 * <p>
 * 提示：
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 */

public class Question1734_DecodeXORedPermutation {
	public static void main(String[] args) {
		Solution1734 solution1734 = new Solution1734();
		int[] encoded = {6, 5, 4, 6};
		System.out.println(Arrays.toString(solution1734.decode(encoded)));
	}
}

class Solution1734 {
	public int[] decode(int[] encoded) {
		int[] perm = new int[encoded.length + 1];

		for(int i = 0; i < encoded.length + 1; i++) {
			perm[0] ^= i + 1;
		}

		for(int i = 1; i < encoded.length; i += 2) {
			perm[0] ^= encoded[i];
		}

		for(int i = 1; i < encoded.length + 1; i++) {
			perm[i] = encoded[i - 1] ^ perm[i - 1];
		}

		return perm;
	}
}