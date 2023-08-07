import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 */

public class Question17_09_GetKthMagicNumberLCCI {
	public static void main(String[] args) {
		Solution17_09 solution17_09 = new Solution17_09();
		int k = 321;
		System.out.println(solution17_09.getKthMagicNumber(k));
	}
}

class Solution17_09 {
	public int getKthMagicNumber(int k) {
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(1L);
		long kNumber = 1;
		Set<Long> set = new HashSet<>();
		int[] nums = {3,5,7};
		for(int i = 0; i < k; i++) {
			kNumber = priorityQueue.poll();

			for(int num : nums) {
				long p = kNumber * num;
				if(!set.contains(p)) {
					priorityQueue.offer(p);
					set.add(p);
				}
			}
		}

		return (int)kNumber;
	}
}