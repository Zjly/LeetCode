import java.util.HashMap;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */

public class Question888_FairCandySwap {
	public static void main(String[] args) {

	}
}

class Solution888 {
	public int[] fairCandySwap(int[] A, int[] B) {
		int lengthA = A.length;
		int lengthB = B.length;
		int sumA = 0;
		int sumB = 0;

		HashMap<Integer, Integer> hashMapB = new HashMap<>();

		for(int j : A) {
			sumA += j;
		}

		for(int i = 0; i < lengthB; i++) {
			sumB += B[i];
			if(!hashMapB.containsKey(B[i])) {
				hashMapB.put(B[i], i);
			}
		}

		int difference = sumA - (sumA + sumB) / 2;
		for(int j : A) {
			int findValue = j - difference;
			if(hashMapB.containsKey(findValue)) {
				return new int[]{j, findValue};
			}
		}

		return null;
	}
}
