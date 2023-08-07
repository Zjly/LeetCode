import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */

public class Question295_FindMedianFromDataStream {
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
	}
}

class MedianFinder {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	/** initialize your data structure here. */
	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
	}

	public void addNum(int num) {
		if(maxHeap.size() == 0) {
			maxHeap.add(num);
			return;
		}

		if(num > maxHeap.peek()) {
			minHeap.add(num);
		} else {
			maxHeap.add(num);
		}

		while(minHeap.size() < maxHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
		while(minHeap.size() > maxHeap.size()) {
		    maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if(maxHeap.size() == minHeap.size()) {
		    return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
		    return maxHeap.peek();
		}
	}
}

/*
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */