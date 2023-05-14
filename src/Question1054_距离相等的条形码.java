import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 */

public class Question1054_距离相等的条形码 {
	Solution1054 solution1054 = new Solution1054();

	@Test
	public void test1() {
		int[] barcodes = {1, 1, 1, 2, 2, 2};
		System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(barcodes)));
	}
}

class Solution1054 {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] counts = new int[10001];
		for(int num : barcodes) {
			counts[num]++;
		}

		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for(int i = 0; i < counts.length; i++) {
			if(counts[i] != 0) {
				priorityQueue.offer(new int[]{i, counts[i]});
			}
		}

		int[] result = new int[barcodes.length];
		for(int i = 0; i < result.length; i++) {
			int[] first = priorityQueue.poll();
			if(i != 0 && first[0] == result[i - 1]) {
				int[] second = priorityQueue.poll();
				result[i] = second[0];
				second[1]--;
				if(second[1] != 0) {
					priorityQueue.offer(second);
				}
				priorityQueue.offer(first);
			} else {
				result[i] = first[0];
				first[1]--;
				if(first[1] != 0) {
					priorityQueue.offer(first);
				}
			}
		}

		return result;
	}
}