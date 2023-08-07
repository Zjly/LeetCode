import java.lang.reflect.Array;
import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * <p>
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 */

public class Question703_KthLargestElementInAStream {
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
		kthLargest.add(2);
		kthLargest.add(1);
		kthLargest.add(-1);
		kthLargest.add(3);
		kthLargest.add(4);
	}
}

class KthLargest {
	// 递减优先队列 递增移除队列
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> movePriorityQueue = new PriorityQueue<>();
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for(int num : nums) {
			priorityQueue.offer(num);
		}
		for(int i = 0; i < k - 1; i++) {
			movePriorityQueue.offer(priorityQueue.poll());
		}
	}

	public int add(int val) {
		// 如果移除队列的最小值大于当前值 则进行下列操作
		if(!movePriorityQueue.isEmpty() && movePriorityQueue.element() < val) {
			priorityQueue.offer(movePriorityQueue.poll());
			movePriorityQueue.offer(val);
		} else {
		    priorityQueue.add(val);
		}

		return priorityQueue.element();
	}
}

/*
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
